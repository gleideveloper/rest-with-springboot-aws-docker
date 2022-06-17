package com.restwithspringbootawsdocker.person.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private static final Long serialVersionUID = 1L;

    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
}
