package com.osm.oilproductionservice.rest;

import com.osm.oilproductionservice.domain.Supplier;
import com.osm.oilproductionservice.dto.ApiResponse;
import com.osm.oilproductionservice.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/production/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<ApiResponse<Supplier>> addSupplier(@RequestBody Supplier supplier) {
        try {
            Supplier createdSupplier = supplierService.addSupplier(supplier);
            ApiResponse<Supplier> response = new ApiResponse<>(true, "Supplier created successfully", createdSupplier);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<Supplier> response = new ApiResponse<>(false, "Error creating supplier: " + e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }
    // New endpoint: Get all suppliers
    @GetMapping
    public ResponseEntity<ApiResponse<List<Supplier>>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        ApiResponse<List<Supplier>> response = new ApiResponse<>(true, "Suppliers fetched successfully", suppliers);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Supplier>> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        if (updatedSupplier != null) {
            ApiResponse<Supplier> response = new ApiResponse<>(true, "Supplier updated successfully", updatedSupplier);
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<Supplier> response = new ApiResponse<>(false, "Supplier not found", null);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Supplier>> getSupplier(@PathVariable Long id) {
        Supplier supplier = supplierService.getSupplier(id);
        if (supplier != null) {
            ApiResponse<Supplier> response = new ApiResponse<>(true, "Supplier fetched successfully", supplier);
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<Supplier> response = new ApiResponse<>(false, "Supplier not found", null);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/region/{regionId}")
    public ResponseEntity<ApiResponse<Supplier>> getSupplierByRegion(@PathVariable Long regionId) {
        Supplier supplier = supplierService.getSupplierByRegion(regionId);
        if (supplier != null) {
            ApiResponse<Supplier> response = new ApiResponse<>(true, "Supplier fetched successfully by region", supplier);
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<Supplier> response = new ApiResponse<>(false, "Supplier not found for region " + regionId, null);
            return ResponseEntity.notFound().build();
        }
    }
}
