package com.faqcodes.challenge.models;

import java.time.LocalDateTime;
import java.util.List;

public class UserModel {

  private final String id;
  private final LocalDateTime created;
  private final LocalDateTime modified;
  private final LocalDateTime lastlogin;
  private final String name;
  private final String email;
  private final String password;
  private final List<PhoneModel> phones;
  private final String token;
  private final boolean isactive;

  public String getId() {
    return id;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public LocalDateTime getModified() {
    return modified;
  }

  public LocalDateTime getLastlogin() {
    return lastlogin;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public List<PhoneModel> getPhones() {
    return phones;
  }

  public String getToken() {
    return token;
  }

  public boolean isActive() {
    return isactive;
  }

  public UserModel(String id, LocalDateTime created, LocalDateTime modified, LocalDateTime lastlogin, String token, String name,
      String email, String password, List<PhoneModel> phones, boolean isactive) {
    this.id = id;
    this.created = created;
    this.modified = modified;
    this.lastlogin = lastlogin;
    this.name = name;
    this.email = email;
    this.password = password;
    this.phones = phones;
    this.token = token;
    this.isactive = isactive;
  }
}
