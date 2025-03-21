package com.osm.oilproductionservice.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "quality_control_rule")
public class QualityControlRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // A technical key for the rule, e.g., "infestation_percentage"
    @Column(name = "rule_key", nullable = false)
    private String ruleKey;
    @Column(name = "is_oil_qc", nullable = false)
    private Boolean isOilQc;
    // A user-friendly name for the rule, e.g., "Infestation Percentage"
    @Column(name = "rule_name", nullable = false)
    private String ruleName;
    // A description of the rule to explain its purpose
    @Column(name = "description")
    private String description;
    // The minimum acceptable value for the rule (typically 0)
    @Column(name = "min_value", nullable = false)
    private Float minValue;
    // The maximum acceptable value for the rule (typically 100)
    @Column(name = "max_value", nullable = false)
    private Float maxValue;
    @ManyToOne
    private Delivery delivery;

    public Boolean getOilQc() {
        return isOilQc;
    }

    public void setOilQc(Boolean oilQc) {
        isOilQc = oilQc;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
