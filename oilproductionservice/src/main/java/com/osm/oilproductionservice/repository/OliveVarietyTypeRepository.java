package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.domain.customTypes.OliveLotStatusType;
import com.osm.oilproductionservice.domain.customTypes.OliveVarietyType;
import org.springframework.data.jpa.repository.JpaRepository;

     public interface OliveVarietyTypeRepository extends JpaRepository<OliveVarietyType, Long> {
         boolean existsByName(String name);

    }
