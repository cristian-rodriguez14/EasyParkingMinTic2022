package com.mintic.easyparking.easyparkingback.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "factura")
@EntityListeners(AuditingEntityListener.class)
public class FacturaEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long facturaId;
    
    @ManyToOne
    @JoinColumn(name = "id_acceso")
    private AccesoEntity idAcceso;
    
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private VehiculoEntity idVehiculo;
    
    @ManyToOne
    @JoinColumn(name = "id_tarificacion")
    private TarificacionEntity idTarificacion;
    
    @Column(nullable = false)
    private double cobro;   
    
    @Column(nullable = false)
    private boolean pago;
    
    @Column(nullable = false)
    private boolean copia;
    
    @CreatedDate
    private LocalDateTime egreso;    

    public long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(long facturaId) {
        this.facturaId = facturaId;
    }

    public AccesoEntity getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(AccesoEntity idAcceso) {
        this.idAcceso = idAcceso;
    }

    public VehiculoEntity getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(VehiculoEntity idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public TarificacionEntity getIdTarificacion() {
        return idTarificacion;
    }

    public void setIdTarificacion(TarificacionEntity idTarificacion) {
        this.idTarificacion = idTarificacion;
    }

    public double getCobro() {
        return cobro;
    }

    public void setCobro(double cobro) {
        this.cobro = cobro;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public boolean isCopia() {
        return copia;
    }

    public void setCopia(boolean copia) {
        this.copia = copia;
    }

    public LocalDateTime getEgreso() {
        return egreso;
    }

    public void setEgreso(LocalDateTime egreso) {
        this.egreso = egreso;
    }    
}
