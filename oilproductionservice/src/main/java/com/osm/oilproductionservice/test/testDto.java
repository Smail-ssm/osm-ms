package com.osm.oilproductionservice.test;

import com.xdev.xdevbase.dtos.BaseDto;

public class testDto extends BaseDto<test> {
    String name;

    public testDto() {
    }

    public testDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
