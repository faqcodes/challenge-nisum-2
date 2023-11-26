package com.faqcodes.challenge.adapters.gateways.db;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserData {
  @Id
  @Column(name = "id")
  // @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "created")
  private LocalDateTime created;

  @Column(name = "modified")
  private LocalDateTime modified;

  @Column(name = "lastlogin")
  private LocalDateTime lastlogin;

  @Column(name = "token")
  private String token;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @Column(name = "phones")
  private List<PhoneData> phones;

  @Column(name = "isactive")
  private boolean isactive;

  public UserData() {
    super();
  }

  public UserData(String id, LocalDateTime created, LocalDateTime modified, LocalDateTime lastlogin, String token,
      String name, String email, String password, List<PhoneData> phones, boolean isactive) {
    super();
    this.id = id;
    this.created = created;
    this.modified = modified;
    this.lastlogin = lastlogin;
    this.token = token;
    this.name = name;
    this.email = email;
    this.password = password;
    this.phones = phones;
    this.isactive = isactive;
  }
}