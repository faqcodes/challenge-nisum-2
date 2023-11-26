package com.faqcodes.challenge.adapters.presenters;

import com.faqcodes.challenge.models.ResponseMessage;
import com.faqcodes.challenge.models.UserInputModel;
import com.faqcodes.challenge.models.UserOutputModel;

public class CreateUserPresenter implements Presenter<UserInputModel, UserOutputModel> {

  @Override
  public ResponseMessage<UserOutputModel> successResponse(String message, UserOutputModel outputModel) {
    return new ResponseMessage<>(message, outputModel);
  }

  @Override
  public ResponseMessage<UserOutputModel> errorResponse(String message, UserInputModel inputModel) {
    return new ResponseMessage<>(message, null);
  }
  
}
