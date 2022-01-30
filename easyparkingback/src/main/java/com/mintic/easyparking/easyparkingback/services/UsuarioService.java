package com.mintic.easyparking.easyparkingback.services;

import com.mintic.easyparking.easyparkingback.repositories.AccesoRepository;
import com.mintic.easyparking.easyparkingback.repositories.UsuarioRepository;
import com.mintic.easyparking.easyparkingback.repositories.RolRepository;
import com.mintic.easyparking.easyparkingback.repositories.TipoiRepository;

import com.mintic.easyparking.easyparkingback.entities.AccesoEntity;
import com.mintic.easyparking.easyparkingback.entities.RolEntity;
import com.mintic.easyparking.easyparkingback.entities.TidentificacionEntity;
import com.mintic.easyparking.easyparkingback.entities.UsuarioEntity;

import com.mintic.easyparking.easyparkingback.exceptions.EmailExistsException;

import com.mintic.easyparking.easyparkingback.shared.dto.AccesoCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.AccesoDto;
import com.mintic.easyparking.easyparkingback.shared.dto.RolDto;
import com.mintic.easyparking.easyparkingback.shared.dto.TidentificacionDto;
import com.mintic.easyparking.easyparkingback.shared.dto.UsuarioCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.UsuarioDto;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UsuarioServiceInterface {

    private String[] primeraLetraNombre;
    private String[] primerApellido;
    private long ultimoUsuarioCreado;
    private AccesoEntity resetP;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AccesoRepository accesoRepository;

    @Autowired
    TipoiRepository tipoiRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    ModelMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccesoEntity accesoEntity = accesoRepository.findByUsername(username);

        if (accesoEntity == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(accesoEntity.getUsername(), accesoEntity.getEncryptedPassword(), new ArrayList<>());

    }

    @Override
    public UsuarioDto createUsuario(UsuarioCreationDto usuario) {
        
        if (usuarioRepository.findByEmail(usuario.getEmailUsuario()) != null) {
            throw new EmailExistsException("El email ya existe");
        }
        TidentificacionEntity tipoiEntity = tipoiRepository.findById(usuario.getIdTipoi());

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNombreUsuario(usuario.getNombreUsuario());
        primeraLetraNombre = usuario.getNombreUsuario().split("");
        usuarioEntity.setApellidoUsuario(usuario.getApellidoUsuario());
        primerApellido = usuario.getApellidoUsuario().split(" ");
        usuarioEntity.setIdTipoi(tipoiEntity);
        usuarioEntity.setIdentificacionUsuario(usuario.getIdentificacionUsuario());
        usuarioEntity.setEmailUsuario(usuario.getEmailUsuario());
        usuarioEntity.setTelefonoUsuario(usuario.getTelefonoUsuario());
        UsuarioEntity createdUsuario = usuarioRepository.save(usuarioEntity);
        UsuarioDto usuarioToReturn = mapper.map(createdUsuario, UsuarioDto.class);
        return usuarioToReturn;
    }

    @Override
    public AccesoDto createAccesoCliente(AccesoCreationDto acceso) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1000);
        acceso.setPassword(primeraLetraNombre[0] + primerApellido[0] + numeroAleatorio);

        RolEntity rolEntity = rolRepository.findById(3);
        UsuarioEntity usuarioEntity = usuarioRepository.findById(ultimoUsuarioCreado);

        AccesoEntity accesoEntity = new AccesoEntity();
        accesoEntity.setIdUsuario(usuarioEntity);
        accesoEntity.setUsername(primeraLetraNombre[0] + primerApellido[0] + numeroAleatorio);
        accesoEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(acceso.getPassword()));
        accesoEntity.setIdRol(rolEntity);
        accesoEntity.setEstadoAcceso(true);
        AccesoEntity createdAcceso = accesoRepository.save(accesoEntity);
        AccesoDto accesoToReturn = mapper.map(createdAcceso, AccesoDto.class);

        return accesoToReturn;
    }

    @Override
    public AccesoDto createAccesoEmployee(AccesoCreationDto acceso) {

        Random random = new Random();
        int numeroAleatorio = random.nextInt(1000);
        acceso.setPassword(primeraLetraNombre[0] + primerApellido[0] + numeroAleatorio);

        RolEntity rolEntity = rolRepository.findById(2);
        UsuarioEntity usuarioEntity = usuarioRepository.findById(ultimoUsuarioCreado);

        AccesoEntity accesoEntity = new AccesoEntity();
        accesoEntity.setIdUsuario(usuarioEntity);
        accesoEntity.setUsername(primeraLetraNombre[0] + primerApellido[0] + numeroAleatorio);
        accesoEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(acceso.getPassword()));
        accesoEntity.setIdRol(rolEntity);
        accesoEntity.setEstadoAcceso(true);

        AccesoEntity createdAcceso = accesoRepository.save(accesoEntity);

        AccesoDto accesoToReturn = mapper.map(createdAcceso, AccesoDto.class);

        return accesoToReturn;
    }

    @Override
    public List<AccesoDto> getAllUsuarios() {
        
        List<AccesoEntity> accesoEntities = accesoRepository.getDatosUsuarios();
        
        List<AccesoDto> accesoDtos = new ArrayList<>();
        
        for(AccesoEntity acceso: accesoEntities){
            AccesoDto accesoDto = mapper.map(acceso, AccesoDto.class);
            accesoDtos.add(accesoDto);
        }
        return accesoDtos;
    }

    @Override
    public AccesoDto getUsuarioLog(String username) {

        AccesoEntity accesoEntity = accesoRepository.findByUsername(username);
        AccesoDto accesoToReturn = mapper.map(accesoEntity, AccesoDto.class);
        return accesoToReturn;

    }

    @Override
    public void getIdLastUsuario(long id) {
        ultimoUsuarioCreado = id;
    }

    @Override
    public List<RolDto> getAllRoles() {
        List<RolEntity> rolEntities = rolRepository.getRoles();

        List<RolDto> rolDtos = new ArrayList<>();

        for (RolEntity rol : rolEntities) {
            RolDto rolDto = mapper.map(rol, RolDto.class);
            rolDtos.add(rolDto);
        }
        return rolDtos;
    }

    @Override
    public List<TidentificacionDto> getAllTiposi() {
        List<TidentificacionEntity> tipoiEntities = tipoiRepository.getTiposi();

        List<TidentificacionDto> tipoiDtos = new ArrayList<>();

        for (TidentificacionEntity tipoi : tipoiEntities) {
            TidentificacionDto tipoiDto = mapper.map(tipoi, TidentificacionDto.class);
            tipoiDtos.add(tipoiDto);
        }
        return tipoiDtos;
    }

    @Override
    public UsuarioDto updateUsuario(long usuarioId, long tipoiId, UsuarioCreationDto usuarioUpdateDto) {

        UsuarioEntity usuarioEntity = usuarioRepository.findById(usuarioId);
        if (usuarioEntity.getIdTipoi().getTipoiId() != tipoiId) {
            throw new RuntimeException("No se puede realizar esta accion");
        }

        usuarioEntity.setNombreUsuario(usuarioUpdateDto.getNombreUsuario());
        usuarioEntity.setApellidoUsuario(usuarioUpdateDto.getApellidoUsuario());
        usuarioEntity.setEmailUsuario(usuarioUpdateDto.getEmailUsuario());
        usuarioEntity.setTelefonoUsuario(usuarioUpdateDto.getTelefonoUsuario());

        UsuarioEntity updatedUsuario = usuarioRepository.save(usuarioEntity);

        UsuarioDto usuarioDto = mapper.map(updatedUsuario, UsuarioDto.class);

        return usuarioDto;
    }

    @Override
    public AccesoDto deleteEmpleado(long accesoId) {
        AccesoEntity accesoEntity = accesoRepository.findById(accesoId);
        
        accesoEntity.setEstadoAcceso(false);

        AccesoEntity updatedAcceso = accesoRepository.save(accesoEntity);

        AccesoDto accesoDto = mapper.map(updatedAcceso, AccesoDto.class);

        return accesoDto;
    }

    @Override
    public AccesoDto changePassword(long accesoId, AccesoCreationDto accesoUpdateDto) {
        AccesoEntity accesoEntity = accesoRepository.findById(accesoId);

        accesoUpdateDto.setPassword(accesoUpdateDto.getPassword());
        accesoEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(accesoUpdateDto.getPassword()));

        AccesoEntity updatedAcceso = accesoRepository.save(accesoEntity);

        AccesoDto accesoDto = mapper.map(updatedAcceso, AccesoDto.class);

        return accesoDto;
    }
 
    @Override
    public AccesoDto makeSuscription(long accesoId, AccesoCreationDto accesoUpdateDto) {
        
        AccesoEntity accesoEntity = accesoRepository.findById(accesoId);

//        accesoEntity.setDescuento(true);
//        accesoEntity.setExpira(accesoUpdateDto.getExpira());
//        accesoEntity.setExpira(new Date(System.currentTimeMillis() + (accesoUpdateDto.getTiempoExpiracion() * 60000)));
//        System.out.println("4.1: "+accesoEntity.isDescuento()+"\n4.2: "+accesoEntity.getExpira());
        
        AccesoEntity updatedAcceso = accesoRepository.save(accesoEntity);
        
        AccesoDto accesoDto = mapper.map(updatedAcceso, AccesoDto.class);

        return accesoDto;
    }

    @Override
    public AccesoDto inicializarVariables(long accesoId, AccesoCreationDto accesoUpdateDto) {
        AccesoEntity accesoEntity = accesoRepository.findById(accesoId);

//        accesoEntity.setDescuento(false);
//        accesoEntity.setExpira(null);

        AccesoEntity updatedAcceso = accesoRepository.save(accesoEntity);

        AccesoDto accesoDto = mapper.map(updatedAcceso, AccesoDto.class);

        return accesoDto;
    }

    @Override
    public UsuarioDto getUsuarioData(String email) {
        UsuarioEntity usuarioEntity = usuarioRepository.findByEmail(email);

        if (usuarioEntity == null) {
            throw new UsernameNotFoundException(email);
        }

        UsuarioDto usuarioToReturn = new UsuarioDto();

        BeanUtils.copyProperties(usuarioEntity, usuarioToReturn);

        return usuarioToReturn;
    }
    
    @Override
    public AccesoDto getAccesoUsuario(String email){
        AccesoEntity accesoEntity = accesoRepository.findUsuarioPassword(email);

        if (accesoEntity == null) {
            throw new UsernameNotFoundException(email);
        }

        AccesoDto usuarioToReturn = mapper.map(accesoEntity, AccesoDto.class);
        return usuarioToReturn;
    }

    @Override
    public void updateResetPasswordToken(String token, String email) throws UsernameNotFoundException {
        AccesoEntity accesoEntity = accesoRepository.findUsuarioPassword(email);
        if (accesoEntity != null) {
            accesoEntity.setResetPasswordToken(token);
            accesoRepository.save(accesoEntity);
        } else {
            throw new UsernameNotFoundException("No se pudo encontrar el usuario con ese email " + email);
        }
    }

    @Override
    public AccesoDto updatePassword(String token, AccesoCreationDto accesoUpdateDto) {
        System.out.println("Usted no esta aqui");
        AccesoEntity accesoEntity = accesoRepository.findByResetPasswordToken(token);
        
        accesoUpdateDto.setPassword(accesoUpdateDto.getPassword());
        accesoEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(accesoUpdateDto.getPassword()));

        accesoEntity.setResetPasswordToken(null);
        AccesoEntity updatedAcceso = accesoRepository.save(accesoEntity);
        AccesoDto accesoDto = mapper.map(updatedAcceso, AccesoDto.class);

        return accesoDto;
    }
}
