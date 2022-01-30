package com.mintic.easyparking.easyparkingback.services;

import com.mintic.easyparking.easyparkingback.entities.AccesoEntity;
import com.mintic.easyparking.easyparkingback.shared.dto.AccesoCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.AccesoDto;
import com.mintic.easyparking.easyparkingback.shared.dto.RolDto;
import com.mintic.easyparking.easyparkingback.shared.dto.TidentificacionDto;
import com.mintic.easyparking.easyparkingback.shared.dto.UsuarioCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.UsuarioDto;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioServiceInterface extends UserDetailsService{
    
    public UsuarioDto createUsuario(UsuarioCreationDto usuario);
    
    public AccesoDto createAccesoCliente(AccesoCreationDto acceso);
    
    public AccesoDto createAccesoEmployee(AccesoCreationDto acceso);
    
    public List<AccesoDto> getAllUsuarios();
    
//    public List<FullusuarioDto> getAllUsuarios();
    
    public AccesoDto getUsuarioLog(String username);    
    
    public void getIdLastUsuario(long id);
    
    public List<RolDto> getAllRoles();
    
    public List<TidentificacionDto> getAllTiposi(); 
    
    public UsuarioDto updateUsuario(long usuarioId, long tipoiId, UsuarioCreationDto usuarioUpdateDto);
    
    public AccesoDto deleteEmpleado(long accesoId);
    
    public AccesoDto changePassword(long accesoId, AccesoCreationDto accesoUpdateDto);
    
//    public void createPasswordResetTokenForUser(UsuarioDto usuarioDto, String token, String email);
    
    public AccesoDto makeSuscription(long accesoId, AccesoCreationDto accesoUpdateDto);
    
    public AccesoDto inicializarVariables(long accesoId, AccesoCreationDto accesoUpdateDto);
    
    public UsuarioDto getUsuarioData(String email);
    
    public AccesoDto getAccesoUsuario(String email);
    
    public void updateResetPasswordToken(String token, String email);
    
    public AccesoDto updatePassword(String token, AccesoCreationDto accesoUpdateDto);
}
