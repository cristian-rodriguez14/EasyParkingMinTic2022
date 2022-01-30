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

@Entity(name = "parqueadero")
public class ParqueaderoEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long parqueaderoId;
    
    @Column(nullable = false, length = 50)
    private String nombrePar;
    
    @Column(nullable = false, length = 50)
    private String direccionPar;
    
    @Column(nullable = false)
    private Integer cantidadPlazas;
    
    @Column(nullable = false, length = 30)
    private String nombreAdmin;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParqueadero")
    private List<PlazaEntity> plazasP = new ArrayList<>();

    public Long getParqueaderoId() {
        return parqueaderoId;
    }

    public void setParqueaderoId(Long parqueaderoId) {
        this.parqueaderoId = parqueaderoId;
    }

    public String getNombrePar() {
        return nombrePar;
    }

    public void setNombrePar(String nombrePar) {
        this.nombrePar = nombrePar;
    }

    public String getDireccionPar() {
        return direccionPar;
    }

    public void setDireccionPar(String direccionPar) {
        this.direccionPar = direccionPar;
    }

    public Integer getCantidadPlazas() {
        return cantidadPlazas;
    }

    public void setCantidadPlazas(Integer cantidadPlazas) {
        this.cantidadPlazas = cantidadPlazas;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public List<PlazaEntity> getPlazasP() {
        return plazasP;
    }

    public void setPlazasP(List<PlazaEntity> plazasP) {
        this.plazasP = plazasP;
    }
    
}
