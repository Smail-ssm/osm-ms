package com.osm.oilproductionservice.controller;

import com.osm.oilproductionservice.constants.TypeCategory;
import com.osm.oilproductionservice.dto.BaseTypeDto;
import com.osm.oilproductionservice.model.BaseType;
import com.osm.oilproductionservice.service.GenericTypeService;
import com.xdev.xdevbase.apiDTOs.ApiResponse;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/production/types")
public class GenericTypeController extends BaseControllerImpl<BaseType, BaseTypeDto,BaseTypeDto> {
    private final GenericTypeService genericTypeService;
    public GenericTypeController(BaseService<BaseType, BaseTypeDto, BaseTypeDto> baseService, ModelMapper modelMapper, GenericTypeService genericTypeService) {
        super(baseService, modelMapper);
        this.genericTypeService = genericTypeService;
    }


//     @PostMapping("/")
//    public ResponseEntity<ApiResponse<BaseTypeDto>> createType( @RequestBody BaseTypeDto baseType) {
//        try {
//            BaseTypeDto createdType = genericTypeService.createType(baseType);
//            ApiResponse<BaseTypeDto> response = new ApiResponse<>(true, "Type created successfully", createdType);
//            return ResponseEntity.ok(response);
//        } catch (RuntimeException e) {
//            ApiResponse<BaseTypeDto> response = new ApiResponse<>(false, "Error creating type: " + e.getMessage(), null);
//            return ResponseEntity.badRequest().body(response);
//        }
//    }
//
    // Get all types (e.g., all WasteTypes, SupplierTypes, OliveLotStatusTypes)
    @GetMapping("/{type}")
    public ResponseEntity<ApiResponse< BaseType,BaseTypeDto>> getAllTypes(@PathVariable TypeCategory type) {
        try {
            List<BaseType> types = this.genericTypeService.getAllTypes(type);
            List<BaseTypeDto> typeDtos= types.stream().map((element) -> modelMapper.map(element, BaseTypeDto.class)).toList();
            modelMapper.map(types, BaseTypeDto.class);
            ApiResponse<BaseType,BaseTypeDto> response = new ApiResponse<>(true, "Types fetched successfully", typeDtos);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            ApiResponse<BaseType,BaseTypeDto> response = new ApiResponse<>(false, "Error fetching types: " + e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }
//
//    // Get a type by ID
//    @GetMapping("/{type}/{id}")
//    public ResponseEntity<ApiResponse<BaseTypeDto>> getType(@PathVariable String type, @PathVariable Long id) {
//        BaseTypeDto typeObj = genericTypeService.getType(id, type);
//        if (typeObj != null) {
//            ApiResponse<BaseTypeDto> response = new ApiResponse<>(true, "Type fetched successfully", typeObj);
//            return ResponseEntity.ok(response);
//        }
//        ApiResponse<BaseTypeDto> response = new ApiResponse<>(false, "Type not found", null);
//        return ResponseEntity.status(404).body(response);
//    }
//
//    // Update a type by ID
//    @PutMapping("/")
//    public ResponseEntity<ApiResponse<BaseTypeDto>> updateType(  @RequestBody BaseTypeDto baseType) {
//        try {
//            BaseTypeDto updatedType = genericTypeService.updateType(  baseType);
//            if (updatedType != null) {
//                ApiResponse<BaseTypeDto> response = new ApiResponse<>(true, "Type updated successfully", updatedType);
//                return ResponseEntity.ok(response);
//            }
//            ApiResponse<BaseTypeDto> response = new ApiResponse<>(false, "Type not found", null);
//            return ResponseEntity.status(404).body(response);
//        } catch (RuntimeException e) {
//            ApiResponse<BaseTypeDto> response = new ApiResponse<>(false, "Error updating type: " + e.getMessage(), null);
//            return ResponseEntity.badRequest().body(response);
//        }
//    }
//
//    // Delete a type by ID
//    @DeleteMapping("/{type}/{id}")
//    public ResponseEntity<ApiResponse<Void>> deleteType(@PathVariable String type, @PathVariable Long id) {
//        try {
//            boolean deleted = genericTypeService.deleteType(id, type);
//            if (deleted) {
//                ApiResponse<Void> response = new ApiResponse<>(true, "Type deleted successfully", null);
//                return ResponseEntity.ok(response);
//            }
//            ApiResponse<Void> response = new ApiResponse<>(false, "Type not found", null);
//            return ResponseEntity.status(404).body(response);
//        } catch (RuntimeException e) {
//            ApiResponse<Void> response = new ApiResponse<>(false, "Error deleting type: " + e.getMessage(), null);
//            return ResponseEntity.badRequest().body(response);
//        }
//    }
//
//    // New endpoint: Get all types regardless of category
//    @GetMapping("/all")
//    public ResponseEntity<ApiResponse<List<BaseTypeDto>>> getAllCombinedTypes() {
//        try {
//            List<BaseTypeDto> allTypes = genericTypeService.getAllCombinedTypes();
//            ApiResponse<List<BaseTypeDto>> response = new ApiResponse<>(true, "All types fetched successfully", allTypes);
//            return ResponseEntity.ok(response);
//        } catch (RuntimeException e) {
//            ApiResponse<List<BaseTypeDto>> response = new ApiResponse<>(false, "Error fetching types: " + e.getMessage(), null);
//            return ResponseEntity.badRequest().body(response);
//        }
//    }
}
