package com.osm.oilproductionservice.repository;

import com.osm.oilproductionservice.model.MillMachine;
import com.osm.oilproductionservice.model.UnifiedDelivery;
import com.xdev.xdevbase.repos.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.ScopedValue;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface DeliveryRepository extends BaseRepository<UnifiedDelivery> {


    /* ── OPTIONAL HELPERS (if you still use them elsewhere) ───── */
    @Query("select coalesce(d.oliveQuantity, 0) from UnifiedDelivery d where d.id = :id")
    double weightOfLot(@Param("id") String id);

    List<UnifiedDelivery> findByIdIn(Set<UUID> ids);
    List<UnifiedDelivery> findByLotNumberIn(Set<String> lotNumbers);
     List<UnifiedDelivery> findByGlobalLotNumber(String globalLotNumber);
    List<UnifiedDelivery> findByMillMachineId(UUID mill);

    List<UnifiedDelivery> findByMillMachineIsNotNull();
}