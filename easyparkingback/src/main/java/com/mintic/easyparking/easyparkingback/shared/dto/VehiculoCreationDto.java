package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class VehiculoCreationDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private long idTipov;
    private long idReserva;
    private long plazaVehiculo;
    private String placaVehiculo;
    private boolean reservoPlaza;    
    private LocalDateTime ingresoVeh;
    private boolean utilizando;

    public long getIdTipov() {
        return idTipov;
    }

    public void setIdTipov(long idTipov) {
        this.idTipov = idTipov;
    }

    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }

    public long getPlazaVehiculo() {
        return plazaVehiculo;
    }

    public void setPlazaVehiculo(long plazaVehiculo) {
        this.plazaVehiculo = plazaVehiculo;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public boolean isReservoPlaza() {
        return reservoPlaza;
    }

    public void setReservoPlaza(boolean reservoPlaza) {
        this.reservoPlaza = reservoPlaza;
    }

    public LocalDateTime getIngresoVeh() {
        return ingresoVeh;
    }

    public void setIngresoVeh(LocalDateTime ingresoVeh) {
        this.ingresoVeh = ingresoVeh;
    }

    public boolean isUtilizando() {
        return utilizando;
    }

    public void setUtilizando(boolean utilizando) {
        this.utilizando = utilizando;
    }
    
}
