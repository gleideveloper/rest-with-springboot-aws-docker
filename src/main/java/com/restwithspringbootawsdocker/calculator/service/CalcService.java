package com.restwithspringbootawsdocker.calculator.service;

public interface CalcService {
    Double sum (String a, String b);
    Double sub (String a, String b);
    Double mult (String a, String b);
    Double div (String a, String b);
    Double media (String a, String b);
    Double raizq (String a);
    Boolean isNumeric(String a, String b);
    Boolean isNumeric(String numbOne);
}
