package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.domain.Delivery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    Page<Delivery> findByRegionId(Long regionId, Pageable pageable );
}