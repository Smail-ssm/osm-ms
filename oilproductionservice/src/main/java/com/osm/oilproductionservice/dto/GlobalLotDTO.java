package com.osm.oilproductionservice.dto;

import com.osm.oilproductionservice.model.GlobalLot;
import lombok.Data;
import java.util.List;

@Data
public class GlobalLotDTO {
    private String globalLotNumber;
    private double totalKg;
    private List<UnifiedDeliveryDTO> lots;

    // Constructor for getPlanning
    public GlobalLotDTO(String globalLotNumber, double totalKg, List<UnifiedDeliveryDTO> lots) {
        this.globalLotNumber = globalLotNumber;
        this.totalKg = totalKg;
        this.lots = lots;
    }
}