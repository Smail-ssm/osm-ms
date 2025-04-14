package com.osm.oilproductionservice.controller;

import com.osm.oilproductionservice.dto.SupplierDto;
import com.osm.oilproductionservice.model.Supplier;
import com.osm.oilproductionservice.service.SupplierTypeService;
import com.xdev.xdevbase.apiDTOs.ApiResponse;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/production/suppliers_type")
public class SupplierTypeController extends BaseControllerImpl<Supplier, SupplierDto, SupplierDto> {

    @Autowired
    private SupplierTypeService supplierService;

    public SupplierTypeController(BaseService<Supplier, SupplierDto, SupplierDto> baseService, ModelMapper modelMapper, SupplierTypeService supplierService) {
        super(baseService, modelMapper);
        this.supplierService = supplierService;
    }

    @Override
    @PostMapping
    public ResponseEntity<ApiResponse<Supplier, SupplierDto>> create(@RequestBody SupplierDto dto) {

        try {
            SupplierDto savedSupplier = this.supplierService.save(dto);
            return ResponseEntity.ok(new ApiResponse<Supplier, SupplierDto>(true, "", List.of(savedSupplier)));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ApiResponse<Supplier, SupplierDto>(false, e.getMessage(), null));
        }
    }
//@Override
//@PutMapping
//public ResponseEntity<ApiResponse<Supplier, SupplierDto>> update(@RequestBody SupplierDto dto) {
//    try {
//        dto.setId(dto.getId());
//        dto.getSupplier().setId(dto.getSupplier().getId());
//
//        SupplierDto savedEntity = this.supplierService.update(dto);
//        return ResponseEntity.ok(new ApiResponse(true, "", List.of(savedEntity)));
//    } catch (Exception e) {
//        return ResponseEntity.status(404).body(new ApiResponse(false, e.getMessage(), (List)null));
//    }
//}
}
