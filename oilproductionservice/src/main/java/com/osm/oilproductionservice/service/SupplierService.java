package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.model.Supplier;
import com.osm.oilproductionservice.dto.SupplierDto;
import com.osm.oilproductionservice.repository.RegionRepository;
import com.osm.oilproductionservice.repository.SupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final RegionRepository regionRepository;
    private final ModelMapper modelMapper;

    public SupplierService(SupplierRepository supplierRepository, RegionRepository regionRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.regionRepository = regionRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Add a new supplier.
     */
    public SupplierDto addSupplier(SupplierDto supplierDto) {
        Supplier supplier = modelMapper.map(supplierDto, Supplier.class);
        Supplier savedSupplier = supplierRepository.save(supplier);
        return modelMapper.map(savedSupplier, SupplierDto.class);
    }

    /**
     * Update an existing supplier.
     */
    public SupplierDto updateSupplier(Long id, SupplierDto supplierDto) {
        return supplierRepository.findById(id)
                .map(existingSupplier -> {
                    // Map DTO fields to the existing entity
                    modelMapper.map(supplierDto, existingSupplier);
                    Supplier updatedSupplier = supplierRepository.save(existingSupplier);
                    return modelMapper.map(updatedSupplier, SupplierDto.class);
                })
                .orElse(null);
    }

    /**
     * Get a supplier by ID.
     */
    public SupplierDto getSupplier(Long id) {
        return supplierRepository.findById(id)
                .map(supplier -> modelMapper.map(supplier, SupplierDto.class))
                .orElse(null);
    }

    /**
     * Get a supplier by region ID.
     */
    public List<SupplierDto> getSuppliersByRegion(Long regionId) {
        List<Supplier> suppliers = supplierRepository.findSupplierByRegion_Id(regionId); // Assuming a custom query exists
        return suppliers.stream()
                .map(supplier -> modelMapper.map(supplier, SupplierDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Get all suppliers.
     */
    public List<SupplierDto> getAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers.stream()
                .map(supplier -> modelMapper.map(supplier, SupplierDto.class))
                .collect(Collectors.toList());
    }
}