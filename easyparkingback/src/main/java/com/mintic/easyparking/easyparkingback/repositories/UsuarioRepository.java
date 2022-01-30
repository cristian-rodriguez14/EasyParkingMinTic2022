package com.mintic.easyparking.easyparkingback.repositories;

import com.mintic.easyparking.easyparkingback.entities.UsuarioEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioEntity, Long> {

    UsuarioEntity findByEmail(String email);    
     
    UsuarioEntity findById(long usuarioId);
    
}
