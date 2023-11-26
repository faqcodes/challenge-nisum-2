package com.faqcodes.challenge.entities;

import java.util.List;

public interface CreateUser {
  User create(String id, String token, String name, String email, String password, List<Phone> phones);
}
