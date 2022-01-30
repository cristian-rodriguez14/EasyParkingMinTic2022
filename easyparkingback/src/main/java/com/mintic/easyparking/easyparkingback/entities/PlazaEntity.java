package com.mintic.easyparking.easyparkingback.entities;

import java.io.Serializable;
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

@Entity(name = "plaza")
public class PlazaEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long plazaId;
    
    @ManyToOne
    @JoinColumn(name = "id_parqueadero")
    private ParqueaderoEntity idParqueadero;
    
    @Column(nullable = false, length =5)
    private String numeroPlaza;
    
    @Column(nullable = false)
    private boolean estadoPlaza;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlaza")
    private List<ReservaEntity> reservasP = new ArrayList<>();

    public long getPlazaId() {
        return plazaId;
    }

    public void setPlazaId(long plazaId) {
        this.plazaId = plazaId;
    }

    public ParqueaderoEntity getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(ParqueaderoEntity idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public String getNumeroPlaza() {
        return numeroPlaza;
    }

    public void setNumeroPlaza(String numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }

    public boolean isEstadoPlaza() {
        return estadoPlaza;
    }

    public void setEstadoPlaza(boolean estadoPlaza) {
        this.estadoPlaza = estadoPlaza;
    }

    public List<ReservaEntity> getReservasP() {
        return reservasP;
    }

    public void setReservasP(List<ReservaEntity> reservasP) {
        this.reservasP = reservasP;
    }
    
    
    
}
