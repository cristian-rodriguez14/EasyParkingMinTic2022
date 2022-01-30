package com.mintic.easyparking.easyparkingback.models.requests;

import java.time.LocalDateTime;

public class FacturaDetailsRequestModel {
    
    private Integer idAcceso;
    private Integer idVehiculo;
    private double cobro;    
    private boolean pago;
    private boolean copia;
    private LocalDateTime egreso;    

    public Integer getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(Integer idAcceso) {
        this.idAcceso = idAcceso;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
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
