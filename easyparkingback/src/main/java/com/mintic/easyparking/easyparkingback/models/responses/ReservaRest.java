package com.mintic.easyparking.easyparkingback.models.responses;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaRest {
    
    private long reservaId;
    private PlazaRest idPlaza;
    private EstadoRest idEstado;
    private String placaReserva;
    private LocalTime horaReserva;
    private LocalDate fechaReserva;
    private String creadoPor;    

    public long getReservaId() {
        return reservaId;
    }

    public void setReservaId(long reservaId) {
        this.reservaId = reservaId;
    }

    public PlazaRest getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(PlazaRest idPlaza) {
        this.idPlaza = idPlaza;
    }

    public EstadoRest getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoRest idEstado) {
        this.idEstado = idEstado;
    }

    public String getPlacaReserva() {
        return placaReserva;
    }

    public void setPlacaReserva(String placaReserva) {
        this.placaReserva = placaReserva;
    }

    public LocalTime getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(LocalTime horaReserva) {
        this.horaReserva = horaReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

}
