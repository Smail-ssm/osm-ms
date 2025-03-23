package com.osm.oilproductionservice.controller;

 import com.osm.oilproductionservice.dto.ApiResponse;
import com.osm.oilproductionservice.dto.SupplierDto;
 import com.osm.oilproductionservice.model.Supplier;
 import com.osm.oilproductionservice.service.SupplierService;
 import com.osm.oilproductionservice.test.test;
 import com.osm.oilproductionservice.test.testDto;
 import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
 import com.xdev.xdevbase.services.BaseService;
 import org.modelmapper.ModelMapper;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/production/suppliers")
public class SupplierController extends BaseControllerImpl<Supplier, SupplierDto,SupplierDto> {

    @Autowired
    private SupplierService supplierService;

    public SupplierController(BaseService<Supplier, SupplierDto, SupplierDto> baseService, ModelMapper modelMapper, SupplierService supplierService) {
        super(baseService, modelMapper);
        this.supplierService = supplierService;
    }

//    @PostMapping
//    public ResponseEntity<ApiResponse<SupplierDto>> addSupplier(@RequestBody SupplierDto supplier) {
//        try {
//            SupplierDto createdSupplier = supplierService.addSupplier(supplier);
//            ApiResponse<SupplierDto> response = new ApiResponse<>(true, "SupplierDto created successfully", createdSupplier);
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            ApiResponse<SupplierDto> response = new ApiResponse<>(false, "Error creating supplier: " + e.getMessage(), null);
//            return ResponseEntity.badRequest().body(response);
//        }
//    }
//    // New endpoint: Get all suppliers
//    @GetMapping
//    public ResponseEntity<ApiResponse<List<SupplierDto>>> getAllSuppliers() {
//        List<SupplierDto> suppliers = supplierService.getAllSuppliers();
//        ApiResponse<List<SupplierDto>> response = new ApiResponse<>(true, "Suppliers fetched successfully", suppliers);
//        return ResponseEntity.ok(response);
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<ApiResponse<SupplierDto>> updateSupplier(@PathVariable Long id, @RequestBody SupplierDto supplier) {
//        SupplierDto updatedSupplier = supplierService.updateSupplier(id, supplier);
//        if (updatedSupplier != null) {
//            ApiResponse<SupplierDto> response = new ApiResponse<>(true, "SupplierDto updated successfully", updatedSupplier);
//            return ResponseEntity.ok(response);
//        } else {
//            ApiResponse<SupplierDto> response = new ApiResponse<>(false, "SupplierDto not found", null);
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponse<SupplierDto>> getSupplier(@PathVariable Long id) {
//        SupplierDto supplier = supplierService.getSupplier(id);
//        if (supplier != null) {
//            ApiResponse<SupplierDto> response = new ApiResponse<>(true, "SupplierDto fetched successfully", supplier);
//            return ResponseEntity.ok(response);
//        } else {
//            ApiResponse<SupplierDto> response = new ApiResponse<>(false, "SupplierDto not found", null);
//            return ResponseEntity.notFound().build();
//        }
//    }

}
