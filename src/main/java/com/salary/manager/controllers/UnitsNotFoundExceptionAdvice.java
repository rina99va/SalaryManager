package com.salary.manager.controllers;

import com.salary.manager.exceptions.UnitNotFoundException;
import com.salary.manager.exceptions.UnitsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UnitsNotFoundExceptionAdvice {
    @ExceptionHandler(value = UnitsNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public String getMessage(final UnitsNotFoundException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(value = UnitNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public String getMessage(final UnitNotFoundException exception) {
        return exception.getMessage();
    }
}
