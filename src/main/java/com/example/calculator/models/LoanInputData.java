/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.models;

import javax.validation.constraints.Min;

/**
 * Input data based on which loan information data can be provided.
 * @author Filip PC
 */
public class LoanInputData {
    /**
     * Amount to be loaned.
     */
    @Min(1)
    private int amount;
    /**
     * Number of months until the loan is paid.
     */
    @Min(1)
    private int term;
    /**
     * Whether the loan is insured against unavailability of paying.
     */
    private boolean insured;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }
    
}
