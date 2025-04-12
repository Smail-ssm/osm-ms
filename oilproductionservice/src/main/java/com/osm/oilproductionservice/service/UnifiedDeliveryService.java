package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.dto.UnifiedDeliveryDTO;
import com.osm.oilproductionservice.model.UnifiedDelivery;
import com.osm.oilproductionservice.repository.DeliveryRepository;
import com.osm.oilproductionservice.repository.GenericRepository;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UnifiedDeliveryService extends BaseServiceImpl<UnifiedDelivery, UnifiedDeliveryDTO, UnifiedDeliveryDTO> {

    private final GenericRepository genericRepository;
    private final DeliveryRepository deliveryRepository;

    public UnifiedDeliveryService(BaseRepository<UnifiedDelivery> repository, ModelMapper modelMapper, GenericRepository genericRepository, DeliveryRepository deliveryRepository) {
        super(repository, modelMapper);
        this.genericRepository = genericRepository;
        this.deliveryRepository = deliveryRepository;
    }

//    public ApiResponse<UnifiedDelivery, DeliveryDto> getAllWithNextLotNumberInMessage() {
//        List<Object[]> rawResults = deliveryRepository.findAllWithNextId();
//
//        if (rawResults.isEmpty()) {
//            return new ApiResponse<>(true, "{\"nextLotNumber\": 1}", List.of());
//        }
//
//        // Extract nextId from the first row only
//        Object nextIdRaw = rawResults.get(0)[rawResults.get(0).length - 1];
//        Long nextLotNumber = (nextIdRaw instanceof Number) ? ((Number) nextIdRaw).longValue() : 1L;
//
//        // Extract all UnifiedDelivery entities from the result
//        List<DeliveryDto> dtoList = rawResults.stream()
//                .map(row -> {
//                    UnifiedDelivery delivery = new UnifiedDelivery();
//                    delivery.setId(((UUID) row[0]));
//                    delivery.setReceiptNumber((String) row[1]);
//                    delivery.setDeliveryNumber((String) row[2]);
//                    delivery.setLotNumber((String) row[3]);
//                    delivery.setDeliveryDate((LocalDateTime) row[4]);
//                    delivery.setTrtDate((LocalDateTime) row[5]);
//                    delivery.setStatus(row[6] != null ? OliveLotStatus.valueOf((String) row[6]) : null);
//                    delivery.setGlobalLotNumber((String) row[7]);
//                    delivery.setOliveQuantity(row[8] != null ? ((Number) row[8]).floatValue() : null);
//                    delivery.setOilQuantity(row[9] != null ? ((Number) row[9]).floatValue() : null);
//                    delivery.setRendement(row[10] != null ? ((Number) row[10]).floatValue() : null);
//                    delivery.setUnitPrice(row[20] != null ? ((Number) row[20]).floatValue() : null);
//                    delivery.setPrice(row[21] != null ? ((Number) row[21]).floatValue() : null);
//                    delivery.setPaidAmount(row[22] != null ? ((Number) row[22]).floatValue() : null);
//                    delivery.setUnpaidAmount(row[23] != null ? ((Number) row[23]).floatValue() : null);
//                    delivery.setTierOrBase((String) row[24]);
//                    delivery.setParcel((String) row[25]);
//
//                    return modelMapper.map(delivery, DeliveryDto.class);
//                })
//                .toList();
//
//        String messageJson = String.format("{\"nextLotNumber\": %d}", nextLotNumber);
//        return new ApiResponse<>(true, messageJson, dtoList);
//    }

//    public DeliveryDto create(DeliveryDto dto) {
//        // 1) Map base (non-reference) fields from DTO to UnifiedDelivery entity.
//        //    You can either map them selectively or (carefully) use ModelMapper,
//        //    but avoid overwriting the references with null objects.
//        UnifiedDelivery delivery = new UnifiedDelivery();
//        modelMapper.map(dto, delivery);  // This should only map scalar fields, not references
//
//        // 2) Lookup and set references using the IDs from nested DTOs.
//
//        // SupplierInfo
//        if (dto.getSupplier() != null  ) {
//             SupplierInfo supplier = supplierRepository.findById(dto.getSupplier())
//                    .orElseThrow(() -> new RuntimeException("SupplierInfo not found with id: " + dto.getSupplier()));
//            delivery.setSupplier(supplier);
//        }
//
//        // Region (BaseType)
//        if (dto.getRegion() != null ){
//             BaseType region = genericRepository.findById(dto.getRegion())
//                    .orElseThrow(() -> new RuntimeException("Region not found with id: " + dto.getRegion()  ));
//            delivery.setRegion(region);
//        }
//
//        // Olive Variety (BaseType)
//        if (dto.getOliveVarietyId() != null ) {
//            UUID oliveVarietyId =  dto.getOliveVarietyId() ;
//            BaseType oliveVariety = genericRepository.findById(oliveVarietyId)
//                    .orElseThrow(() -> new RuntimeException("Olive variety not found with id: " + oliveVarietyId));
//            delivery.setOliveVariety(oliveVariety);
//        }
//
//        // Olive Type (BaseType)
//        if (dto.getOliveTypeId() != null ) {
//            UUID oliveTypeId =  dto.getOliveTypeId() ;
//            BaseType oliveType = genericRepository.findById(oliveTypeId)
//                    .orElseThrow(() -> new RuntimeException("Olive type not found with id: " + oliveTypeId));
//            delivery.setOliveType(oliveType);
//        }
//
//        // 3) Save the UnifiedDelivery entity
//        delivery = deliveryRepository.save(delivery);
//
//        // 4) Map back to DeliveryDto to return the newly created record
//        return modelMapper.map(delivery, DeliveryDto.class);
//    }
}
