package com.osm.oilproductionservice.dto;

import com.osm.oilproductionservice.model.BaseTypeDto;
import com.osm.oilproductionservice.model.Supplier;
import com.xdev.xdevbase.dtos.BaseDto;

/**
 * DTO for {@link com.osm.oilproductionservice.model.Supplier}
 */

public class SupplierDto extends BaseDto<Supplier> {
    private String name;
    private String lastname;
    private String phone;
    private String email;
    private String address;
    private BaseTypeDto region;


    public SupplierDto() {
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


    public BaseTypeDto getRegion() {
        return region;
    }

    public void setRegion(BaseTypeDto region) {
        this.region = region;
    }


}