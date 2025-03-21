package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.model.QualityControlResult;
import com.osm.oilproductionservice.model.QualityControlRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QualityControlResultRepository extends JpaRepository<QualityControlResult, Long> {

}