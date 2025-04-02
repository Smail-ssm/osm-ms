package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.model.MillMachine;
import com.osm.oilproductionservice.model.QualityControlRule;
import com.xdev.xdevbase.repos.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QualityControlRuleRepository extends BaseRepository<QualityControlRule> {

}