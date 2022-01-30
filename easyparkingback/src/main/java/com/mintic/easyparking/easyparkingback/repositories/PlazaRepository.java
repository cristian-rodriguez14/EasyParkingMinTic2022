package com.mintic.easyparking.easyparkingback.repositories;

import com.mintic.easyparking.easyparkingback.entities.PlazaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlazaRepository extends CrudRepository<PlazaEntity, Long>{
    PlazaEntity findById(long plazaId);
    
    @Query(value="SELECT * FROM Plaza", nativeQuery=true)
    List<PlazaEntity> getPlazas();
}
