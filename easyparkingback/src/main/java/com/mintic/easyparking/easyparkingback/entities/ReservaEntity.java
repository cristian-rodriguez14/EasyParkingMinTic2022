package com.mintic.easyparking.easyparkingback.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "reserva")
public class ReservaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long reservaId;

    @ManyToOne
    @JoinColumn(name = "id_plaza")
    private PlazaEntity idPlaza;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoEntity idEstado;
    
    @Column(nullable = false, length = 10)
    private String placaReserva;
    
    @Column(nullable = false)
    private LocalTime horaReserva;

    @Column(nullable = false)
    private LocalDate fechaReserva;
    
    @Column(nullable = false, length = 50)
    private String creadoPor;        
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReserva")
    private List<VehiculoEntity> vehiculosR = new ArrayList<>();

    public long getReservaId() {
        return reservaId;
    }

    public void setReservaId(long reservaId) {
        this.reservaId = reservaId;
    }

    public PlazaEntity getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(PlazaEntity idPlaza) {
        this.idPlaza = idPlaza;
    }

    public EstadoEntity getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoEntity idEstado) {
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

    public List<VehiculoEntity> getVehiculosR() {
        return vehiculosR;
    }

    public void setVehiculosR(List<VehiculoEntity> vehiculosR) {
        this.vehiculosR = vehiculosR;
    }

   
}
