package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.util.List;

public class ParqueaderoDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
    private long parqueaderoId;
    private String nombrePar;
    private String direccionPar;
    private int cantidadPlazas;
    private String nombreAdmin;
    private List<PlazaDto> plazasP;

    public long getParqueaderoId() {
        return parqueaderoId;
    }

    public void setParqueaderoId(long parqueaderoId) {
        this.parqueaderoId = parqueaderoId;
    }

    public String getNombrePar() {
        return nombrePar;
    }

    public void setNombrePar(String nombrePar) {
        this.nombrePar = nombrePar;
    }

    public String getDireccionPar() {
        return direccionPar;
    }

    public void setDireccionPar(String direccionPar) {
        this.direccionPar = direccionPar;
    }

    public int getCantidadPlazas() {
        return cantidadPlazas;
    }

    public void setCantidadPlazas(int cantidadPlazas) {
        this.cantidadPlazas = cantidadPlazas;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public List<PlazaDto> getPlazasP() {
        return plazasP;
    }

    public void setPlazasP(List<PlazaDto> plazasP) {
        this.plazasP = plazasP;
    }
    
}
