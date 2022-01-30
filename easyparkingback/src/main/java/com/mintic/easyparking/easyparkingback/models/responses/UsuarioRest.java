package com.mintic.easyparking.easyparkingback.models.responses;

public class UsuarioRest {
    
    private long usuarioId;
    private TidentificacionRest idTipoi;
    private String nombreUsuario;
    private String apellidoUsuario;    
    private String identificacionUsuario;
    private String emailUsuario;
    private Integer telefonoUsuario;

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public TidentificacionRest getIdTipoi() {
        return idTipoi;
    }

    public void setIdTipoi(TidentificacionRest idTipoi) {
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

}
