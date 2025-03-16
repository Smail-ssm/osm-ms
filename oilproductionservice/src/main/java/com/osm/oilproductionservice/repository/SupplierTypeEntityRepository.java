package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.domain.customTypes.SupplierType;
import com.osm.oilproductionservice.domain.customTypes.WasteType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierTypeEntityRepository extends JpaRepository<SupplierType, Long> {
    boolean existsByName(String name);
}