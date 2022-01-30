package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.util.List;

public class TarificacionDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private long tarificacionId;
    private String tipoTarificacion;
    private List<FacturaDto> facturasT;

    public long getTarificacionId() {
        return tarificacionId;
    }

    public void setTarificacionId(long tarificacionId) {
        this.tarificacionId = tarificacionId;
    }

    public String getTipoTarificacion() {
        return tipoTarificacion;
    }

    public void setTipoTarificacion(String tipoTarificacion) {
        this.tipoTarificacion = tipoTarificacion;
    }

    public List<FacturaDto> getFacturasT() {
        return facturasT;
    }

    public void setFacturasT(List<FacturaDto> facturasT) {
        this.facturasT = facturasT;
    }
    
}
