package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.model.customTypes.OliveVariety;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VarietyRepository extends JpaRepository<OliveVariety, Long> {
    boolean existsByName(String name);
}
