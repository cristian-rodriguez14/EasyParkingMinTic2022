package com.mintic.easyparking.easyparkingback.repositories;

import com.mintic.easyparking.easyparkingback.entities.AccesoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccesoRepository extends PagingAndSortingRepository<AccesoEntity, Long> {

    @Query(value="SELECT * FROM Usuario u JOIN Tipoi t ON u.id_tipoi=t.tipoi_id JOIN Acceso a ON u.usuario_id=a.id_usuario JOIN Rol r ON r.rol_id=a.id_rol WHERE a.username = :username", nativeQuery=true)
    AccesoEntity findByUsername(@Param("username") String username);

    AccesoEntity findByEstado(String estado);

    AccesoEntity findByDescuento(String descuento);

    AccesoEntity findById(long accesoId);
        
    @Query(value="SELECT * FROM Usuario u JOIN Acceso a ON u.usuario_id=a.id_usuario JOIN Tipoi t ON t.tipoi_id=u.id_tipoi JOIN Rol r ON r.rol_id=a.id_rol ORDER BY a.acceso_id DESC", nativeQuery=true)
    List<AccesoEntity> getDatosUsuarios();

    @Query(value="SELECT * FROM Usuario u JOIN Acceso a ON u.usuario_id=a.id_usuario WHERE u.email = :email", nativeQuery=true)
    AccesoEntity findUsuarioPassword(@Param("email") String email);
    
    public AccesoEntity findByResetPasswordToken(String token);
}
