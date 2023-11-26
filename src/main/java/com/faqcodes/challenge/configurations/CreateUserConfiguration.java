package com.faqcodes.challenge.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.faqcodes.challenge.adapters.gateways.SaveUser;
import com.faqcodes.challenge.adapters.gateways.SaveUserGateway;
import com.faqcodes.challenge.adapters.gateways.db.UserRepository;
import com.faqcodes.challenge.adapters.presenters.CreateUserPresenter;
import com.faqcodes.challenge.adapters.presenters.Presenter;
import com.faqcodes.challenge.adapters.security.JWTSecurityToken;
import com.faqcodes.challenge.adapters.security.SecurityToken;
import com.faqcodes.challenge.entities.CreatePhone;
import com.faqcodes.challenge.entities.CreatePhoneEntity;
import com.faqcodes.challenge.entities.CreateUser;
import com.faqcodes.challenge.entities.CreateUserEntity;
import com.faqcodes.challenge.models.UserInputModel;
import com.faqcodes.challenge.models.UserOutputModel;
import com.faqcodes.challenge.usecases.CreateUserUseCase;
import com.faqcodes.challenge.usecases.UseCase;

@Configuration
public class CreateUserConfiguration {

  @Bean
  CreateUser createUser() {
    return new CreateUserEntity();
  }

  @Bean
  CreatePhone createPhone() {
    return new CreatePhoneEntity(); 
  }

  @Bean
  SaveUser saveUser(UserRepository repository) {
    return new SaveUserGateway(repository);
  }

  @Bean
  SecurityToken securityToken() {
    return new JWTSecurityToken();
  }

  @Bean
  Presenter<UserInputModel, UserOutputModel> presenter() {
    return new CreateUserPresenter();
  }

  @Bean
  UseCase<UserInputModel, UserOutputModel> createUserUseCase(
      CreateUser createUser,
      CreatePhone createPhone,
      SaveUser saveUser,
      SecurityToken securityToken,
      Presenter<UserInputModel, UserOutputModel> presenter
      ) {
    return new CreateUserUseCase(createUser, createPhone, saveUser, securityToken, presenter);
  }

}
