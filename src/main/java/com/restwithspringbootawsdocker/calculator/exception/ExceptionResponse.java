package com.restwithspringbootawsdocker.calculator.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
public class ExceptionResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    private Date timestamp;
    @Getter
    private String message;
    @Getter
    private String details;
}
