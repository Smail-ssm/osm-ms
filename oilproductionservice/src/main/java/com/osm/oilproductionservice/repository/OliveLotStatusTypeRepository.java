package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.domain.customTypes.OliveLotStatusType;
import com.osm.oilproductionservice.domain.customTypes.SupplierType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OliveLotStatusTypeRepository extends JpaRepository<OliveLotStatusType, Long> {
    boolean existsByName(String name);
}