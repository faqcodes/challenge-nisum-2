package com.faqcodes.challenge.adapters.presenters;

import com.faqcodes.challenge.models.ResponseMessage;

public interface Presenter<T, U> {
  ResponseMessage<U> successResponse(String message, U outputModel);
  ResponseMessage<U> errorResponse(String message, T inputModel);
}
