package com.mintic.easyparking.easyparkingback.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "descuento")
public class DescuentoEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long descuentoId;
    
    @Column(nullable = false)
    private boolean tieneDescuento;
    
    @Column(nullable = true)
    private LocalDate expira;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDescuento")
    private List<AccesoEntity> accesosD = new ArrayList<>();

    public Long getDescuentoId() {
        return descuentoId;
    }

    public void setDescuentoId(Long descuentoId) {
        this.descuentoId = descuentoId;
    }

    public boolean getTieneDescuento() {
        return tieneDescuento;
    }

    public void setTieneDescuento(boolean tieneDescuento) {
        this.tieneDescuento = tieneDescuento;
    }

    public LocalDate getExpira() {
        return expira;
    }

    public void setExpira(LocalDate expira) {
        this.expira = expira;
    }

    public List<AccesoEntity> getAccesosD() {
        return accesosD;
    }

    public void setAccesosD(List<AccesoEntity> accesosD) {
        this.accesosD = accesosD;
    }
    
}
