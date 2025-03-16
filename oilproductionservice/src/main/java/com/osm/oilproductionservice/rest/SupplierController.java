package com.osm.oilproductionservice.rest;


import com.osm.oilproductionservice.domain.Supplier;
import com.osm.oilproductionservice.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/production/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public Supplier addSupplier(@RequestBody Supplier supplier) {
        return supplierService.addSupplier(supplier);
    }

    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        return supplierService.updateSupplier(id, supplier);
    }

    @GetMapping("/{id}")
    public Supplier getSupplier(@PathVariable Long id) {
        return supplierService.getSupplier(id);
    }

    @GetMapping("/region/{regionId}")
    public Supplier getSupplierByRegion(@PathVariable Long regionId) {
        return supplierService.getSupplierByRegion(regionId);
    }
}