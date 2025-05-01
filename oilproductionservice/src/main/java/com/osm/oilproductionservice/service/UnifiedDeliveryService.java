package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.dto.UnifiedDeliveryDTO;
import com.osm.oilproductionservice.model.Supplier;
import com.osm.oilproductionservice.model.UnifiedDelivery;
import com.osm.oilproductionservice.repository.DeliveryRepository;
import com.osm.oilproductionservice.repository.GenericRepository;
import com.osm.oilproductionservice.repository.SupplierInfoTypeRepository;
import com.osm.oilproductionservice.repository.SupplierRepository;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UnifiedDeliveryService extends BaseServiceImpl<UnifiedDelivery, UnifiedDeliveryDTO, UnifiedDeliveryDTO> {

    private final GenericRepository genericRepository;
    private final DeliveryRepository deliveryRepository;
    private final SupplierRepository supplierRepository;
    private final SupplierInfoTypeRepository supplierInfoTypeRepository;

    public UnifiedDeliveryService(BaseRepository<UnifiedDelivery> repository, ModelMapper modelMapper, GenericRepository genericRepository, DeliveryRepository deliveryRepository, SupplierRepository supplierRepository, SupplierInfoTypeRepository supplierInfoTypeRepository) {
        super(repository, modelMapper);
        this.genericRepository = genericRepository;
        this.deliveryRepository = deliveryRepository;
        this.supplierRepository = supplierRepository;
        this.supplierInfoTypeRepository = supplierInfoTypeRepository;
    }

    @Override
    public UnifiedDeliveryDTO save(UnifiedDeliveryDTO dto) {
        // Map DTO to entity
        UnifiedDelivery delivery = modelMapper.map(dto, UnifiedDelivery.class);


        if (dto.getSupplier() != null) {
            Supplier supplier = supplierRepository.findById(dto.getSupplier().getId())
                    .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + dto.getSupplier().getSupplierInfo().getId()));
            delivery.setSupplierType(supplier);
        }

        // Save entity
        UnifiedDelivery savedDelivery = deliveryRepository.saveAndFlush(delivery);

        // Map back to DTO and return
        return modelMapper.map(savedDelivery, UnifiedDeliveryDTO.class);
    }

    @Override
    public UnifiedDeliveryDTO update(UnifiedDeliveryDTO dto) {
        // 1. Load existing entity or fail
        UnifiedDelivery existing = deliveryRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("UnifiedDelivery not found with id: " + dto.getId()));

        modelMapper.map(dto, existing);
        if (dto.getSupplier() != null && dto.getSupplier().getId() != null) {
            Supplier supplier = supplierRepository.findById(dto.getSupplier().getId())
                    .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + dto.getSupplier().getId()));
            existing.setSupplierType(supplier);
        } else {
            existing.setSupplierType(null);
        }

        // 4. Persist changes
        UnifiedDelivery updated = deliveryRepository.saveAndFlush(existing);

        // 5. Map back to DTO and return
        return modelMapper.map(updated, UnifiedDeliveryDTO.class);
    }

}
