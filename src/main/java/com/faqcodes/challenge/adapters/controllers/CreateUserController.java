package com.faqcodes.challenge.adapters.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faqcodes.challenge.models.ResponseMessage;
import com.faqcodes.challenge.models.UserInputModel;
import com.faqcodes.challenge.models.UserOutputModel;
import com.faqcodes.challenge.usecases.UseCase;

@RestController
@RequestMapping("/api")
public class CreateUserController {

  @Value("${validation.passwordRegex}")
  String passwordRegex;

  UseCase<UserInputModel, UserOutputModel> createUserUseCase;

  public CreateUserController(UseCase<UserInputModel, UserOutputModel> createUserUseCase) {
    this.createUserUseCase = createUserUseCase;
  }

  @PostMapping("/signup")
  public ResponseEntity<?> signup(@RequestBody UserInputModel userInputModel) {
    // Se asigna validación de password Regex
    userInputModel.setPasswordRegex(passwordRegex);

    var response = createUserUseCase.execute(userInputModel);

    if (response.getData() == null) {
      return ResponseEntity.badRequest().body(response);
    }

    return ResponseEntity.created(URI.create("")).body(response.getData());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseMessage<?>> handleException() {
    var response = new ResponseMessage<>("Hubo un error al obtener el recurso", null);

    return ResponseEntity.badRequest().body(response);
  }
}
