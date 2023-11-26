package com.faqcodes.challenge.entities;

public class PhoneEntity implements Phone {

  private final int number;
  private final int cityCode;
  private final int countryCode;

  public PhoneEntity(int number, int cityCode, int countryCode) {
    this.number = number;
    this.cityCode = cityCode;
    this.countryCode = countryCode;
  }

  @Override
  public int getNumber() {
    return number;
  }

  @Override
  public int getCityCode() {
    return cityCode;
  }

  @Override
  public int getCountryCode() {
    return countryCode;
  }

}
