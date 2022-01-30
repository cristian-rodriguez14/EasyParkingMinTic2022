package com.mintic.easyparking.easyparkingback.models.responses;

import java.time.LocalDateTime;

public class FacturaRest {
    
    private long facturaId;
    private AccesoRest idAcceso;
    private VehiculoRest idVehiculo;
    private TarificacionRest idTarificacion;
    private double cobro;    
    private boolean pago;
    private boolean copia;
    private LocalDateTime egreso;

    public long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(long facturaId) {
        this.facturaId = facturaId;
    }

    public AccesoRest getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(AccesoRest idAcceso) {
        this.idAcceso = idAcceso;
    }

    public VehiculoRest getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(VehiculoRest idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public TarificacionRest getIdTarificacion() {
        return idTarificacion;
    }

    public void setIdTarificacion(TarificacionRest idTarificacion) {
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
