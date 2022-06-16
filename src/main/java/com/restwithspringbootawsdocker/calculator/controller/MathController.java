package com.restwithspringbootawsdocker.calculator.controller;

import com.restwithspringbootawsdocker.calculator.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numbOne}/{numbTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numbOne")String numbOne, @PathVariable("numbTwo") String numbTwo)throws Exception{

        if(!isNumeric(numbOne)||!isNumeric(numbTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertDouble(numbOne) + convertDouble(numbTwo);
    }

    private Double convertDouble(String strNumber) {
       if(strNumber == null) return 0D;
       String number = strNumber.replaceAll(",",".");
       if(isNumeric(number)) return Double.parseDouble(number);
       return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
