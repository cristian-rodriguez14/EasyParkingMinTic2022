package com.mintic.easyparking.easyparkingback.models.responses;

public class TarificacionRest {
    
    private long tarificacionId;
    private String tipoTarificacion;

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
    
}
