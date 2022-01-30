package com.mintic.easyparking.easyparkingback.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "trace")
public class TrazabilidadE implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue    
    private long motos;
    private LocalDate fechaMotos;
    private long carros;
    private LocalDate fechaCarros;

//    public long getTraceId() {
//        return traceId;
//    }
//
//    public void setTraceId(long traceId) {
//        this.traceId = traceId;
//    }

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
