package com.osm.oilproductionservice.test;

import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class test extends BaseEntity {
    String name;

    public test(String name) {
        this.name = name;
    }

    public test() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
