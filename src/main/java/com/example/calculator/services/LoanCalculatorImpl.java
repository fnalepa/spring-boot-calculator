/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.services;

import com.example.calculator.models.LoanPropertiesRule;
import com.example.calculator.models.LoanInfoData;
import com.example.calculator.models.LoanInputData;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.calculator.repositories.LoanPropertiesRuleRepository;

/**
 * Implementation of {@link LoanCalculator} using {@link LoanPropertiesRuleRepository} to infer the information about loans.
 * @author Filip PC
 */
@Service
public class LoanCalculatorImpl implements LoanCalculator{
    @Autowired
    private LoanPropertiesRuleRepository loanPropertiesRuleRepository;
    /**
     * Finds the loan properties rule with the lowest maxRatio for which it holds that maxRatio &gt;= amount/term.
     * The information about the loan is infered from the found loan properties rule.
     * The monthly payment is computed as: (amount*(interestRate/(100*12))*(1+interestRate/(100*12))^term)/((1+interestRate/(100*12))^term - 1)
     * @param loanInputData loan input data
     * @return information about the loan infered from the found loan properties rule or null of no adequate rule is found
     */
    @Override
    public LoanInfoData retrieveLoanInfoData(LoanInputData loanInputData) {
        BigDecimal ratio = new BigDecimal(loanInputData.getAmount()).divide(new BigDecimal(loanInputData.getTerm()), 2);
        LoanInfoData loanInfoData = null;
        for(LoanPropertiesRule rule : loanPropertiesRuleRepository.findAllByOrderByMaxRatio()){
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
