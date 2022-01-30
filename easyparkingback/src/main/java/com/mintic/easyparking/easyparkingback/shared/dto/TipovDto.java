package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.util.List;

public class TipovDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private long tipovId;
    private String nombreTipv;
    private String descripcion;
    private List<VehiculoDto> vehiculosTv;

    public long getTipovId() {
        return tipovId;
    }

    public void setTipovId(long tipovId) {
        this.tipovId = tipovId;
    }

    public String getNombreTipv() {
        return nombreTipv;
    }

    public void setNombreTipv(String nombreTipv) {
        this.nombreTipv = nombreTipv;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<VehiculoDto> getVehiculosTv() {
        return vehiculosTv;
    }

    public void setVehiculosTv(List<VehiculoDto> vehiculosTv) {
        this.vehiculosTv = vehiculosTv;
    }
    
    
}
