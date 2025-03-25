package com.osm.oilproductionservice.dto.out;

public class QualityControlRuleDto {
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

    public boolean getOilQc() {
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

    private Long id; // Unique identifier for the rule (optional for creation)
    private String ruleKey; // Technical key for the rule (e.g., "infestation_percentage")
    private boolean isOilQc; // Indicates if the rule applies to oil quality control
    private String ruleName; // User-friendly name for the rule (e.g., "Infestation Percentage")
    private String description; // Description of the rule's purpose
    private Float minValue; // Minimum acceptable value for the rule
    private Float maxValue; // Maximum acceptable value for the rule

    public QualityControlRuleDto() {
    }

    public QualityControlRuleDto(Long id, String ruleKey, boolean isOilQc, String ruleName, String description, Float minValue, Float maxValue) {
        this.id = id;
        this.ruleKey = ruleKey;
        this.isOilQc = isOilQc;
        this.ruleName = ruleName;
        this.description = description;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}