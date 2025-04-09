package com.osm.oilproductionservice.dto;

import com.osm.oilproductionservice.model.Delivery;

public class DeliveryWithNextIdDto {
    private final Delivery delivery;
    private final Long nextId;

    public DeliveryWithNextIdDto(Delivery delivery, Long nextId) {
        this.delivery = delivery;
        this.nextId = nextId;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Long getNextId() {
        return nextId;
    }
}
