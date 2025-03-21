package com.osm.oilproductionservice.service;

import com.osm.oilproductionservice.dto.QualityControlResultDto;
import com.osm.oilproductionservice.model.Delivery;
import com.osm.oilproductionservice.dto.DeliveryDto;
import com.osm.oilproductionservice.model.QualityControlResult;
import com.osm.oilproductionservice.repository.DeliveryRepository;
import com.osm.oilproductionservice.repository.QualityControlResultRepository;
import com.osm.oilproductionservice.repository.QualityControlRuleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final ModelMapper modelMapper;
    private final QualityControlResultRepository qualityControlResultRepository;

    public DeliveryService(DeliveryRepository deliveryRepository, ModelMapper modelMapper, QualityControlResultRepository qualityControlResultRepository) {
        this.deliveryRepository = deliveryRepository;
        this.modelMapper = modelMapper;
        this.qualityControlResultRepository = qualityControlResultRepository;
    }

    /**
     * Create a new delivery.
     */
    public DeliveryDto createDelivery(DeliveryDto deliveryDto) {
        Delivery delivery = modelMapper.map(deliveryDto, Delivery.class);
        Delivery savedDelivery = deliveryRepository.save(delivery);

        // Map new QC Results from DTO if provided
        if (deliveryDto.getQualityControlResults() != null) {

            Set<QualityControlResult> results = deliveryDto.getQualityControlResults().stream().map(item -> {
                QualityControlResult res = modelMapper.map(item, QualityControlResult.class);
                res.setDelivery(savedDelivery);
                return res;
            }).collect(Collectors.toSet());
            qualityControlResultRepository.saveAll(results);
        }
        return modelMapper.map(savedDelivery, DeliveryDto.class);
    }

    /**
     * Update an existing delivery.
     */
    public DeliveryDto updateDelivery(Long id, DeliveryDto deliveryDto) {

        return deliveryRepository.findById(id).map(existingDelivery -> {
            // Map basic DTO fields to the existing entity
            modelMapper.map(deliveryDto, existingDelivery);

            // Clear existing QualityControlResults if present
            existingDelivery.getQualityControlResults().clear();

            // Map new QC Results from DTO if provided
            if (deliveryDto.getQualityControlResults() != null) {

                Set<QualityControlResult> results = deliveryDto.getQualityControlResults().stream().map(item -> {
                    QualityControlResult res = modelMapper.map(item, QualityControlResult.class);
                    res.setDelivery(existingDelivery);
                    return res;
                }).collect(Collectors.toSet());
                qualityControlResultRepository.saveAll(results);
            }


            // Save and return updated entity mapped to DTO
            Delivery updatedDelivery = deliveryRepository.save(existingDelivery);
            return modelMapper.map(updatedDelivery, DeliveryDto.class);
        }).orElse(null);
    }


    /**
     * Get a delivery by ID.
     */
    public DeliveryDto getDelivery(Long id) {
        return deliveryRepository.findById(id).map(delivery -> modelMapper.map(delivery, DeliveryDto.class)).orElse(null);
    }

    /**
     * Get all deliveries with pagination.
     */
    public Page<DeliveryDto> getAllDeliveries(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Delivery> deliveryPage = deliveryRepository.findAll(pageable);

        // Convert the Page<Delivery> to Page<DeliveryDto>
        return deliveryPage.map(delivery -> modelMapper.map(delivery, DeliveryDto.class));
    }

    /**
     * Get deliveries by region ID with pagination.
     */
    public Page<DeliveryDto> getDeliveriesByRegion(Long regionId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Delivery> deliveryPage = deliveryRepository.findByRegionId(regionId, pageable);

        // Convert the Page<Delivery> to Page<DeliveryDto>
        return deliveryPage.map(delivery -> modelMapper.map(delivery, DeliveryDto.class));
    }

    /**
     * Delete a delivery by ID.
     */
    public boolean deleteDelivery(Long id) {
        if (deliveryRepository.existsById(id)) {
            deliveryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}