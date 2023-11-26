package com.faqcodes.challenge.usecases;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import com.faqcodes.challenge.adapters.gateways.SaveUser;
import com.faqcodes.challenge.adapters.presenters.Presenter;
import com.faqcodes.challenge.adapters.security.SecurityToken;
import com.faqcodes.challenge.entities.CreatePhone;
import com.faqcodes.challenge.entities.CreateUser;
import com.faqcodes.challenge.entities.Phone;
import com.faqcodes.challenge.models.PhoneModel;
import com.faqcodes.challenge.models.ResponseMessage;
import com.faqcodes.challenge.models.UserInputModel;
import com.faqcodes.challenge.models.UserModel;
import com.faqcodes.challenge.models.UserOutputModel;

public class CreateUserUseCase implements UseCase<UserInputModel, UserOutputModel> {

  private final CreateUser createUser;
  private final CreatePhone createPhone;
  private final SaveUser repository;
  private final SecurityToken securityToken;
  private final Presenter<UserInputModel, UserOutputModel> presenter;

  public CreateUserUseCase(
      CreateUser createUser,
      CreatePhone createPhone,
      SaveUser repository,
      SecurityToken securityToken,
      Presenter<UserInputModel, UserOutputModel> presenter) {
    this.createUser = createUser;
    this.createPhone = createPhone;
    this.repository = repository;
    this.securityToken = securityToken;
    this.presenter = presenter;
  }

  @Override
  public ResponseMessage<UserOutputModel> execute(UserInputModel inputModel) {
    // Get ID
    final var id = UUID.randomUUID().toString();

    // Get Token
    final var claims = Map.of("uid", (Object) id); // add some claims
    final var token = securityToken.generateToken(claims, inputModel.getEmail());

    // Create Phone Entity: map phone model to phone entity
    final var phones = new ArrayList<Phone>();
    inputModel.getPhones().forEach(
        phone -> phones.add(
            createPhone.create(
                phone.getNumber(),
                phone.getCitycode(),
                phone.getCountrycode())));

    // Create User Entity
    final var user = createUser.create(
        id,
        token,
        inputModel.getName(),
        inputModel.getEmail(),
        inputModel.getPassword(),
        phones);

    // -----------------------------------------------
    // Validate User Entity Business Rules
    // -----------------------------------------------
    if (!user.isPasswordValid()) {
      return presenter.errorResponse("La contraseña no puede estar vacía", inputModel);
    }

    if (!user.isEmailValid()) {
      return presenter.errorResponse("El correo electrónico no tiene el formato correcto", null);
    }

    // -----------------------------------------------
    // Validate User Application Rules
    // -----------------------------------------------

    // Validate password format
    var isPasswordValid = user.patternMatches(inputModel.getPassword(), inputModel.getPasswordRegex());
    if (!isPasswordValid) {
      return presenter.errorResponse("La contraseña no tiene el formato correcto", null);
    }

    // Create Phone Data: map phone model to phone data
    final var phoneModel = new ArrayList<PhoneModel>();
    inputModel.getPhones().forEach(
        phone -> phoneModel.add(
            new PhoneModel(
                phone.getNumber(),
                phone.getCitycode(),
                phone.getCountrycode())));

    // Create User Data
    final var userData = new UserModel(
        id,
        user.getCreated(),
        user.getModified(),
        user.getLastlogin(),
        token,
        user.getName(),
        user.getEmail(),
        user.getPassword(),
        phoneModel,
        user.isActive());

    try {
      // Save User
      repository.save(userData);
    } catch (Exception e) {
      // Return error information
      return presenter.errorResponse(e.getMessage(), null);
    }

    // Create output Data
    final var outputModel = new UserOutputModel(
        id,
        user.getCreated(),
        user.getModified(),
        user.getLastlogin(),
        token,
        user.isActive());

    // Return success information
    return presenter.successResponse("El usuario se ha creado satisfactoriamente", outputModel);
  }

}
