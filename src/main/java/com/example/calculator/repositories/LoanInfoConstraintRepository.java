/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.repositories;

import com.example.calculator.models.LoanPropertiesRule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Filip PC
 */
public interface LoanInfoConstraintRepository extends JpaRepository<LoanPropertiesRule, Long> {
    public List<LoanPropertiesRule> findAllByOrderByMaxRatio();
}
