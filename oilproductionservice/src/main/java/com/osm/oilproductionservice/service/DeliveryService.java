package com.osm.oilproductionservice.service;

 import com.osm.oilproductionservice.dto.DeliveryDto;
 import com.osm.oilproductionservice.model.Delivery;
 import com.osm.oilproductionservice.repository.DeliveryRepository;
import com.osm.oilproductionservice.repository.GenericRepository;
import com.osm.oilproductionservice.repository.SupplierRepository;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService extends BaseServiceImpl<Delivery, DeliveryDto, DeliveryDto> {

    private final SupplierRepository supplierRepository;
    private final GenericRepository genericRepository;
    private final DeliveryRepository deliveryRepository;

    public DeliveryService(BaseRepository<Delivery> repository, ModelMapper modelMapper, SupplierRepository supplierRepository, GenericRepository genericRepository, DeliveryRepository deliveryRepository) {
        super(repository, modelMapper);
        this.supplierRepository = supplierRepository;
        this.genericRepository = genericRepository;
        this.deliveryRepository = deliveryRepository;
    }

//    public DeliveryDto create(DeliveryDto dto) {
//        // 1) Map base (non-reference) fields from DTO to Delivery entity.
//        //    You can either map them selectively or (carefully) use ModelMapper,
//        //    but avoid overwriting the references with null objects.
//        Delivery delivery = new Delivery();
//        modelMapper.map(dto, delivery);  // This should only map scalar fields, not references
//
//        // 2) Lookup and set references using the IDs from nested DTOs.
//
//        // Supplier
//        if (dto.getSupplier() != null  ) {
//             Supplier supplier = supplierRepository.findById(dto.getSupplier())
//                    .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + dto.getSupplier()));
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
//        // 3) Save the Delivery entity
//        delivery = deliveryRepository.save(delivery);
//
//        // 4) Map back to DeliveryDto to return the newly created record
//        return modelMapper.map(delivery, DeliveryDto.class);
//    }
}
