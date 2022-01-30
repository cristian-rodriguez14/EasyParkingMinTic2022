package com.mintic.easyparking.easyparkingback.models.responses;

import java.time.LocalDate;


public class TrazabilidadModel {
    
    private long motos;
    private LocalDate fechaMotos;
    private long carros;
    private LocalDate fechaCarros;

    public long getMotos() {
        return motos;
    }

    public void setMotos(long motos) {
        this.motos = motos;
    }

    public LocalDate getFechaMotos() {
        return fechaMotos;
    }

    public void setFechaMotos(LocalDate fechaMotos) {
        this.fechaMotos = fechaMotos;
    }

    public long getCarros() {
        return carros;
    }

    public void setCarros(long carros) {
        this.carros = carros;
    }

    public LocalDate getFechaCarros() {
        return fechaCarros;
    }

    public void setFechaCarros(LocalDate fechaCarros) {
        this.fechaCarros = fechaCarros;
    }

}
