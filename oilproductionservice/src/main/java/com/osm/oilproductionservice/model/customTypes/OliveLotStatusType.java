package com.osm.oilproductionservice.model.customTypes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;

/**
 * A OliveLotStatusType.
 */
@Entity
@Table(name = "olive_lot_status_entity")
@JsonTypeName("olivelotstatustype")

  public class OliveLotStatusType extends BaseType {


    public OliveLotStatusType(String name, String description) {
        super(name, description);
    }

    /**
     * Constructs a new object.
     */
    public OliveLotStatusType() {
        super();
    }
}
