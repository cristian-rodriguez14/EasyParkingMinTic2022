package com.mintic.easyparking.easyparkingback.repositories;

import com.mintic.easyparking.easyparkingback.entities.VehiculoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface VehiculoRepository extends PagingAndSortingRepository<VehiculoEntity, Long> {
    
//    VehiculoEntity findByPlacab(String placab);
    
    VehiculoEntity findById(long vehiculoId);
    
    @Query(value="SELECT * FROM Vehiculo v JOIN Tipov t ON v.id_tipov=t.tipov_id ORDER BY v.vehiculo_id DESC", nativeQuery=true)
    List<VehiculoEntity> getDatosVehiculos();
}
