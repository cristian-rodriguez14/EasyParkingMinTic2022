package com.mintic.easyparking.easyparkingback.models.responses;

import java.time.LocalDate;

public class DescuentoRest {
    
    private long descuentoId;
    private boolean tieneDescuento;
    private LocalDate expira;

    public long getDescuentoId() {
        return descuentoId;
    }

    public void setDescuentoId(long descuentoId) {
        this.descuentoId = descuentoId;
    }

    public boolean isTieneDescuento() {
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
        
}
