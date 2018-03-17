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
 * Repository of loan properties rules
 * @author Filip PC
 */
public interface LoanPropertiesRuleRepository extends JpaRepository<LoanPropertiesRule, Long> {
    /**
     * Retrieves all loan properties rules ordered by {@link LoanPropertiesRule#maxRatio}.
     * @return loan properties rules ordered by {@link LoanPropertiesRule#maxRatio}
     */
    public List<LoanPropertiesRule> findAllByOrderByMaxRatio();
}
