package com.mintic.easyparking.easyparkingback.repositories;

import com.mintic.easyparking.easyparkingback.entities.ReservaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends PagingAndSortingRepository<ReservaEntity, Long> {
    
    ReservaEntity findById(long reservaId);
    
    @Query(value="SELECT * FROM Reserva r JOIN Plaza p ON r.id_plaza=p.plaza_id JOIN Estador e ON e.estador_id=r.id_estador ORDER BY r.reserva_id DESC", nativeQuery=true)
    List<ReservaEntity> getDatosReservas();
    
    @Query(value="SELECT * FROM Reserva r JOIN Estador e ON e.estador_id=r.id_estador JOIN Plaza p ON r.id_plaza=p.plaza_id WHERE r.creado_por = :username ORDER BY r.reserva_id DESC", nativeQuery=true)
    List<ReservaEntity> getDatosReservaByUsuario(@Param("username") String username);
    
//    ReservaEntity findByPlacaa(String placaa);
    
    //ReservaEntity findByUsername(String creadoPor);
}
