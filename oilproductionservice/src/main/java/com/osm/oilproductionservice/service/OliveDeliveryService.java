//package com.osm.oilproductionservice.service;
//
//
//import com.osm.oilproductionservice.dto.UnifiedDeliveryDTO;
//import com.osm.oilproductionservice.model.UnifiedDelivery;
//import com.osm.oilproductionservice.repository.DeliveryRepository;
//import com.osm.oilproductionservice.repository.GenericRepository;
//import com.xdev.xdevbase.repos.BaseRepository;
//import com.xdev.xdevbase.services.impl.BaseServiceImpl;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UnifiedDeliveryService extends BaseServiceImpl<UnifiedDelivery, UnifiedDeliveryDTO, UnifiedDeliveryDTO> {
//
//
//
//    public UnifiedDeliveryService(BaseRepository<UnifiedDelivery> repository, ModelMapper modelMapper   ) {
//        super(repository, modelMapper);
//
//    }
//
/// /    public DeliveryDto create(DeliveryDto dto) {
/// /        // 1) Map base (non-reference) fields from DTO to UnifiedDelivery entity.
/// /        //    You can either map them selectively or (carefully) use ModelMapper,
/// /        //    but avoid overwriting the references with null objects.
/// /        UnifiedDelivery delivery = new UnifiedDelivery();
/// /        modelMapper.map(dto, delivery);  // This should only map scalar fields, not references
/// /
/// /        // 2) Lookup and set references using the IDs from nested DTOs.
/// /
/// /        // SupplierInfo
/// /        if (dto.getSupplier() != null  ) {
/// /             SupplierInfo supplier = supplierRepository.findById(dto.getSupplier())
/// /                    .orElseThrow(() -> new RuntimeException("SupplierInfo not found with id: " + dto.getSupplier()));
/// /            delivery.setSupplier(supplier);
/// /        }
/// /
/// /        // Region (BaseType)
/// /        if (dto.getRegion() != null ){
/// /             BaseType region = genericRepository.findById(dto.getRegion())
/// /                    .orElseThrow(() -> new RuntimeException("Region not found with id: " + dto.getRegion()  ));
/// /            delivery.setRegion(region);
/// /        }
/// /
/// /        // Olive Variety (BaseType)
/// /        if (dto.getOliveVarietyId() != null ) {
/// /            UUID oliveVarietyId =  dto.getOliveVarietyId() ;
/// /            BaseType oliveVariety = genericRepository.findById(oliveVarietyId)
/// /                    .orElseThrow(() -> new RuntimeException("Olive variety not found with id: " + oliveVarietyId));
/// /            delivery.setOliveVariety(oliveVariety);
/// /        }
/// /
/// /        // Olive Type (BaseType)
/// /        if (dto.getOliveTypeId() != null ) {
/// /            UUID oliveTypeId =  dto.getOliveTypeId() ;
/// /            BaseType oliveType = genericRepository.findById(oliveTypeId)
/// /                    .orElseThrow(() -> new RuntimeException("Olive type not found with id: " + oliveTypeId));
/// /            delivery.setOliveType(oliveType);
/// /        }
/// /
/// /        // 3) Save the UnifiedDelivery entity
/// /        delivery = deliveryRepository.save(delivery);
/// /
/// /        // 4) Map back to DeliveryDto to return the newly created record
/// /        return modelMapper.map(delivery, DeliveryDto.class);
/// /    }
//}
