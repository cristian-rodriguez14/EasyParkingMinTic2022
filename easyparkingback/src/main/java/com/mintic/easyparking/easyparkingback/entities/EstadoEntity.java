package com.mintic.easyparking.easyparkingback.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "estador")
public class EstadoEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long estadoId;
    
    @Column(nullable = false, length = 20)
    private String estadoReserva;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<ReservaEntity> reservasE = new ArrayList<>();

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

    public List<ReservaEntity> getReservasE() {
        return reservasE;
    }

    public void setReservasE(List<ReservaEntity> reservasE) {
        this.reservasE = reservasE;
    }
    
    
}
