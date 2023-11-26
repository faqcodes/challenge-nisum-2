package com.faqcodes.challenge.entities;

import java.time.LocalDateTime;
import java.util.List;

public interface User {

  public String getId();

  public LocalDateTime getCreated();

  public LocalDateTime getModified();

  public LocalDateTime getLastlogin();

  public String getToken();

  public String getName();

  public String getEmail();

  public String getPassword();

  public List<Phone> getPhones();

  public boolean isActive();

  boolean isPasswordValid();

  boolean isEmailValid();

  boolean patternMatches(String value, String regex);
}
