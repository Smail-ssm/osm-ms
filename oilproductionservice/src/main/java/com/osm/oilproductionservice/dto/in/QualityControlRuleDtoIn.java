package com.osm.oilproductionservice.dto.in;

public class QualityControlRuleDtoIn {

    // Typically, for an incoming DTO you may not require an ID when creating a new rule.
    // For updates, you can include it if needed. Here we assume creation.
    private String ruleKey;
    private boolean isOilQc;
    private String ruleName;
    private String description;
    private Float minValue;
    private Float maxValue;

    public QualityControlRuleDtoIn() {
    }

    public QualityControlRuleDtoIn(String ruleKey, boolean isOilQc, String ruleName, String description, Float minValue, Float maxValue) {
        this.ruleKey = ruleKey;
        this.isOilQc = isOilQc;
        this.ruleName = ruleName;
        this.description = description;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public String getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    public boolean isOilQc() {
        return isOilQc;
    }

    public void setOilQc(boolean oilQc) {
        isOilQc = oilQc;
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
