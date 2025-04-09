package com.osm.oilproductionservice.model;


import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "quality_control_rule")
public class QualityControlRule extends BaseEntity implements Serializable {


    // A technical key for the rule, e.g., "infestation_percentage"
    private String ruleKey;
    private boolean isOilQc;
    // A user-friendly name for the rule, e.g., "Infestation Percentage"
    private String ruleName;
    // A description of the rule to explain its purpose
    private String description;
    // The minimum acceptable value for the rule (typically 0)
    private Float minValue;
    // The maximum acceptable value for the rule (typically 100)
    private Float maxValue;


    public QualityControlRule() {

    }

    public QualityControlRule(String ruleKey, boolean isOilQc, String ruleName, String description, Float minValue, Float maxValue) {
        this.ruleKey = ruleKey;
        this.isOilQc = isOilQc;
        this.ruleName = ruleName;
        this.description = description;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public boolean getOilQc() {
        return isOilQc;
    }

    // Getters and Setters

    public boolean isOilQc() {
        return isOilQc;
    }

    public void setOilQc(boolean oilQc) {
        isOilQc = oilQc;
    }



    public String getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getMinValue() {
        return minValue;
    }

    public void setMinValue(Float minValue) {
        this.minValue = minValue;
    }

    public Float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Float maxValue) {
        this.maxValue = maxValue;
    }
}
