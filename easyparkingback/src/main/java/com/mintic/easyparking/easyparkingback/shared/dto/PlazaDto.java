package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.util.List;

public class PlazaDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private long plazaId;
    private ParqueaderoDto idParqueadero;
    private String numeroPlaza;
    private boolean estadoPlaza;
    private List<ReservaDto> reservasP;

    public long getPlazaId() {
        return plazaId;
    }

    public void setPlazaId(long plazaId) {
        this.plazaId = plazaId;
    }

    public ParqueaderoDto getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(ParqueaderoDto idParqueadero) {
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

    public List<ReservaDto> getReservasP() {
        return reservasP;
    }

    public void setReservasP(List<ReservaDto> reservasP) {
        this.reservasP = reservasP;
    }

}
