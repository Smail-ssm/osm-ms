package com.osm.oilproductionservice.dto.in;

import com.osm.oilproductionservice.model.Supplier;
import com.xdev.xdevbase.dtos.BaseDto;

import java.util.UUID;

public class SupplierDtoIn extends BaseDto<Supplier> {

    private String name;
    private String lastname;
    private String phone;
    private String email;
    private String address;
    // Instead of the full BaseTypeDto for supplier type, we use just its ID.
    private UUID suppliertypeId;

    public SupplierDtoIn() {
    }

    public SupplierDtoIn(String name, String lastname, String phone, String email, String address, UUID suppliertypeId) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.suppliertypeId = suppliertypeId;
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

    public UUID getSuppliertypeId() {
        return suppliertypeId;
    }

    public void setSuppliertypeId(UUID suppliertypeId) {
        this.suppliertypeId = suppliertypeId;
    }
}
