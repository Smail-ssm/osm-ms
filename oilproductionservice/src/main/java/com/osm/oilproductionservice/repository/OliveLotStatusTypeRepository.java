package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.model.customTypes.OliveLotStatusType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OliveLotStatusTypeRepository extends JpaRepository<OliveLotStatusType, Long> {
    boolean existsByName(String name);
}