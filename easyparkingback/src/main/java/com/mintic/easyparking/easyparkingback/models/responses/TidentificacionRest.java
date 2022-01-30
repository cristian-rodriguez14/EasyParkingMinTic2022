package com.mintic.easyparking.easyparkingback.models.responses;

public class TidentificacionRest {
    
    private int tipoiId;
    private String tipoNombre;
    private String acronimo;

    public int getTipoiId() {
        return tipoiId;
    }

    public void setTipoiId(int tipoiId) {
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

}
