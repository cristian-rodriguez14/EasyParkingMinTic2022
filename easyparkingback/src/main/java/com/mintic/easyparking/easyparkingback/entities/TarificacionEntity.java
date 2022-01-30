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

@Entity(name = "tarificacion")
public class TarificacionEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long tarificacionId;
    
    @Column(nullable = false, length = 10)
    private String tipoTarificacion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTarificacion")
    private List<FacturaEntity> facturasT = new ArrayList<>();

    public Long getTarificacionId() {
        return tarificacionId;
    }

    public void setTarificacionId(Long tarificacionId) {
        this.tarificacionId = tarificacionId;
    }

    public String getTipoTarificacion() {
        return tipoTarificacion;
    }

    public void setTipoTarificacion(String tipoTarificacion) {
        this.tipoTarificacion = tipoTarificacion;
    }

    public List<FacturaEntity> getFacturasT() {
        return facturasT;
    }

    public void setFacturasT(List<FacturaEntity> facturasT) {
        this.facturasT = facturasT;
    }
    
}
