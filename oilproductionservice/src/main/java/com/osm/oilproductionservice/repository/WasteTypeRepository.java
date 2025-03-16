package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.domain.Supplier;
import com.osm.oilproductionservice.domain.customTypes.WasteType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteTypeRepository extends JpaRepository<WasteType, Long> {
    boolean existsByName(String name);
}