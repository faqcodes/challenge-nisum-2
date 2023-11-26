package com.faqcodes.challenge.adapters.gateways.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "phones")
public class PhoneData {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "number")
  private int number;

  @Column(name = "citycode")
  private int citycode;

  @Column(name = "countrycode")
  private int countrycode;

  public PhoneData() {
    super();
  }

  public PhoneData(int number, int citycode, int countrycode) {
    super();
    this.number = number;
    this.citycode = citycode;
    this.countrycode = countrycode;
  }
}
