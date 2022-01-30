package com.mintic.easyparking.easyparkingback.models.responses;


public class EstadoRest {
    
    private long estadoId;
    private String estadoReserva;

    public long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(long estadoId) {
        this.estadoId = estadoId;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

}
