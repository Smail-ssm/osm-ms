package com.osm.oilproductionservice.repository;
 import com.osm.oilproductionservice.model.Supplier;
 import org.springframework.data.jpa.repository.JpaRepository;

 import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
 List<Supplier> findSupplierByRegion_Id(Long regionId);
 // Custom queries for Supplier can go here
}