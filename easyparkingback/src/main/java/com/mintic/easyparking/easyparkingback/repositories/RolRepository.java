package com.mintic.easyparking.easyparkingback.repositories;

import com.mintic.easyparking.easyparkingback.entities.RolEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository<RolEntity, Long> {
    RolEntity findById(long rolId);
    
    @Query(value="SELECT * FROM Rol", nativeQuery=true)
    List<RolEntity> getRoles();

}
