package com.osm.oilproductionservice.controller;

import com.osm.oilproductionservice.dto.ApiResponse;
import com.osm.oilproductionservice.dto.genericDTO.BaseTypeDto;
import com.osm.oilproductionservice.service.GenericTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/production/types")
public class GenericTypeController {

    private final GenericTypeService genericTypeService;

    @Autowired
    public GenericTypeController(GenericTypeService genericTypeService) {
        this.genericTypeService = genericTypeService;
    }

     @PostMapping("/")
    public ResponseEntity<ApiResponse<BaseTypeDto>> createType( @RequestBody BaseTypeDto baseType) {
        try {
            BaseTypeDto createdType = genericTypeService.createType(baseType);
            ApiResponse<BaseTypeDto> response = new ApiResponse<>(true, "Type created successfully", createdType);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            ApiResponse<BaseTypeDto> response = new ApiResponse<>(false, "Error creating type: " + e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }

    // Get all types (e.g., all WasteTypes, SupplierTypes, OliveLotStatusTypes)
    @GetMapping("/{type}")
    public ResponseEntity<ApiResponse<List<Object>>> getAllTypes(@PathVariable String type) {
        try {
            List<Object> types = genericTypeService.getAllTypes(type);
            ApiResponse<List<Object>> response = new ApiResponse<>(true, "Types fetched successfully", types);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            ApiResponse<List<Object>> response = new ApiResponse<>(false, "Error fetching types: " + e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }

    // Get a type by ID
    @GetMapping("/{type}/{id}")
    public ResponseEntity<ApiResponse<BaseTypeDto>> getType(@PathVariable String type, @PathVariable Long id) {
        BaseTypeDto typeObj = genericTypeService.getType(id, type);
        if (typeObj != null) {
            ApiResponse<BaseTypeDto> response = new ApiResponse<>(true, "Type fetched successfully", typeObj);
            return ResponseEntity.ok(response);
        }
        ApiResponse<BaseTypeDto> response = new ApiResponse<>(false, "Type not found", null);
        return ResponseEntity.status(404).body(response);
    }

    // Update a type by ID
    @PutMapping("/")
    public ResponseEntity<ApiResponse<BaseTypeDto>> updateType(  @RequestBody BaseTypeDto baseType) {
        try {
            BaseTypeDto updatedType = genericTypeService.updateType(  baseType);
            if (updatedType != null) {
                ApiResponse<BaseTypeDto> response = new ApiResponse<>(true, "Type updated successfully", updatedType);
                return ResponseEntity.ok(response);
            }
            ApiResponse<BaseTypeDto> response = new ApiResponse<>(false, "Type not found", null);
            return ResponseEntity.status(404).body(response);
        } catch (RuntimeException e) {
            ApiResponse<BaseTypeDto> response = new ApiResponse<>(false, "Error updating type: " + e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }

    // Delete a type by ID
    @DeleteMapping("/{type}/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteType(@PathVariable String type, @PathVariable Long id) {
        try {
            boolean deleted = genericTypeService.deleteType(id, type);
            if (deleted) {
                ApiResponse<Void> response = new ApiResponse<>(true, "Type deleted successfully", null);
                return ResponseEntity.ok(response);
            }
            ApiResponse<Void> response = new ApiResponse<>(false, "Type not found", null);
            return ResponseEntity.status(404).body(response);
        } catch (RuntimeException e) {
            ApiResponse<Void> response = new ApiResponse<>(false, "Error deleting type: " + e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }

    // New endpoint: Get all types regardless of category
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<BaseTypeDto>>> getAllCombinedTypes() {
        try {
            List<BaseTypeDto> allTypes = genericTypeService.getAllCombinedTypes();
            ApiResponse<List<BaseTypeDto>> response = new ApiResponse<>(true, "All types fetched successfully", allTypes);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            ApiResponse<List<BaseTypeDto>> response = new ApiResponse<>(false, "Error fetching types: " + e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }
}
