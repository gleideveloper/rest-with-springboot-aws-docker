package com.restwithspringbootawsdocker.calculator.controller;

import com.restwithspringbootawsdocker.calculator.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @Autowired
    private CalcService calculator;

    @RequestMapping(value = "/calc/{numbOne}/{numbTwo}", method = RequestMethod.GET)
    public String calc(@PathVariable("numbOne")String numbOne, @PathVariable("numbTwo") String numbTwo)throws Exception{
        if(calculator.isNumeric(numbOne,numbTwo)) {
            if (numbOne.contains(",")) numbOne = numbOne.replaceAll(",", ".");
            if (numbTwo.contains(",")) numbTwo = numbTwo.replaceAll(",", ".");
        }
        return "Soma: " + calculator.sum(numbOne, numbTwo) +
                "\nSubtração: " + calculator.sub(numbOne, numbTwo) +
                "\nMultiplicação: " + calculator.mult(numbOne, numbTwo) +
                "\nDivisão: " + calculator.div(numbOne, numbTwo) +
                "\nMédia: " + calculator.media(numbOne, numbTwo);

    }
    @RequestMapping(value = "/raiz/{numbOne}", method = RequestMethod.GET)
    public String calc(@PathVariable("numbOne")String numbOne)throws Exception{
        if(calculator.isNumeric(numbOne)) {
            if (numbOne.contains(",")) numbOne = numbOne.replaceAll(",", ".");
        }
        return "\nRaizQuadrada: " + calculator.raizq(numbOne);
    }
}
