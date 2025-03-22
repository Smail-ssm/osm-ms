package com.osm.oilproductionservice.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.osm.oilproductionservice.model.QualityControlResult}
 */

public class QualityControlResultDto implements Serializable {
    Long id;
    QualityControlRuleDto rule;
    Float measuredValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Float getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(Float measuredValue) {
        this.measuredValue = measuredValue;
    }

    public QualityControlResultDto() {
    }

    public QualityControlResultDto(Long id, QualityControlRuleDto rule, Float measuredValue) {
        this.id = id;
        this.rule = rule;
        this.measuredValue = measuredValue;
    }

    public QualityControlRuleDto getRule() {
        return rule;
    }

    public void setRule(QualityControlRuleDto rule) {
        this.rule = rule;
    }
}