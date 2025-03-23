package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.constants.TypeCategory;
import com.osm.oilproductionservice.model.BaseType;
import com.xdev.xdevbase.repos.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GenericRepository extends BaseRepository<BaseType> {
    List<BaseType> findAllByType(TypeCategory type);
}
