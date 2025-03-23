package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.model.BaseType;
import com.osm.oilproductionservice.model.Delivery;
import com.xdev.xdevbase.repos.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryRepository extends BaseRepository<Delivery> {

 }