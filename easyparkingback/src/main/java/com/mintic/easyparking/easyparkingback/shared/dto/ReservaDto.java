package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private long reservaId;
    private PlazaDto idPlaza;
    private EstadoDto idEstado;
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

    public PlazaDto getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(PlazaDto idPlaza) {
        this.idPlaza = idPlaza;
    }

    public EstadoDto getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoDto idEstado) {
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
