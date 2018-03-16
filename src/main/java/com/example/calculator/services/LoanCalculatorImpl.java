/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.services;

import com.example.calculator.models.LoanPropertiesRule;
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
        LoanInfoData loanInfoData = null;
        for(LoanPropertiesRule rule : loanInfoConstraintRepository.findAllByOrderByMaxRatio()){
            if(ratio.compareTo(new BigDecimal(rule.getMaxRatio())) <= 0){
                loanInfoData = new LoanInfoData();
                loanInfoData.setApr(rule.getArp());
                loanInfoData.setInterestRate(rule.getInterestRate());
                loanInfoData.setInsurance(loanInputData.isInsured() ? rule.getInsurance() : 0);
                BigDecimal monthlyRate = rule.getInterestRate().divide(new BigDecimal(100)).divide(new BigDecimal(12), 2);
                BigDecimal a = monthlyRate.add(new BigDecimal(1)).pow(loanInputData.getTerm());                               
                loanInfoData.setMonthlyPayment(new BigDecimal(loanInputData.getAmount()).multiply(monthlyRate).multiply(a)
                                .divide(a.subtract(new BigDecimal(1)), 2).intValue() + loanInfoData.getInsurance());
                loanInfoData.setTotalAmount(loanInputData.getTerm() * loanInfoData.getMonthlyPayment());
                break;
            }
        }        
        return loanInfoData;
    }
    
}
