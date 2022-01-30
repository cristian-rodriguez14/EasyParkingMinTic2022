package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaCreationDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private long idPlaza;
    private long idEstado;
    private String placaReserva;    
    private LocalTime horaReserva;
    private LocalDate fechaReserva;   
    private String creadoPor;

    public long getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(long idPlaza) {
        this.idPlaza = idPlaza;
    }

    public long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(long idEstado) {
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
