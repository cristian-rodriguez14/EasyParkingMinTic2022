package com.mintic.easyparking.easyparkingback.repositories;

import com.mintic.easyparking.easyparkingback.entities.TrazabilidadE;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrazabilidadR extends JpaRepository<TrazabilidadE, Long>{
    
//    @Query(value = "SELECT * FROM (SELECT count(*) AS motos, DATE_FORMAT(f.egreso, '%Y') AS fecha_motos FROM Factura f JOIN Vehiculo v ON f.id_vehiculo=v.vehiculo_id WHERE v.id_tipov=1 AND f.egreso BETWEEN :inicio AND :fin GROUP BY fecha_motos) a JOIN (SELECT count(*) AS carros, DATE_FORMAT(f.egreso, '%Y') AS fecha_carros FROM Factura f JOIN Vehiculo v ON f.id_vehiculo=v.vehiculo_id WHERE v.id_tipov=2 AND f.egreso BETWEEN :inicio AND :fin GROUP BY fecha_carros) b ON a.fecha_motos=b.fecha_carros", nativeQuery = true)
//    List<TrazabilidadE> getConteoAnual(@Param("inicio") LocalDate inicio,@Param("fin") LocalDate fin);
//      
//    @Query(value = "SELECT * FROM (SELECT count(*) AS motos, DATE_FORMAT(f.egreso, '%M %Y') AS fecha_motos FROM Factura f JOIN Vehiculo v ON f.id_vehiculo=v.vehiculo_id WHERE v.id_tipov=1 AND f.egreso BETWEEN :inicio' AND :fin GROUP BY fecha_motos) a JOIN (SELECT count(*) AS carros, DATE_FORMAT(f.egreso, '%M %Y') AS fecha_carros FROM Factura f JOIN Vehiculo v ON f.id_vehiculo=v.vehiculo_id WHERE v.id_tipov=2 AND f.egreso BETWEEN :inicio AND :fin GROUP BY fecha_carros) b ON a.fecha_motos=b.fecha_carros", nativeQuery = true)
//    List<TrazabilidadE> getConteoMensual(@Param("inicio") LocalDate inicio,@Param("fin") LocalDate fin);
    
}
