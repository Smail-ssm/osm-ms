package com.osm.oilproductionservice.dto;

import com.osm.oilproductionservice.model.Supplier;
import com.xdev.xdevbase.dtos.BaseDto;

/**
 * DTO for {@link Supplier}
 */

public class SupplierDto extends BaseDto<Supplier> {
    private SupplierInfoDto supplier;
    private BaseTypeDto genericSuppliertype;

    public SupplierDto(SupplierInfoDto supplier, BaseTypeDto genericSuppliertype) {
        this.supplier = supplier;
        this.genericSuppliertype = genericSuppliertype;
    }

    public SupplierInfoDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierInfoDto supplier) {
        this.supplier = supplier;
    }

    public BaseTypeDto getGenericSuppliertype() {
        return genericSuppliertype;
    }

    public void setGenericSuppliertype(BaseTypeDto genericSuppliertype) {
        this.genericSuppliertype = genericSuppliertype;
    }

}