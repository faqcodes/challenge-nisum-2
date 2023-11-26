package com.faqcodes.challenge.models;

import java.util.List;

public class UserInputModel {

  private final String name;
  private final String email;
  private final String password;
  private final List<PhoneModel> phones;

  private String passwordRegex;

  public String getPasswordRegex() {
    return passwordRegex;
  }

  public void setPasswordRegex(String value) {
    this.passwordRegex = value;
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

  public UserInputModel(String name, String email, String password, List<PhoneModel> phones) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.phones = phones;
  }

}
