package com.osm.oilproductionservice.test;

import com.xdev.xdevbase.dtos.BaseDto;
import com.xdev.xdevbase.entities.BaseEntity;
import jakarta.persistence.Entity;

 public class testDto extends BaseDto<test> {
     String name;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public testDto() {
     }

     public testDto(String name) {
         this.name = name;
     }
 }
