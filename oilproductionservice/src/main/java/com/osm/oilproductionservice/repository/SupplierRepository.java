package com.osm.oilproductionservice.repository;
 import com.osm.oilproductionservice.model.Supplier;
 import com.osm.oilproductionservice.test.test;
 import com.xdev.xdevbase.repos.BaseRepository;
 import org.springframework.data.jpa.repository.JpaRepository;

 import java.util.List;

public interface SupplierRepository extends BaseRepository<Supplier > {
}