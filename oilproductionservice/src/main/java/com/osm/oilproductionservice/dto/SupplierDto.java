package com.osm.oilproductionservice.dto;

import com.osm.oilproductionservice.domain.customTypes.RegionDto;
import com.osm.oilproductionservice.domain.customTypes.SupplierTypeDto;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.osm.oilproductionservice.domain.Supplier}
 */
@Value
public class SupplierDto implements Serializable {
    Long id;
    String name;
    String lastname;
    String phone;
    String email;
    String address;
    RegionDto region;
    Set<DeliveryDto> deliveries;
    @NotNull
    SupplierTypeDto suppliertype;
}