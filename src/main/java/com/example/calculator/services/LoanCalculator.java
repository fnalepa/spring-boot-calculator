/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.services;

import com.example.calculator.models.LoanInfoData;
import com.example.calculator.models.LoanInputData;

/**
 *
 * @author Filip PC
 */
public interface LoanCalculator {
    public LoanInfoData retrieveLoanInfoData(LoanInputData loanInputData);
}
