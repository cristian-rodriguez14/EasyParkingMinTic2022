package com.mintic.easyparking.easyparkingback.models.responses;

public class PlazaRest {
    
    private long plazaId;
    private ParqueaderoRest idParqueadero;
    private String numeroPlaza;
    private boolean estadoPlaza;

    public long getPlazaId() {
        return plazaId;
    }

    public void setPlazaId(long plazaId) {
        this.plazaId = plazaId;
    }

    public ParqueaderoRest getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(ParqueaderoRest idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public String getNumeroPlaza() {
        return numeroPlaza;
    }

    public void setNumeroPlaza(String numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }

    public boolean isEstadoPlaza() {
        return estadoPlaza;
    }

    public void setEstadoPlaza(boolean estadoPlaza) {
        this.estadoPlaza = estadoPlaza;
    }

}
