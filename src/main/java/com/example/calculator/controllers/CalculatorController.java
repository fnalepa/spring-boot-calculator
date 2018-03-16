/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.controllers;

import com.example.calculator.models.LoanInfoData;
import com.example.calculator.services.LoanCalculator;
import com.example.calculator.models.LoanInputData;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller providing information about loans based on given input data.
 * @author Filip PC
 */
@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
    private LoanCalculator loanCalculator;
    /**
     * Provides information about a loan based on given input data.
     * @param loanInputData loan input data
     * @return information about a loan based on given input data or null if no information is not able to be provided
     */
    @RequestMapping("/getLoanInfoData")
    public LoanInfoData getLoanInfoData(@Valid LoanInputData loanInputData){
        return loanCalculator.retrieveLoanInfoData(loanInputData);
    }
}
