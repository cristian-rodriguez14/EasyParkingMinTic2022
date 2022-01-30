package com.mintic.easyparking.easyparkingback.models.responses;

public class ParqueaderoRest {
    
    private long parqueaderoId;
    private String nombrePar;
    private String direccionPar;
    private int cantidadPlazas;
    private String nombreAdmin;

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
        
}
