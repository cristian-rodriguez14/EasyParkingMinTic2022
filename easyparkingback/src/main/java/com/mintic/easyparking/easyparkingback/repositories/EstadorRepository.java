package com.mintic.easyparking.easyparkingback.repositories;

import com.mintic.easyparking.easyparkingback.entities.EstadoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadorRepository extends CrudRepository<EstadoEntity, Long> {
    EstadoEntity findById(long estadorId);

    @Query(value="SELECT * FROM Estador", nativeQuery=true)
    List<EstadoEntity> getEstadosr();
}
