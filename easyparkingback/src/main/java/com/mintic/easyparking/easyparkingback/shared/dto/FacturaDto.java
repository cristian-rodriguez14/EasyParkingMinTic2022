package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FacturaDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private long facturaId;
    private AccesoDto idAcceso;
    private VehiculoDto idVehiculo;
    private TarificacionDto idTarificacion;
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

    public AccesoDto getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(AccesoDto idAcceso) {
        this.idAcceso = idAcceso;
    }

    public VehiculoDto getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(VehiculoDto idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public TarificacionDto getIdTarificacion() {
        return idTarificacion;
    }

    public void setIdTarificacion(TarificacionDto idTarificacion) {
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
