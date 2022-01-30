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

@Entity(name = "tipov")
public class TipovEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long tipovId;

    @Column(nullable = false, length = 10)
    private String nombreTipo;
 
    @Column(nullable = true, length = 60)
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipov")
    private List<VehiculoEntity> vehiculosTv = new ArrayList<>();

    public Long getTipovId() {
        return tipovId;
    }

    public void setTipovId(Long tipovId) {
        this.tipovId = tipovId;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<VehiculoEntity> getVehiculosTv() {
        return vehiculosTv;
    }

    public void setVehiculosTv(List<VehiculoEntity> vehiculosTv) {
        this.vehiculosTv = vehiculosTv;
    }

    
}
