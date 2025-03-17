package com.osm.oilproductionservice.service;


import com.osm.oilproductionservice.domain.Supplier;
import com.osm.oilproductionservice.repository.RegionRepository;
import com.osm.oilproductionservice.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private RegionRepository regionRepository;

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier supplier) {
        supplier.setId(id);
        return supplierRepository.save(supplier);
    }

    public Supplier getSupplier(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public Supplier getSupplierByRegion(Long regionId) {
        return supplierRepository.findById(regionId).orElse(null); // or custom query for region-based suppliers
    }
    // New method to get all suppliers
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
}