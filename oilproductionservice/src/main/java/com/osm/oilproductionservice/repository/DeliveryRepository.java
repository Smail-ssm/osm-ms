package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.model.Delivery;
import com.xdev.xdevbase.repos.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryRepository extends BaseRepository<Delivery> {
    @Query(value = """
                SELECT d.*, 
                       (SELECT COALESCE(MAX(lot_number), 0) + 1 FROM delivery) as next_id
                FROM delivery d
            """, nativeQuery = true)
    List<Object[]> findAllWithNextId();

}