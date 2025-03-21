package com.osm.oilproductionservice.dto;


import java.io.Serializable;
import java.time.LocalDateTime;


 public class WasteTypeDto   extends  BaseTypeDto implements Serializable{
     public WasteTypeDto() {
         super();
     }

     public WasteTypeDto(Long id, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
         super(id, name, description, createdAt, updatedAt);
     }
}