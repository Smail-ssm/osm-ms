package com.osm.oilproductionservice.repository;
 import com.osm.oilproductionservice.domain.Supplier;
 import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    // Custom queries for Supplier can go here
}