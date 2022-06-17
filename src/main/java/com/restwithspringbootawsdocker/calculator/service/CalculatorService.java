package com.restwithspringbootawsdocker.calculator.service;

import com.restwithspringbootawsdocker.calculator.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Component;

@Component
public class CalculatorService implements CalcService{
    private double result;
    @Override
    public Double sum(String a, String b) {
        return Double.parseDouble(a) + Double.parseDouble(b);
    }

    @Override
    public Double sub(String a, String b) {
        return Double.parseDouble(a) - Double.parseDouble(b);
    }

    @Override
    public Double mult(String a, String b) {
        return Double.parseDouble(a) * Double.parseDouble(b);
    }

    @Override
    public Double div(String a, String b) {
        return Double.parseDouble(a) / Double.parseDouble(b);
    }

    @Override
    public Double media(String a, String b) {
        return (Double.parseDouble(a) + Double.parseDouble(b))/2;
    }

    @Override
    public Double raizq(String a) {
        return Math.sqrt(Double.parseDouble(a));
    }

    @Override
    public Boolean isNumeric(String a, String b){
        if(!a.matches("[-+]?[0-9]*\\.?[0-9]+") && !b.matches("[-+]?[0-9]*\\.?[0-9]+")){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return true;
    }

    @Override
    public Boolean isNumeric(String numbOne) {
        if(!numbOne.matches("[-+]?[0-9]*\\.?[0-9]+")){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return true;
    }
}
