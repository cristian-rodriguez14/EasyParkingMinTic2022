package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FacturaCreationDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private long idAcceso;
    private long idVehiculo;
    private long idTarificacion;
    private double cobro;    
    private boolean pago;
    private boolean copia;
    private LocalDateTime egreso;

    public long getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(long idAcceso) {
        this.idAcceso = idAcceso;
    }

    public long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public long getIdTarificacion() {
        return idTarificacion;
    }

    public void setIdTarificacion(long idTarificacion) {
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
