package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.model.customTypes.BaseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T extends BaseType> extends JpaRepository<T, Long> {
}
