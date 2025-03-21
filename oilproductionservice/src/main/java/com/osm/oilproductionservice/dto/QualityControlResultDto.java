package com.osm.oilproductionservice.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.osm.oilproductionservice.model.QualityControlResult}
 */

public class QualityControlResultDto implements Serializable {
    Long id;
    Long ruleId;
    Float measuredValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public Float getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(Float measuredValue) {
        this.measuredValue = measuredValue;
    }

    public QualityControlResultDto() {
    }

    public QualityControlResultDto(Long id, Long ruleId, Float measuredValue) {
        this.id = id;
        this.ruleId = ruleId;
        this.measuredValue = measuredValue;
    }
}