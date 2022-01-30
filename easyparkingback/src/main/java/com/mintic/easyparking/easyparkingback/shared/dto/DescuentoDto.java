package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class DescuentoDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private long descuentoId;
    private boolean tieneDescuento;
    private LocalDate expira;
    private List<AccesoDto> accesosD;

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

    public List<AccesoDto> getAccesosD() {
        return accesosD;
    }

    public void setAccesosD(List<AccesoDto> accesosD) {
        this.accesosD = accesosD;
    }
    
}
