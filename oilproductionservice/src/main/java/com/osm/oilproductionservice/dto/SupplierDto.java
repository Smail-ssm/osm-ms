package com.osm.oilproductionservice.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.osm.oilproductionservice.model.Supplier}
 */

public class SupplierDto implements Serializable {
    Long id;
    String name;
    String lastname;
    String phone;
    String email;
    String address;
    RegionDto region;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }




    public SupplierTypeDto getSuppliertype() {
        return suppliertype;
    }

    public void setSuppliertype(SupplierTypeDto suppliertype) {
        this.suppliertype = suppliertype;
    }

    public SupplierDto() {
    }

    public SupplierDto(Long id, String name, String lastname, String phone, String email, String address, RegionDto region, Set<DeliveryDto> deliveries, SupplierTypeDto suppliertype) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.region = region;
        this.suppliertype = suppliertype;
    }

    SupplierTypeDto suppliertype;
}