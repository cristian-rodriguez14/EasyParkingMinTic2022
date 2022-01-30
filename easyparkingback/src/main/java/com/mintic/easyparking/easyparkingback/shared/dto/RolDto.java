package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.util.List;

public class RolDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private long rolId;
    private String nombreRol;
    private List<AccesoDto> accesosR;

    public long getRolId() {
        return rolId;
    }

    public void setRolId(long rolId) {
        this.rolId = rolId;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public List<AccesoDto> getAccesosR() {
        return accesosR;
    }

    public void setAccesosR(List<AccesoDto> accesosR) {
        this.accesosR = accesosR;
    }
    
    
}
