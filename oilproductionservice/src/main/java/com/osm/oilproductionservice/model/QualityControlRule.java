package com.osm.oilproductionservice.model;

import com.osm.oilproductionservice.enums.RuleType;
import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "quality_control_rule")
public class QualityControlRule extends BaseEntity implements Serializable {


    private String ruleKey;

    private Boolean oilQc;

    @Enumerated(EnumType.STRING)
    private RuleType ruleType;

    private Boolean booleanValue;

    private Float minValue;

    private Float maxValue;

    private String ruleName;

    private String description;

    // New field for textValues
    @ElementCollection
    @CollectionTable(name = "quality_control_rule_text_values", joinColumns = @JoinColumn(name = "rule_id"))
    @Column(name = "text_value")
    private List<String> textValues;


    public String getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    public Boolean getOilQc() {
        return oilQc;
    }

    public void setOilQc(Boolean oilQc) {
        this.oilQc = oilQc;
    }

    public RuleType getRuleType() {
        return ruleType;
    }

    public void setRuleType(RuleType ruleType) {
        this.ruleType = ruleType;
    }

    public Boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
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

    public List<String> getTextValues() {
        return textValues;
    }

    public void setTextValues(List<String> textValues) {
        this.textValues = textValues;
    }
}
