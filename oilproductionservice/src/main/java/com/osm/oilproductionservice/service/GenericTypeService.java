package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.dto.genericDTO.*;
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
     private final VarietyRepository varietyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GenericTypeService(WasteTypeRepository wasteTypeRepository, RegionRepository regionRepository,
                              SupplierTypeEntityRepository supplierTypeEntityRepository,
                              VarietyRepository varietyRepository, ModelMapper modelMapper) {
        this.wasteTypeRepository = wasteTypeRepository;
        this.regionRepository = regionRepository;
        this.supplierTypeEntityRepository = supplierTypeEntityRepository;
         this.varietyRepository = varietyRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Create a new type.
     */
    public BaseTypeDto createType(BaseTypeDto baseTypeDto) {
        // Ensure the DTO is not null
        if (baseTypeDto == null) {
            throw new IllegalArgumentException("BaseTypeDto cannot be null.");
        }

        // Use getClass() to determine the runtime type of the object
        Class<?> dtoClass = baseTypeDto.getClass();

        // Handle each type based on its class
        if (dtoClass.equals(WasteTypeDto.class)) {
            return handleWasteType((WasteTypeDto) baseTypeDto);
        } else if (dtoClass.equals(RegionDto.class)) {
            return handleRegion((RegionDto) baseTypeDto);
        } else if (dtoClass.equals(SupplierTypeDto.class)) {
            return handleSupplierType((SupplierTypeDto) baseTypeDto);
        } else if (dtoClass.equals(OliveVarietyDto.class)) {
            return handleOliveVariety((OliveVarietyDto) baseTypeDto);
        } else   {
            throw new RuntimeException("Unknown type: " + dtoClass.getSimpleName());
        }
    }



    private BaseTypeDto handleOliveVariety(OliveVarietyDto oliveVarietyDto) {
        if (varietyRepository.existsByName(oliveVarietyDto.getName())) {
            throw new RuntimeException("A Variety with this name already exists.");
        }
        OliveVariety oliveVariety = modelMapper.map(oliveVarietyDto, OliveVariety.class);
        OliveVariety savedOliveVariety = varietyRepository.save(oliveVariety);
        return modelMapper.map(savedOliveVariety, OliveVarietyDto.class);
    }

    private BaseTypeDto handleSupplierType(SupplierTypeDto supplierTypeDto) {
        if (supplierTypeEntityRepository.existsByName(supplierTypeDto.getName())) {
            throw new RuntimeException("A SupplierType with this name already exists.");
        }
        SupplierType supplierType = modelMapper.map(supplierTypeDto, SupplierType.class);
        SupplierType savedSupplierType = supplierTypeEntityRepository.save(supplierType);
        return modelMapper.map(savedSupplierType, SupplierTypeDto.class);
    }

    private BaseTypeDto handleRegion(RegionDto regionDto) {
        if (regionRepository.existsByName(regionDto.getName())) {
            throw new RuntimeException("A Region with this name already exists.");
        }
        Region region = modelMapper.map(regionDto, Region.class);
        Region savedRegion = regionRepository.save(region);
        return modelMapper.map(savedRegion, RegionDto.class);
    }

    private BaseTypeDto handleWasteType(WasteTypeDto wasteTypeDto) {
        if (wasteTypeRepository.existsByName(wasteTypeDto.getName())) {
            throw new RuntimeException("A WasteType with this name already exists.");
        }
        WasteType wasteType = modelMapper.map(wasteTypeDto, WasteType.class);
        WasteType savedWasteType = wasteTypeRepository.save(wasteType);
        return modelMapper.map(savedWasteType, WasteTypeDto.class);
    }

    /**
     * Retrieve all types of a specific category.
     */
    public List<Object> getAllTypes(String type) {
        switch (type.toLowerCase()) {
            case WASTETYPE -> {
                return Collections.singletonList(wasteTypeRepository.findAll().stream().map(entity -> modelMapper.map(entity, WasteTypeDto.class)).toList());
            }
            case REGION -> {
                return Collections.singletonList(regionRepository.findAll().stream().map(entity -> modelMapper.map(entity, RegionDto.class)).toList());
            }
            case SUPPLIERTYPE -> {
                return Collections.singletonList(supplierTypeEntityRepository.findAll().stream().map(entity -> modelMapper.map(entity, SupplierTypeDto.class)).toList());
            }
            case OLIVE_VARIETY -> {
                return Collections.singletonList(varietyRepository.findAll().stream().map(entity -> modelMapper.map(entity, OliveVarietyDto.class)).toList());
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
            case OLIVE_VARIETY -> varietyRepository.findById(id);
             default -> throw new RuntimeException("Unknown type: " + type);
        };
        return entity.map(e -> modelMapper.map(e, BaseTypeDto.class)).orElse(null);
    }

    /**
     * Update a type by ID.
     */
    public BaseTypeDto updateType( BaseTypeDto baseTypeDto) {
        // Ensure the DTO is not null
        if (baseTypeDto == null) {
            throw new IllegalArgumentException("BaseTypeDto cannot be null.");
        }
        Long id=baseTypeDto.getId();
        // Use getClass() to determine the runtime type of the object
        Class<?> dtoClass = baseTypeDto.getClass();

        // Handle each type based on its class
        if (dtoClass.equals(WasteTypeDto.class)) {
            return handleWasteTypeUpdate(id, (WasteTypeDto) baseTypeDto);
        } else if (dtoClass.equals(RegionDto.class)) {
            return handleRegionUpdate(id, (RegionDto) baseTypeDto);
        } else if (dtoClass.equals(SupplierTypeDto.class)) {
            return handleSupplierTypeUpdate(id, (SupplierTypeDto) baseTypeDto);
        } else if (dtoClass.equals(OliveVarietyDto.class)) {
            return handleOliveVarietyUpdate(id, (OliveVarietyDto) baseTypeDto);
        }  else {
            throw new RuntimeException("Unknown type: " + dtoClass.getSimpleName());
        }
    }

    private BaseTypeDto handleWasteTypeUpdate(Long id, WasteTypeDto wasteTypeDto) {
        WasteType existingWasteType = wasteTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("WasteType not found"));
        modelMapper.map(wasteTypeDto, existingWasteType); // Map updated fields
        WasteType updatedWasteType = wasteTypeRepository.save(existingWasteType);
        return modelMapper.map(updatedWasteType, WasteTypeDto.class);
    }

    private BaseTypeDto handleRegionUpdate(Long id, RegionDto regionDto) {
        Region existingRegion = regionRepository.findById(id).orElseThrow(() -> new RuntimeException("Region not found"));
        modelMapper.map(regionDto, existingRegion); // Map updated fields
        Region updatedRegion = regionRepository.save(existingRegion);
        return modelMapper.map(updatedRegion, RegionDto.class);
    }

    private BaseTypeDto handleSupplierTypeUpdate(Long id, SupplierTypeDto supplierTypeDto) {
        SupplierType existingSupplierType = supplierTypeEntityRepository.findById(id).orElseThrow(() -> new RuntimeException("SupplierType not found"));
        modelMapper.map(supplierTypeDto, existingSupplierType); // Map updated fields
        SupplierType updatedSupplierType = supplierTypeEntityRepository.save(existingSupplierType);
        return modelMapper.map(updatedSupplierType, SupplierTypeDto.class);
    }



    private BaseTypeDto handleOliveVarietyUpdate(Long id, OliveVarietyDto oliveVarietyDto) {
        OliveVariety existingOliveVariety = varietyRepository.findById(id).orElseThrow(() -> new RuntimeException("Variety not found"));
        modelMapper.map(oliveVarietyDto, existingOliveVariety); // Map updated fields
        OliveVariety updatedOliveVariety = varietyRepository.save(existingOliveVariety);
        return modelMapper.map(updatedOliveVariety, OliveVarietyDto.class);
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
            case OLIVE_VARIETY -> {
                if (varietyRepository.existsById(id)) {
                    varietyRepository.deleteById(id);
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
        combinedTypes.addAll(wasteTypeRepository.findAll().stream().map(entity -> modelMapper.map(entity, BaseTypeDto.class)).toList());
        combinedTypes.addAll(regionRepository.findAll().stream().map(entity -> modelMapper.map(entity, BaseTypeDto.class)).toList());
        combinedTypes.addAll(supplierTypeEntityRepository.findAll().stream().map(entity -> modelMapper.map(entity, BaseTypeDto.class)).toList());
        combinedTypes.addAll(varietyRepository.findAll().stream().map(entity -> modelMapper.map(entity, BaseTypeDto.class)).toList());

        return combinedTypes;
    }
}