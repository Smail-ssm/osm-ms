package com.osm.oilproductionservice.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.osm.oilproductionservice.model.QualityControlResult}
 */

public class QualityControlResultDto implements Serializable {
    QualityControlRuleDto rule;
    Float measuredValue;


    public QualityControlResultDto() {
    }

    public Float getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(Float measuredValue) {
        this.measuredValue = measuredValue;
    }

    public QualityControlRuleDto getRule() {
        return rule;
    }

    public void setRule(QualityControlRuleDto rule) {
        this.rule = rule;
    }
}