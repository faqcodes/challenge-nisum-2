package com.faqcodes.challenge.usecases;

import com.faqcodes.challenge.models.ResponseMessage;

public interface UseCase<T, U> {
  ResponseMessage<U> execute(T inputModel);
}
