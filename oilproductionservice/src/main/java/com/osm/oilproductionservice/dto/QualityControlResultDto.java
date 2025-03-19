package com.osm.oilproductionservice.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.osm.oilproductionservice.domain.QualityControlResult}
 */
@Value
public class QualityControlResultDto implements Serializable {
    Long id;
    Long ruleId;
    Float measuredValue;
}