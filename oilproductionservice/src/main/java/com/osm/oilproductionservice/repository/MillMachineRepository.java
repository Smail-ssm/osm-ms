package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.constants.TypeCategory;
import com.osm.oilproductionservice.model.BaseType;
import com.osm.oilproductionservice.model.MillMachine;
import com.xdev.xdevbase.repos.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MillMachineRepository extends BaseRepository<MillMachine> {
 }
