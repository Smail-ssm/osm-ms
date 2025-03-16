package com.osm.oilproductionservice.rest;

import com.osm.oilproductionservice.domain.Delivery;
import com.osm.oilproductionservice.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/production/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
        Delivery createdDelivery = deliveryService.createDelivery(delivery);
        return ResponseEntity.ok(createdDelivery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Delivery> updateDelivery(@PathVariable Long id, @RequestBody Delivery delivery) {
        Delivery updatedDelivery = deliveryService.updateDelivery(id, delivery);
        if (updatedDelivery != null) {
            return ResponseEntity.ok(updatedDelivery);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDelivery(@PathVariable Long id) {
        Delivery delivery = deliveryService.getDelivery(id);
        if (delivery != null) {
            return ResponseEntity.ok(delivery);
        }
        return ResponseEntity.notFound().build();
    }

    // Endpoint for retrieving all deliveries with pagination
    @GetMapping
    public Page<Delivery> getAllDeliveries(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return deliveryService.getAllDeliveries(page, size);
    }

    // Endpoint for retrieving deliveries by region with pagination
    @GetMapping("/region/{regionId}")
    public Page<Delivery> getDeliveriesByRegion(@PathVariable Long regionId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return deliveryService.getDeliveriesByRegion(regionId, page, size);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable Long id) {
        boolean isDeleted = deliveryService.deleteDelivery(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}