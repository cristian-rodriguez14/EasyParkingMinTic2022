package com.mintic.easyparking.easyparkingback.repositories;

import com.mintic.easyparking.easyparkingback.entities.FacturaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends PagingAndSortingRepository<FacturaEntity, Long> {

    FacturaEntity findById(long facturaId);

    @Query(value = "SELECT * FROM Factura f JOIN Vehiculo v ON f.id_vehiculo=v.vehiculo_id JOIN Acceso a ON a.acceso_id=f.id_acceso ORDER BY f.factura_id DESC", nativeQuery = true)
    List<FacturaEntity> getDatosFacturas();
    
}
