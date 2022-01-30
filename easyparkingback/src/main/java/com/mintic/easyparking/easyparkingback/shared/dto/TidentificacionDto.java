package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.util.List;

public class TidentificacionDto implements Serializable {
        
    private static final long serialVersionUID = 1L;
    
    private long tipoiId;
    private String tipoNombre;
    private String acronimo;
    private List<UsuarioDto> usuariosTi;

    public long getTipoiId() {
        return tipoiId;
    }

    public void setTipoiId(long tipoiId) {
        this.tipoiId = tipoiId;
    }

    public String getTipoNombre() {
        return tipoNombre;
    }

    public void setTipoNombre(String tipoNombre) {
        this.tipoNombre = tipoNombre;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public List<UsuarioDto> getUsuariosTi() {
        return usuariosTi;
    }

    public void setUsuariosTi(List<UsuarioDto> usuariosTi) {
        this.usuariosTi = usuariosTi;
    }

    
}
