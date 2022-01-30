package com.mintic.easyparking.easyparkingback.models.requests;

public class ReservaDetailsRequestModel {

    private Integer idPlaza;
    private String placaa;
    private String creadoPor;
    private String hora;
    private String fecha;
    private Integer idEstador;

    public Integer getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(Integer idPlaza) {
        this.idPlaza = idPlaza;
    }

    public String getPlacaa() {
        return placaa;
    }

    public void setPlacaa(String placaa) {
        this.placaa = placaa;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }
    
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getIdEstador() {
        return idEstador;
    }

    public void setIdEstador(Integer idEstador) {
        this.idEstador = idEstador;
    }

}
