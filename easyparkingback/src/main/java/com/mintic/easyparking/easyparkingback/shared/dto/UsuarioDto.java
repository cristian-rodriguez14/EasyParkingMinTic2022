package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.util.List;

public class UsuarioDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private long usuarioId;
    private TidentificacionDto idTipoi;
    private String nombreUsuario;
    private String apellidoUsuario;    
    private String identificacionUsuario;
    private String emailUsuario;
    private Integer telefonoUsuario;
    private List<AccesoDto> accesosU;

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public TidentificacionDto getIdTipoi() {
        return idTipoi;
    }

    public void setIdTipoi(TidentificacionDto idTipoi) {
        this.idTipoi = idTipoi;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public Integer getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(Integer telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public List<AccesoDto> getAccesosU() {
        return accesosU;
    }

    public void setAccesosU(List<AccesoDto> accesosU) {
        this.accesosU = accesosU;
    }

}
