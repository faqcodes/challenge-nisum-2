package com.faqcodes.challenge.models;

import java.time.LocalDateTime;

public class UserOutputModel {

  private final String id;
  private final LocalDateTime created;
  private final LocalDateTime modified;
  private final LocalDateTime lastlogin;
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

  public String getToken() {
    return token;
  }

  public boolean isActive() {
    return isactive;
  }

  public UserOutputModel(String id, LocalDateTime created, LocalDateTime modified, LocalDateTime lastlogin,
      String token, boolean isactive) {
    this.id = id;
    this.created = created;
    this.modified = modified;
    this.lastlogin = lastlogin;
    this.token = token;
    this.isactive = isactive;
  }

}
