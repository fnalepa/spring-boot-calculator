/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.models;

import java.math.BigDecimal;

/**
 * Information data about a particular loan
 * @author Filip PC
 */
public class LoanInfoData {
    /**
     * Total amount to be paid per month.
     */
    private int monthlyPayment;
    /**
     * Interest rate in %
     */
    private BigDecimal interestRate;
    /**
     * APR in %
     */
    private BigDecimal apr;
    /**
     * Monthly amount to be paid for the insurance.
     */
    private int insurance;
    /**
     * Total amount to be paid for the loan.
     */
    private int totalAmount;

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getApr() {
        return apr;
    }

    public void setApr(BigDecimal apr) {
        this.apr = apr;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
    
}
