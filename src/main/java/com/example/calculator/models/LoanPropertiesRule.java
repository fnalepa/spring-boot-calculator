/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * An instance of this class represents properties of a loan based on the maximal ratio of the loan amount and its term.
 * @author Filip PC
 */
@Entity
public class LoanPropertiesRule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Maximal ratio of the loan amount and its term
     */
    @Column(unique=true)    
    private int maxRatio;
    /**
     * Annual interest rate in %
     */
    @NotNull
    @Min(0)
    private BigDecimal interestRate;
    /**
     * ARP in %
     */
    @NotNull
    @Min(0)    
    private BigDecimal arp;
    /**
     * Monthly insurance to be paid
     */
    @Min(0)
    private int insurance;    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaxRatio() {
        return maxRatio;
    }

    public void setMaxRatio(int maxRatio) {
        this.maxRatio = maxRatio;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getArp() {
        return arp;
    }

    public void setArp(BigDecimal arp) {
        this.arp = arp;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof LoanPropertiesRule)) {
            return false;
        }
        LoanPropertiesRule other = (LoanPropertiesRule) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.example.calculator.models.LoanInfoConstraint[ id=" + id + " ]";
    }
    
}
