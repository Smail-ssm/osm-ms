package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.model.customTypes.SupplierType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierTypeEntityRepository extends JpaRepository<SupplierType, Long> {
    boolean existsByName(String name);
}