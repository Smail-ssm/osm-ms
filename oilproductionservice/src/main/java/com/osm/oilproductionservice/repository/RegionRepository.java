package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
