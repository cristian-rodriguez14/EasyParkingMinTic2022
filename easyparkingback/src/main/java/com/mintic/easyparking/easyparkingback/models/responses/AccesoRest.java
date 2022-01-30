package com.mintic.easyparking.easyparkingback.models.responses;

import java.util.Date;
import java.util.Random;

public class AccesoRest {
    
    private long accesoId;
    private UsuarioRest idUsuario;
    private RolRest idRol;
    private DescuentoRest idDescuento;
    private String username;    
    private boolean estadoAcceso;

    public long getAccesoId() {
        return accesoId;
    }

    public void setAccesoId(long accesoId) {
        this.accesoId = accesoId;
    }

    public UsuarioRest getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioRest idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RolRest getIdRol() {
        return idRol;
    }

    public void setIdRol(RolRest idRol) {
        this.idRol = idRol;
    }

    public DescuentoRest getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(DescuentoRest idDescuento) {
        this.idDescuento = idDescuento;
    }

    public boolean isEstadoAcceso() {
        return estadoAcceso;
    }

    public void setEstadoAcceso(boolean estadoAcceso) {
        this.estadoAcceso = estadoAcceso;
    }

}
