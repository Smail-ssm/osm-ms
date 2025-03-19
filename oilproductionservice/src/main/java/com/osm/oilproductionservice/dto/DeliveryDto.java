package com.osm.oilproductionservice.dto;

import com.osm.oilproductionservice.domain.Delivery;
import com.osm.oilproductionservice.enums.OliveLotStatus;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link Delivery}
 */
@Value
public class DeliveryDto implements Serializable {
    Long id;
    String receiptNumber;
    String lotNumber;
    Instant deliveryDate;
    OliveLotStatus status;
    String globalLotNumber;
    Float oliveQuantity;
    Float oilQuantity;
    RegionDto region;
    OliveVarietyTypeDto variety;
    String storageUnit;
    SupplierDto supplier;
    QualityControlResultDto qualityControlResult;
    Float unitPrice;
    Float price;
    Float paidAmount;
    Float unpaidAmount;
}