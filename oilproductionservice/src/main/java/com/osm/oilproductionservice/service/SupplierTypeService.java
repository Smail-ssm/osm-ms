package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.dto.SupplierDto;
import com.osm.oilproductionservice.model.Supplier;
import com.osm.oilproductionservice.repository.GenericRepository;
import com.osm.oilproductionservice.repository.SupplierInfoTypeRepository;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SupplierTypeService extends BaseServiceImpl<Supplier, SupplierDto, SupplierDto> {

    // Repository to reattach BaseType entities (for region and supplier type)
    private final GenericRepository baseTypeRepository;
    private final SupplierInfoTypeRepository supplierInfoRepository;

    // Constructor injection: in addition to Supplier repository and ModelMapper,
    // inject the BaseType repository.
    public SupplierTypeService(BaseRepository<Supplier> repository,
                               ModelMapper modelMapper,
                               GenericRepository baseTypeRepository, SupplierInfoTypeRepository supplierInfoRepository) {
        super(repository, modelMapper);
        this.baseTypeRepository = baseTypeRepository;
        this.supplierInfoRepository = supplierInfoRepository;
    }

//    @Override
//    public SupplierDto save(SupplierDto request) {
//        // 1. Map and save the supplier details (SupplierInfo) first.
//        SupplierInfo supplierInfo = modelMapper.map(request.getSupplier(), SupplierInfo.class);
//
//        // Reattach the region: load a managed BaseType for the region.
//        if (supplierInfo != null && supplierInfo.getRegion() != null) {
//            UUID regionId = supplierInfo.getRegion().getId();
//            BaseType managedRegion = baseTypeRepository.findById(regionId)
//                    .orElseThrow(() -> new IllegalArgumentException("Region not found for id: " + regionId));
//            supplierInfo.setRegion(managedRegion);
//        }
//
//        // Persist the SupplierInfo first.
//        SupplierInfo savedSupplierInfo = supplierInfoRepository.save(supplierInfo);
//
//        // 2. Reattach the generic supplier type.
//        BaseType managedType = null;
//        if (request.getGenericSuppliertype() != null) {
//            UUID typeId = request.getGenericSuppliertype().getId();
//            managedType = baseTypeRepository.findById(typeId)
//                    .orElseThrow(() -> new IllegalArgumentException("Supplier type not found for id: " + typeId));
//        }
//
//        // 3. Create the Supplier entity and set its associations.
//        Supplier supplier = new Supplier();
//        supplier.setSupplierInfo(savedSupplierInfo);  // use the persisted SupplierInfo
//        supplier.setGenericSupplierType(managedType);
//
//        // Save the Supplier entity.
//        Supplier savedSupplier = repository.save(supplier);
//
//        // Map the saved entity back to DTO and return.
//        return modelMapper.map(savedSupplier, SupplierDto.class);
//    }
//    @Override
//     public SupplierDto update(SupplierDto request) {
//        // Validate the incoming request and ensure the ID is provided.
//        if (request == null || request.getId() == null) {
//             return null;
//        }
//
//        // Retrieve the existing Supplier entity (with the immutable inherited id)
//        Optional<Supplier> existedOptEntity = this.repository.findById(request.getId());
//        if (existedOptEntity.isEmpty()) {
//             return null;
//        }
//
//        Supplier existedEntity = existedOptEntity.get();
//
//        // Make sure the DTO's id is set to the entity’s current id
//        // This is a precaution to guard against accidental changes.
//        request.setId(existedEntity.getId());
//
//
//        // Configure ModelMapper to skip modifying the id (if not already configured globally)
//        this.modelMapper.typeMap(SupplierDto.class, Supplier.class)
//                .addMappings(mapper -> mapper.skip(Supplier::setId));
//
//        // Map mutable fields from the DTO to the existing entity
//        this.modelMapper.map(request, existedEntity);
//
//
//        // Persist the updated entity.
//        Supplier updatedEntity = this.repository.save(existedEntity);
//
//        // Map the updated entity to a response DTO
//        SupplierDto outDto = this.modelMapper.map(updatedEntity, SupplierDto.class);
//        return outDto;
//    }
}
