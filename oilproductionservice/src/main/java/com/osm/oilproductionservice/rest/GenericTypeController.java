package com.osm.oilproductionservice.rest;


import com.osm.oilproductionservice.domain.customTypes.BaseType;
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

    // Create a new type (e.g., WasteType, SupplierTypeEntity, OliveLotStatusType)
    @PostMapping("/{type}")
    public ResponseEntity<BaseType> createType(@PathVariable String type, @RequestBody BaseType baseType) {
        Object createdType =  genericTypeService.createType(baseType,type);
        return ResponseEntity.ok((BaseType) createdType);
    }

    // Get all types (e.g., all WasteTypes, SupplierTypes, OliveLotStatusTypes)
    @GetMapping("/{type}")
    public List<BaseType> getAllTypes(@PathVariable String type) {
        return (List<BaseType>) genericTypeService.getAllTypes(type);
    }

    // Get a type by ID
    @GetMapping("/{type}/{id}")
    public ResponseEntity<BaseType> getType(@PathVariable String type, @PathVariable Long id) {
        BaseType typeObj = genericTypeService.getType(id,type);
        if (typeObj != null) {
            return ResponseEntity.ok(typeObj);
        }
        return ResponseEntity.notFound().build();
    }

    // Update a type by ID
    @PutMapping("/{type}/{id}")
    public ResponseEntity<BaseType> updateType(@PathVariable String type, @PathVariable Long id, @RequestBody BaseType baseType) {
        BaseType updatedType = genericTypeService.updateType(id, baseType,type);
        if (updatedType != null) {
            return ResponseEntity.ok(updatedType);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a type by ID
    @DeleteMapping("/{type}/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable String type, @PathVariable Long id) {
        boolean deleted = genericTypeService.deleteType(id,type);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}