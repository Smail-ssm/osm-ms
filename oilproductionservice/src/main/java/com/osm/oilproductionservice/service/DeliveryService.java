package com.osm.oilproductionservice.service;


import com.osm.oilproductionservice.domain.Delivery;
import com.osm.oilproductionservice.repository.DeliveryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Delivery updateDelivery(Long id, Delivery delivery) {
        return deliveryRepository.findById(id)
                .map(existingDelivery -> {
                    existingDelivery.setReceiptNumber(delivery.getReceiptNumber());
                    existingDelivery.setLotNumber(delivery.getLotNumber());
                    existingDelivery.setDeliveryDate(delivery.getDeliveryDate());
                    existingDelivery.setStatus(delivery.getStatus());
                    existingDelivery.setGlobalLotNumber(delivery.getGlobalLotNumber());
                    existingDelivery.setOliveQuantity(delivery.getOliveQuantity());
                    existingDelivery.setRegion(delivery.getRegion());
                    existingDelivery.setVariety(delivery.getVariety());
                    existingDelivery.setStorageUnit(delivery.getStorageUnit());
                    existingDelivery.setSupplier(delivery.getSupplier());
                    existingDelivery.setQualityControlResult(delivery.getQualityControlResult());
                    return deliveryRepository.save(existingDelivery);
                })
                .orElse(null);
    }

    public Delivery getDelivery(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    public Page<Delivery> getAllDeliveries(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return deliveryRepository.findAll(pageable);
    }

    public Page<Delivery> getDeliveriesByRegion(Long regionId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return deliveryRepository.findByRegionId(regionId, pageable);
    }

    public boolean deleteDelivery(Long id) {
        if (deliveryRepository.existsById(id)) {
            deliveryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

