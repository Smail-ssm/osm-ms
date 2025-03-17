package com.osm.oilproductionservice.rest;

import com.osm.oilproductionservice.domain.Delivery;
import com.osm.oilproductionservice.domain.customTypes.BaseType;
import com.osm.oilproductionservice.dto.ApiResponse;
import com.osm.oilproductionservice.service.DeliveryService;
import com.osm.oilproductionservice.service.GenericTypeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/production/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService, GenericTypeService genericTypeService) {
        this.deliveryService = deliveryService;
     }

    @PostMapping
    public ResponseEntity<ApiResponse<Delivery>> createDelivery(@RequestBody Delivery delivery) {
        try {
            Delivery createdDelivery = deliveryService.createDelivery(delivery);
            ApiResponse<Delivery> response = new ApiResponse<>(true, "Delivery created successfully", createdDelivery);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<Delivery> response = new ApiResponse<>(false, "Error creating delivery: " + e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Delivery>> updateDelivery(@PathVariable Long id, @RequestBody Delivery delivery) {
        Delivery updatedDelivery = deliveryService.updateDelivery(id, delivery);
        if (updatedDelivery != null) {
            ApiResponse<Delivery> response = new ApiResponse<>(true, "Delivery updated successfully", updatedDelivery);
            return ResponseEntity.ok(response);
        }
        ApiResponse<Delivery> response = new ApiResponse<>(false, "Delivery not found", null);
        return ResponseEntity.status(404).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Delivery>> getDelivery(@PathVariable Long id) {
        Delivery delivery = deliveryService.getDelivery(id);
        if (delivery != null) {
            ApiResponse<Delivery> response = new ApiResponse<>(true, "Delivery fetched successfully", delivery);
            return ResponseEntity.ok(response);
        }
        ApiResponse<Delivery> response = new ApiResponse<>(false, "Delivery not found", null);
        return ResponseEntity.status(404).body(response);
    }

    // Endpoint for retrieving all deliveries with pagination
    @GetMapping
    public ResponseEntity<ApiResponse<Page<Delivery>>> getAllDeliveries(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Delivery> deliveriesPage = deliveryService.getAllDeliveries(page, size);
        ApiResponse<Page<Delivery>> response = new ApiResponse<>(true, "Deliveries fetched successfully", deliveriesPage);
        return ResponseEntity.ok(response);
    }

    // Endpoint for retrieving deliveries by region with pagination
    @GetMapping("/region/{regionId}")
    public ResponseEntity<ApiResponse<Page<Delivery>>> getDeliveriesByRegion(@PathVariable Long regionId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Delivery> deliveriesPage = deliveryService.getDeliveriesByRegion(regionId, page, size);
        ApiResponse<Page<Delivery>> response = new ApiResponse<>(true, "Deliveries for region fetched successfully", deliveriesPage);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteDelivery(@PathVariable Long id) {
        boolean deleted = deliveryService.deleteDelivery(id);
        if (deleted) {
            ApiResponse<Void> response = new ApiResponse<>(true, "Delivery deleted successfully", null);
            return ResponseEntity.ok(response);
        }
        ApiResponse<Void> response = new ApiResponse<>(false, "Delivery not found", null);
        return ResponseEntity.status(404).body(response);
    }
}