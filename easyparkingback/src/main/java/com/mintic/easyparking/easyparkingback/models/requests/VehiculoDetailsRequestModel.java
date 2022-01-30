package com.mintic.easyparking.easyparkingback.models.requests;

import java.time.LocalDateTime;

public class VehiculoDetailsRequestModel {
    
    private Integer idTipov;
    private boolean reservo;    
    private Integer idReserva;
    private String placab;
    private Integer plazav;
    private LocalDateTime ingreso;

    public Integer getIdTipov() {
        return idTipov;
    }

    public void setIdTipov(Integer idTipov) {
        this.idTipov = idTipov;
    }

    public boolean getReservo() {
        return reservo;
    }

    public void setReservo(boolean reservo) {
        this.reservo = reservo;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public String getPlacab() {
        return placab;
    }

    public void setPlacab(String placab) {
        this.placab = placab;
    }

    public Integer getPlazav() {
        return plazav;
    }

    public void setPlazav(Integer plazav) {
        this.plazav = plazav;
    }

    public LocalDateTime getIngreso() {
        return ingreso;
    }

    public void setIngreso(LocalDateTime ingreso) {
        this.ingreso = ingreso;
    }        
}
