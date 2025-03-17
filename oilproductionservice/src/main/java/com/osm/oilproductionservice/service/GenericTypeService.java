package com.osm.oilproductionservice.service;


import com.osm.oilproductionservice.domain.customTypes.Region;
import com.osm.oilproductionservice.domain.customTypes.*;
import com.osm.oilproductionservice.repository.*;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.osm.oilproductionservice.constants.constants.*;


@Service
public class GenericTypeService {


    private final WasteTypeRepository wasteTypeRepository;
    private final RegionRepository regionRepository;
    private final SupplierTypeEntityRepository supplierTypeEntityRepository;
    private final OliveVarietyTypeRepository oliveVarietyTypeRepository;
    private final OliveLotStatusTypeRepository oliveLotStatusTypeRepository;

    public GenericTypeService(WasteTypeRepository wasteTypeRepository, RegionRepository regionRepository, SupplierTypeEntityRepository supplierTypeEntityRepository, OliveVarietyTypeRepository oliveVarietyTypeRepository, OliveLotStatusTypeRepository oliveLotStatusTypeRepository) {
        this.wasteTypeRepository = wasteTypeRepository;
        this.regionRepository = regionRepository;
        this.supplierTypeEntityRepository = supplierTypeEntityRepository;
        this.oliveVarietyTypeRepository = oliveVarietyTypeRepository;
        this.oliveLotStatusTypeRepository = oliveLotStatusTypeRepository;
    }

    public Object createType(BaseType baseType, String type) {
        return switch (type.toLowerCase()) {
            case WASTETYPE -> {
                // Check if a similar WasteType already exists by name
                if (wasteTypeRepository.existsByName(baseType.getName())) {
                    throw new ServiceException("A WasteType with this name already exists.");
                }
                yield wasteTypeRepository.save((WasteType) baseType);
            }
            case REGION -> {
                // Check if a similar WasteType already exists by name
                if (regionRepository.existsByName(baseType.getName())) {
                    throw new ServiceException("A WasteType with this name already exists.");
                }
                yield regionRepository.save((Region) baseType);
            }
            case SUPPLIERTYPE -> {
                // Check if a similar SupplierType already exists by name
                if (supplierTypeEntityRepository.existsByName(baseType.getName())) {
                    throw new ServiceException("A SupplierType with this name already exists.");
                }
                yield supplierTypeEntityRepository.save((SupplierType) baseType);
            }
            case OLIVELOTSTATUSTYPE -> {
                // Check if a similar OliveLotStatusType already exists by name
                if (oliveLotStatusTypeRepository.existsByName(baseType.getName())) {
                    throw new ServiceException("An OliveLotStatusType with this name already exists.");
                }
                yield oliveLotStatusTypeRepository.save((OliveLotStatusType) baseType);
            }
            case OLIVEVARIETYTYPE -> {
                // Check if a similar OliveVarietyType already exists by name
                if (oliveVarietyTypeRepository.existsByName(baseType.getName())) {
                    throw new ServiceException("An OliveVarietyType with this name already exists.");
                }
                yield oliveVarietyTypeRepository.save((OliveVarietyType) baseType);
            }
            default -> throw new ServiceException("Unknown type: " + type);
        };
    }

    // Get all types (e.g., all WasteTypes, SupplierTypes, OliveLotStatusTypes)
    public Object getAllTypes(String type) {
        return switch (type.toLowerCase()) {
            case WASTETYPE -> wasteTypeRepository.findAll();
            case SUPPLIERTYPE -> supplierTypeEntityRepository.findAll();
            case OLIVELOTSTATUSTYPE -> oliveLotStatusTypeRepository.findAll();
            case REGION -> regionRepository.findAll();
            case OLIVEVARIETYTYPE -> oliveVarietyTypeRepository.findAll();
            default -> throw new ServiceException("Unknown type: " + type); // Using ServiceException

        };
    }

    // Get a type by ID
    public BaseType getType(Long id, String type) {
        return switch (type.toLowerCase()) {
            case WASTETYPE -> wasteTypeRepository.findById(id).orElse(null);
            case SUPPLIERTYPE -> supplierTypeEntityRepository.findById(id).orElse(null);
            case OLIVELOTSTATUSTYPE -> oliveLotStatusTypeRepository.findById(id).orElse(null);
            case REGION -> regionRepository.findById(id).orElse(null);
            case OLIVEVARIETYTYPE -> oliveVarietyTypeRepository.findById(id).orElse(null);
            default -> throw new ServiceException("Unknown type: " + type); // Using ServiceException

        };
    }

    // Update a type by ID
    public BaseType updateType(Long id, BaseType baseType, String type) {
        switch (type.toLowerCase()) {
            case WASTETYPE -> {
                if (wasteTypeRepository.existsById(id)) {
                    baseType.setId(id);
                    return wasteTypeRepository.save((WasteType) baseType);
                }
            }
            case REGION -> {
                if (regionRepository.existsById(id)) {
                    baseType.setId(id);
                    return regionRepository.save((Region) baseType);
                }
            }
            case SUPPLIERTYPE -> {
                if (supplierTypeEntityRepository.existsById(id)) {
                    baseType.setId(id);
                    return supplierTypeEntityRepository.save((SupplierType) baseType);
                }
            }
            case OLIVELOTSTATUSTYPE -> {
                if (oliveLotStatusTypeRepository.existsById(id)) {
                    baseType.setId(id);
                    return oliveLotStatusTypeRepository.save((OliveLotStatusType) baseType);
                }
            }
            case OLIVEVARIETYTYPE -> {
                if (oliveVarietyTypeRepository.existsById(id)) {
                    baseType.setId(id);
                    return oliveVarietyTypeRepository.save((OliveVarietyType) baseType);
                }
            }
            default -> throw new ServiceException("Unknown type: " + type); // Using ServiceException

        }
        return null;
    }

    // Delete a type by ID
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
            case OLIVEVARIETYTYPE -> {
                if (oliveVarietyTypeRepository.existsById(id)) {
                    oliveVarietyTypeRepository.deleteById(id);
                    return true;
                }
            }
            case SUPPLIERTYPE -> {
                if (supplierTypeEntityRepository.existsById(id)) {
                    supplierTypeEntityRepository.deleteById(id);
                    return true;
                }
            }
            case OLIVELOTSTATUSTYPE -> {
                if (oliveLotStatusTypeRepository.existsById(id)) {
                    oliveLotStatusTypeRepository.deleteById(id);
                    return true;
                }
            }
            default -> throw new ServiceException("Unknown type: " + type); // Using ServiceException

        }
        return false;
    }

    // New method to return all types regardless of their category
    public List<BaseType> getAllCombinedTypes() {
        List<BaseType> combinedTypes = new ArrayList<>();
        combinedTypes.addAll(wasteTypeRepository.findAll());
        combinedTypes.addAll(supplierTypeEntityRepository.findAll());
        combinedTypes.addAll(regionRepository.findAll());
        combinedTypes.addAll(oliveLotStatusTypeRepository.findAll());
        combinedTypes.addAll(oliveVarietyTypeRepository.findAll());
        return combinedTypes;
    }
}
