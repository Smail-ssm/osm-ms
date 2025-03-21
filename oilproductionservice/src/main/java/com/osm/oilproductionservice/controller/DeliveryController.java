package com.osm.oilproductionservice.controller;

import com.osm.oilproductionservice.dto.ApiResponse;
import com.osm.oilproductionservice.dto.DeliveryDto;
import com.osm.oilproductionservice.service.DeliveryService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/production/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    /**
     * Create a new delivery.
     */
    @PostMapping
    public ResponseEntity<ApiResponse<DeliveryDto>> createDelivery(@RequestBody DeliveryDto deliveryDto) {
        try {
            DeliveryDto createdDelivery = deliveryService.createDelivery(deliveryDto);
            ApiResponse<DeliveryDto> response = new ApiResponse<>(true, "Delivery created successfully", createdDelivery);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<DeliveryDto> response = new ApiResponse<>(false, "Error creating delivery: " + e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * Update an existing delivery.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<DeliveryDto>> updateDelivery(@PathVariable Long id, @RequestBody DeliveryDto deliveryDto) {
        DeliveryDto updatedDelivery = deliveryService.updateDelivery(id, deliveryDto);
        if (updatedDelivery != null) {
            ApiResponse<DeliveryDto> response = new ApiResponse<>(true, "Delivery updated successfully", updatedDelivery);
            return ResponseEntity.ok(response);
        }
        ApiResponse<DeliveryDto> response = new ApiResponse<>(false, "Delivery not found", null);
        return ResponseEntity.status(404).body(response);
    }

    /**
     * Get a delivery by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DeliveryDto>> getDelivery(@PathVariable Long id) {
        DeliveryDto deliveryDto = deliveryService.getDelivery(id);
        if (deliveryDto != null) {
            ApiResponse<DeliveryDto> response = new ApiResponse<>(true, "Delivery fetched successfully", deliveryDto);
            return ResponseEntity.ok(response);
        }
        ApiResponse<DeliveryDto> response = new ApiResponse<>(false, "Delivery not found", null);
        return ResponseEntity.status(404).body(response);
    }

    /**
     * Retrieve all deliveries with pagination.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<Page<DeliveryDto>>> getAllDeliveries(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<DeliveryDto> deliveriesPage = deliveryService.getAllDeliveries(page, size);
        ApiResponse<Page<DeliveryDto>> response = new ApiResponse<>(true, "Deliveries fetched successfully", deliveriesPage);
        return ResponseEntity.ok(response);
    }

    /**
     * Retrieve deliveries by region ID with pagination.
     */
    @GetMapping("/region/{regionId}")
    public ResponseEntity<ApiResponse<Page<DeliveryDto>>> getDeliveriesByRegion(
            @PathVariable Long regionId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<DeliveryDto> deliveriesPage = deliveryService.getDeliveriesByRegion(regionId, page, size);
        ApiResponse<Page<DeliveryDto>> response = new ApiResponse<>(true, "Deliveries for region fetched successfully", deliveriesPage);
        return ResponseEntity.ok(response);
    }

    /**
     * Delete a delivery by ID.
     */
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