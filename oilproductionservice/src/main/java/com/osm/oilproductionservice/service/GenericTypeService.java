package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.dto.*;
import com.osm.oilproductionservice.model.customTypes.*;
import com.osm.oilproductionservice.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.osm.oilproductionservice.constants.constants.*;

@Service
public class GenericTypeService {

    private final WasteTypeRepository wasteTypeRepository;
    private final RegionRepository regionRepository;
    private final SupplierTypeEntityRepository supplierTypeEntityRepository;
     private final OliveLotStatusTypeRepository oliveLotStatusTypeRepository;
    private final VarietyRepository varietyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GenericTypeService(WasteTypeRepository wasteTypeRepository,
                              RegionRepository regionRepository,
                              SupplierTypeEntityRepository supplierTypeEntityRepository,
                               OliveLotStatusTypeRepository oliveLotStatusTypeRepository,
                              VarietyRepository varietyRepository,
                              ModelMapper modelMapper) {
        this.wasteTypeRepository = wasteTypeRepository;
        this.regionRepository = regionRepository;
        this.supplierTypeEntityRepository = supplierTypeEntityRepository;
         this.oliveLotStatusTypeRepository = oliveLotStatusTypeRepository;
        this.varietyRepository = varietyRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Create a new type.
     */
    public BaseTypeDto createType(BaseTypeDto baseTypeDto, String type) {
        switch (type.toLowerCase()) {
            case WASTETYPE -> {
                if (wasteTypeRepository.existsByName(baseTypeDto.getName())) {
                    throw new RuntimeException("A WasteType with this name already exists.");
                }
                WasteType wasteType = modelMapper.map(baseTypeDto, WasteType.class);
                WasteType savedWasteType = wasteTypeRepository.save(wasteType);
                return modelMapper.map(savedWasteType, WasteTypeDto.class);
            }
            case REGION -> {
                if (regionRepository.existsByName(baseTypeDto.getName())) {
                    throw new RuntimeException("A Region with this name already exists.");
                }
                Region region = modelMapper.map(baseTypeDto, Region.class);
                Region savedRegion = regionRepository.save(region);
                return modelMapper.map(savedRegion, RegionDto.class);
            }
            case SUPPLIERTYPE -> {
                if (supplierTypeEntityRepository.existsByName(baseTypeDto.getName())) {
                    throw new RuntimeException("A SupplierType with this name already exists.");
                }
                SupplierType supplierType = modelMapper.map(baseTypeDto, SupplierType.class);
                SupplierType savedSupplierType = supplierTypeEntityRepository.save(supplierType);
                return modelMapper.map(savedSupplierType, SupplierTypeDto.class);
            }
            case VARIETY -> {
                if (varietyRepository.existsByName(baseTypeDto.getName())) {
                    throw new RuntimeException("A Variety with this name already exists.");
                }
                OliveVariety oliveVariety = modelMapper.map(baseTypeDto, OliveVariety.class);
                OliveVariety savedOliveVariety = varietyRepository.save(oliveVariety);
                return modelMapper.map(savedOliveVariety, OliveVarietyDto.class);
            }
            case OLIVELOTSTATUSTYPE -> {
                if (oliveLotStatusTypeRepository.existsByName(baseTypeDto.getName())) {
                    throw new RuntimeException("An OliveLotStatusType with this name already exists.");
                }
                OliveLotStatusType oliveLotStatusType = modelMapper.map(baseTypeDto, OliveLotStatusType.class);
                OliveLotStatusType savedOliveLotStatusType = oliveLotStatusTypeRepository.save(oliveLotStatusType);
                return modelMapper.map(savedOliveLotStatusType, OliveLotStatusTypeDto.class);
            }

            default -> throw new RuntimeException("Unknown type: " + type);
        }
    }

    /**
     * Retrieve all types of a specific category.
     */
    public List<Object> getAllTypes(String type) {
        switch (type.toLowerCase()) {
            case WASTETYPE -> {
                return Collections.singletonList(wasteTypeRepository.findAll().stream()
                        .map(entity -> modelMapper.map(entity, WasteTypeDto.class))
                        .toList());
            }
            case REGION -> {
                return Collections.singletonList(regionRepository.findAll().stream()
                        .map(entity -> modelMapper.map(entity, RegionDto.class))
                        .toList());
            }
            case SUPPLIERTYPE -> {
                return Collections.singletonList(supplierTypeEntityRepository.findAll().stream()
                        .map(entity -> modelMapper.map(entity, SupplierTypeDto.class))
                        .toList());
            }
            case VARIETY -> {
                return Collections.singletonList(varietyRepository.findAll().stream()
                        .map(entity -> modelMapper.map(entity, OliveVarietyDto.class))
                        .toList());
            }
            case OLIVELOTSTATUSTYPE -> {
                return Collections.singletonList(oliveLotStatusTypeRepository.findAll().stream()
                        .map(entity -> modelMapper.map(entity, OliveLotStatusTypeDto.class))
                        .toList());
            }

            default -> throw new RuntimeException("Unknown type: " + type);
        }
    }

    /**
     * Retrieve a type by ID.
     */
    public BaseTypeDto getType(Long id, String type) {
        Optional<?> entity = switch (type.toLowerCase()) {
            case WASTETYPE -> wasteTypeRepository.findById(id);
            case REGION -> regionRepository.findById(id);
            case SUPPLIERTYPE -> supplierTypeEntityRepository.findById(id);
            case VARIETY -> varietyRepository.findById(id);
            case OLIVELOTSTATUSTYPE -> oliveLotStatusTypeRepository.findById(id);
             default -> throw new RuntimeException("Unknown type: " + type);
        };
        return entity.map(e -> modelMapper.map(e, BaseTypeDto.class)).orElse(null);
    }

    /**
     * Update a type by ID.
     */
    public BaseTypeDto updateType(Long id, BaseTypeDto baseTypeDto, String type) {
        switch (type.toLowerCase()) {
            case WASTETYPE -> {
                WasteType existingWasteType = wasteTypeRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("WasteType not found"));
                modelMapper.map(baseTypeDto, existingWasteType);
                WasteType updatedWasteType = wasteTypeRepository.save(existingWasteType);
                return modelMapper.map(updatedWasteType, WasteTypeDto.class);
            }
            case REGION -> {
                Region existingRegion = regionRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Region not found"));
                modelMapper.map(baseTypeDto, existingRegion);
                Region updatedRegion = regionRepository.save(existingRegion);
                return modelMapper.map(updatedRegion, RegionDto.class);
            }
            case SUPPLIERTYPE -> {
                SupplierType existingSupplierType = supplierTypeEntityRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("SupplierType not found"));
                modelMapper.map(baseTypeDto, existingSupplierType);
                SupplierType updatedSupplierType = supplierTypeEntityRepository.save(existingSupplierType);
                return modelMapper.map(updatedSupplierType, SupplierTypeDto.class);
            }
            case VARIETY -> {
                OliveVariety existingOliveVariety = varietyRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Variety not found"));
                modelMapper.map(baseTypeDto, existingOliveVariety);
                OliveVariety updatedOliveVariety = varietyRepository.save(existingOliveVariety);
                return modelMapper.map(updatedOliveVariety, OliveVarietyDto.class);
            }
            case OLIVELOTSTATUSTYPE -> {
                OliveLotStatusType existingOliveLotStatusType = oliveLotStatusTypeRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("OliveLotStatusType not found"));
                modelMapper.map(baseTypeDto, existingOliveLotStatusType);
                OliveLotStatusType updatedOliveLotStatusType = oliveLotStatusTypeRepository.save(existingOliveLotStatusType);
                return modelMapper.map(updatedOliveLotStatusType, OliveLotStatusTypeDto.class);
            }

            default -> throw new RuntimeException("Unknown type: " + type);
        }
    }

    /**
     * Delete a type by ID.
     */
    public boolean deleteType(Long id, String type) {
        switch (type.toLowerCase()) {
            case WASTETYPE -> {
                if (wasteTypeRepository.existsById(id)) {
                    wasteTypeRepository.deleteById(id);
                    return true;
                }
            }
            case REGION -> {
                if (regionRepository.existsById(id)) {
                    regionRepository.deleteById(id);
                    return true;
                }
            }
            case SUPPLIERTYPE -> {
                if (supplierTypeEntityRepository.existsById(id)) {
                    supplierTypeEntityRepository.deleteById(id);
                    return true;
                }
            }
            case VARIETY -> {
                if (varietyRepository.existsById(id)) {
                    varietyRepository.deleteById(id);
                    return true;
                }
            }
            case OLIVELOTSTATUSTYPE -> {
                if (oliveLotStatusTypeRepository.existsById(id)) {
                    oliveLotStatusTypeRepository.deleteById(id);
                    return true;
                }
            }

            default -> throw new RuntimeException("Unknown type: " + type);
        }
        return false;
    }

    /**
     * Return all types regardless of their category.
     */
    public List<BaseTypeDto> getAllCombinedTypes() {
        List<BaseTypeDto> combinedTypes = new ArrayList<>();
        combinedTypes.addAll(wasteTypeRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, BaseTypeDto.class))
                .toList());
        combinedTypes.addAll(regionRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, BaseTypeDto.class))
                .toList());
        combinedTypes.addAll(supplierTypeEntityRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, BaseTypeDto.class))
                .toList());
        combinedTypes.addAll(varietyRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, BaseTypeDto.class))
                .toList());
        combinedTypes.addAll(oliveLotStatusTypeRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, BaseTypeDto.class))
                .toList());

        return combinedTypes;
    }
}