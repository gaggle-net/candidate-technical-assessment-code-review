package com.gaggle.contact.controllers.advice;

import com.gaggle.contact.controllers.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MissingServletRequestParameterAdvice {

    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse missingServletRequestParameterExceptionHandler(final MissingServletRequestParameterException ex) {
        return new ErrorResponse(ex.getMessage());
    }
}
