package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.domain.QualityControlRule;
import com.osm.oilproductionservice.repository.QualityControlRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualityControlRuleService {

    @Autowired
    private QualityControlRuleRepository qualityControlRuleRepository;

    /**
     * Create a new quality control rule.
     * Checks for duplicates based on ruleKey or ruleName.
     */
    public QualityControlRule createRule(QualityControlRule rule) {
        // Check if a rule with the same ruleKey exists
        Optional<QualityControlRule> ruleByKey = qualityControlRuleRepository.findByRuleKey(rule.getRuleKey());
        if (ruleByKey.isPresent()) {
            throw new RuntimeException("A rule with the ruleKey '" + rule.getRuleKey() + "' already exists.");
        }

        // Check if a rule with the same ruleName exists
        Optional<QualityControlRule> ruleByName = qualityControlRuleRepository.findByRuleName(rule.getRuleName());
        if (ruleByName.isPresent()) {
            throw new RuntimeException("A rule with the ruleName '" + rule.getRuleName() + "' already exists.");
        }

        return qualityControlRuleRepository.save(rule);
    }

    /**
     * Retrieve all quality control rules.
     */
    public List<QualityControlRule> getAllRules() {
        return qualityControlRuleRepository.findAll();
    }

    /**
     * Retrieve a quality control rule by its ID.
     */
    public Optional<QualityControlRule> getRuleById(Long id) {
        return qualityControlRuleRepository.findById(id);
    }

    /**
     * Update an existing quality control rule.
     * Checks for duplicates if ruleKey or ruleName is changed.
     */
    public QualityControlRule updateRule(Long id, QualityControlRule ruleDetails) {
        Optional<QualityControlRule> optionalRule = qualityControlRuleRepository.findById(id);
        if (optionalRule.isPresent()) {
            QualityControlRule rule = optionalRule.get();

            // Check for duplicate ruleKey if changed
            if (!rule.getRuleKey().equals(ruleDetails.getRuleKey())) {
                Optional<QualityControlRule> ruleByKey = qualityControlRuleRepository.findByRuleKey(ruleDetails.getRuleKey());
                if (ruleByKey.isPresent()) {
                    throw new RuntimeException("A rule with the ruleKey '" + ruleDetails.getRuleKey() + "' already exists.");
                }
            }

            // Check for duplicate ruleName if changed
            if (!rule.getRuleName().equals(ruleDetails.getRuleName())) {
                Optional<QualityControlRule> ruleByName = qualityControlRuleRepository.findByRuleName(ruleDetails.getRuleName());
                if (ruleByName.isPresent()) {
                    throw new RuntimeException("A rule with the ruleName '" + ruleDetails.getRuleName() + "' already exists.");
                }
            }

            rule.setRuleKey(ruleDetails.getRuleKey());
            rule.setRuleName(ruleDetails.getRuleName());
            rule.setDescription(ruleDetails.getDescription());
            rule.setMinValue(ruleDetails.getMinValue());
            rule.setMaxValue(ruleDetails.getMaxValue());
            return qualityControlRuleRepository.save(rule);
        }
        return null;
    }

    /**
     * Delete a quality control rule by its ID.
     */
    public boolean deleteRule(Long id) {
        if (qualityControlRuleRepository.existsById(id)) {
            qualityControlRuleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
