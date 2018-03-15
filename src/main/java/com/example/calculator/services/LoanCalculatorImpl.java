/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.services;

import com.example.calculator.models.LoanInfoConstraint;
import com.example.calculator.models.LoanInfoData;
import com.example.calculator.models.LoanInputData;
import com.example.calculator.repositories.LoanInfoConstraintRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Filip PC
 */
@Service
public class LoanCalculatorImpl implements LoanCalculator{
    @Autowired
    private LoanInfoConstraintRepository loanInfoConstraintRepository;
    
    @Override
    public LoanInfoData retrieveLoanInfoData(LoanInputData loanInputData) {
        BigDecimal ratio = new BigDecimal(loanInputData.getAmount()).divide(new BigDecimal(loanInputData.getTerm()), 2);
        for(LoanInfoConstraint constraint : loanInfoConstraintRepository.findAllByOrderByMaxRatio()){
            System.out.println(constraint.getMaxRatio());
        }
        
        LoanInfoData loanInfoData = new LoanInfoData();
        loanInfoData.setApr(new BigDecimal(11.25));
        loanInfoData.setInsurance(loanInputData.isInsured() ? 100 : 0);
        loanInfoData.setInterestRate(new BigDecimal(5.05));
        loanInfoData.setMonthlyPayment(new BigDecimal(loanInputData.getAmount()).divide(new BigDecimal(loanInputData.getTerm()), 2).multiply(loanInfoData.getInterestRate()).intValue());
        loanInfoData.setTotalAmount(new BigDecimal(loanInputData.getAmount()).multiply(loanInfoData.getApr()).intValue());
        return loanInfoData;
    }
    
}
