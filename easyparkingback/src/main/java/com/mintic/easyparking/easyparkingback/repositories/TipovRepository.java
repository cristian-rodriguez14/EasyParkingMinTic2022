package com.mintic.easyparking.easyparkingback.repositories;

import com.mintic.easyparking.easyparkingback.entities.TipovEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipovRepository extends CrudRepository<TipovEntity, Long> {
    TipovEntity findById(long tipovId);
    
    @Query(value="SELECT * FROM Tipov", nativeQuery=true)
    List<TipovEntity> getTiposv();
}
