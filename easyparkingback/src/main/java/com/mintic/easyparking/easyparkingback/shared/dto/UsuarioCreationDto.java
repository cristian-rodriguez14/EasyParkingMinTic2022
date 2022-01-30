package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;

public class UsuarioCreationDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String nombreUsuario;
    private String apellidoUsuario;
    private long idTipoi;
    private String identificacionUsuario;
    private String emailUsuario;
    private Integer telefonoUsuario;

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

    public long getIdTipoi() {
        return idTipoi;
    }

    public void setIdTipoi(long idTipoi) {
        this.idTipoi = idTipoi;
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
    
}
