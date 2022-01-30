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

@Entity(name = "rol")
public class RolEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long rolId;
    
    @Column(nullable = false, length = 20)
    private String nombreRol;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private List<AccesoEntity> accesosR = new ArrayList<>();

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public List<AccesoEntity> getAccesosR() {
        return accesosR;
    }

    public void setAccesosR(List<AccesoEntity> accesosR) {
        this.accesosR = accesosR;
    }
    
    
}
