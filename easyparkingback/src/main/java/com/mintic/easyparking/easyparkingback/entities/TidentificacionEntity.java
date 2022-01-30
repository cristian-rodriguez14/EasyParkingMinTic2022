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

@Entity(name = "tidentificacion")
public class TidentificacionEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long tipoiId;
    
    @Column(nullable = false, length = 60)
    private String tipoNombre;
    
    @Column(nullable = false, length = 50)
    private String acronimo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoi")
    private List<UsuarioEntity> usuariosTi = new ArrayList<>();

    public long getTipoiId() {
        return tipoiId;
    }

    public void setTipoiId(long tipoiId) {
        this.tipoiId = tipoiId;
    }

    public String getTipoNombre() {
        return tipoNombre;
    }

    public void setTipoNombre(String tipoNombre) {
        this.tipoNombre = tipoNombre;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public List<UsuarioEntity> getUsuariosTi() {
        return usuariosTi;
    }

    public void setUsuariosTi(List<UsuarioEntity> usuariosTi) {
        this.usuariosTi = usuariosTi;
    }
    
    
}
