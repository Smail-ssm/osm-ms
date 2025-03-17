package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.domain.customTypes.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    boolean existsByName(String name);
}
