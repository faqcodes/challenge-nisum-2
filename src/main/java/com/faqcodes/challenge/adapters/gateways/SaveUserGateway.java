package com.faqcodes.challenge.adapters.gateways;

import java.util.ArrayList;

import com.faqcodes.challenge.adapters.gateways.db.PhoneData;
import com.faqcodes.challenge.adapters.gateways.db.UserData;
import com.faqcodes.challenge.adapters.gateways.db.UserRepository;
import com.faqcodes.challenge.models.UserModel;

public class SaveUserGateway implements SaveUser {

  private final UserRepository repository;

  public SaveUserGateway(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public boolean save(UserModel model) throws Exception {

    final var phoneData = new ArrayList<PhoneData>();

    model.getPhones().forEach(
        phone -> phoneData.add(
            new PhoneData(
                phone.getNumber(),
                phone.getCitycode(),
                phone.getCountrycode())));

    var userData = new UserData(
        model.getId(),
        model.getCreated(),
        model.getModified(),
        model.getLastlogin(),
        model.getToken(),
        model.getName(),
        model.getEmail(),
        model.getPassword(),
        phoneData,
        model.isActive());

    if (repository.existsByEmail(model.getEmail()))
      throw new Exception("El correo ya se encuentra registrado");

    var user = repository.save(userData);

    return user != null;
  }

}
