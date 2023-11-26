package com.faqcodes.challenge.models;

public class PhoneModel {
  private final int number;
  private final int citycode;
  private final int countrycode;

  public int getNumber() {
    return number;
  }

  public int getCitycode() {
    return citycode;
  }

  public int getCountrycode() {
    return countrycode;
  }

  public PhoneModel(int number, int citycode, int countrycode) {
    this.number = number;
    this.citycode = citycode;
    this.countrycode = countrycode;
  }
}
