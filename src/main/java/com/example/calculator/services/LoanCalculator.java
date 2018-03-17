/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.services;

import com.example.calculator.models.LoanInfoData;
import com.example.calculator.models.LoanInputData;

/**
 * Interface for calculating loan information based on given data.
 * @author Filip PC
 */
public interface LoanCalculator {
    /**
     * Retrieves loan information based on the input data.
     * @param loanInputData input data of a loan
     * @return loan information based on the input data
     */
    public LoanInfoData retrieveLoanInfoData(LoanInputData loanInputData);
}
