package com.osm.oilproductionservice.dto;

import com.osm.oilproductionservice.model.SupplierType;
import com.xdev.xdevbase.dtos.BaseDto;

/**
 * DTO for {@link SupplierType}
 */

public class SupplierTypeDto extends BaseDto<SupplierType> {
    private SupplierDto supplier;
    private BaseTypeDto genericSuppliertype;

    public SupplierTypeDto(SupplierDto supplier, BaseTypeDto genericSuppliertype) {
        this.supplier = supplier;
        this.genericSuppliertype = genericSuppliertype;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public BaseTypeDto getGenericSuppliertype() {
        return genericSuppliertype;
    }

    public void setGenericSuppliertype(BaseTypeDto genericSuppliertype) {
        this.genericSuppliertype = genericSuppliertype;
    }

}