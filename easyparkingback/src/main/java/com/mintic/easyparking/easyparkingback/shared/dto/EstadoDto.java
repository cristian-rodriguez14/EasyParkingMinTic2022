package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.util.List;

public class EstadoDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private long estadoId;
    private String estadoReserva;
    private List<ReservaDto> reservasE;

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
    
    public List<ReservaDto> getReservasE() {
        return reservasE;
    }

    public void setReservasE(List<ReservaDto> reservasE) {
        this.reservasE = reservasE;
    }   
}
