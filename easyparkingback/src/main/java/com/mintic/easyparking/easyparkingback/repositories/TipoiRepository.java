package com.mintic.easyparking.easyparkingback.repositories;

import com.mintic.easyparking.easyparkingback.entities.TidentificacionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoiRepository extends CrudRepository<TidentificacionEntity, Long> {
    TidentificacionEntity findById(long tipoiId);
    
    @Query(value="SELECT * FROM Tipoi", nativeQuery=true)
    List<TidentificacionEntity> getTiposi();
}
