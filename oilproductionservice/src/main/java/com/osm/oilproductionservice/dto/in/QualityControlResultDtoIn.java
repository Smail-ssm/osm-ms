package com.osm.oilproductionservice.dto.in;

import java.util.UUID;

public class QualityControlResultDtoIn {

    private Float measuredValue;
    // Instead of the full QualityControlRuleDto, we only accept the rule ID.
    private UUID ruleId;

    public QualityControlResultDtoIn() {
    }

    public QualityControlResultDtoIn(Float measuredValue, UUID ruleId) {
        this.measuredValue = measuredValue;
        this.ruleId = ruleId;
    }

    public Float getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(Float measuredValue) {
        this.measuredValue = measuredValue;
    }

    public UUID getRuleId() {
        return ruleId;
    }

    public void setRuleId(UUID ruleId) {
        this.ruleId = ruleId;
    }
}


