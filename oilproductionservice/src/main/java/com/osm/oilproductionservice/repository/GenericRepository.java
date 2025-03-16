package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.domain.customTypes.BaseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T extends BaseType> extends JpaRepository<T, Long> {
}
