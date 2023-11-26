package com.faqcodes.challenge;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.faqcodes.challenge.entities.Phone;
import com.faqcodes.challenge.entities.UserEntity;

public class ChallengeEntityTests {

  private String id;
  private LocalDateTime created;
  private LocalDateTime modified;
  private LocalDateTime lastlogin;
  private String token;
  private String name;
  private String email;
  private String password;
  private List<Phone> phones;
  private boolean isactive;

  @BeforeEach
  void initialize() {
    id = "1";
    created = LocalDateTime.now();
    modified = LocalDateTime.now();
    lastlogin = LocalDateTime.now();
    token = "token";
    name = "name";
    email = "email@example.com";
    password = "password";
    phones = new ArrayList<>();
    isactive = true;
  }

  @Test
  void given_Email_when_EmailIsNotValid_thenFalse() {
    email = "un_email_malo@.com";

    var user = new UserEntity(id, created, modified, lastlogin, token, name, email, password, phones, isactive);

    assertThat(user.isEmailValid()).isFalse();
  }

  @Test
  void given_Email_when_EmailIsValid_thenTrue() {
    email = "name@dominio.com";

    var user = new UserEntity(id, created, modified, lastlogin, token, name, email, password, phones, isactive);

    assertThat(user.isEmailValid()).isTrue();
  }

  @Test
  void given_Password_when_PasswordIsNotValid_thenFalse() {
    password = "";

    var user = new UserEntity(id, created, modified, lastlogin, token, name, email, password, phones, isactive);

    assertThat(user.isPasswordValid()).isFalse();
  }

  @Test
  void given_Password_when_PasswordIsValid_thenTrue() {
    password = "password_no_vacio";

    var user = new UserEntity(id, created, modified, lastlogin, token, name, email, password, phones, isactive);

    assertThat(user.isPasswordValid()).isTrue();
  }
}
