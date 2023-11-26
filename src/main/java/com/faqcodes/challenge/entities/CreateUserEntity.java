package com.faqcodes.challenge.entities;

import java.time.LocalDateTime;
import java.util.List;

public class CreateUserEntity implements CreateUser {

  @Override
  public User create(String id, String token, String name, String email, String password, List<Phone> phones) {

    final var created = LocalDateTime.now();
    final var modified = LocalDateTime.now();
    final var lastlogin = LocalDateTime.now();
    final var isactive = true;

    return new UserEntity(id, created, modified, lastlogin, token, name, email, password, phones, isactive);
  }

}
