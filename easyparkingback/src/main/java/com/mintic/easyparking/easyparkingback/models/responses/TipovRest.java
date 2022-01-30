package com.mintic.easyparking.easyparkingback.models.responses;

public class TipovRest {
    
    private long tipovId;
    private String nombreTipv;
    private String descripcion;

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

}
