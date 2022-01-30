package com.mintic.easyparking.easyparkingback.models.requests;

import java.time.LocalDate;

public class TrazabilidadDetailsRequestModel {
    
    private LocalDate inicio;
    private LocalDate fin;

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }
    
    
}
