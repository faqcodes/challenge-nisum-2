package com.faqcodes.challenge.adapters.gateways;

import com.faqcodes.challenge.models.UserModel;

public interface SaveUser {
  boolean save(UserModel model) throws Exception;
}
