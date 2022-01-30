package com.mintic.easyparking.easyparkingback.models.requests;

public class UsuarioDetailsRequestModel {

    private String nombre;
    private String apellido;
    private Integer idTipoi;
    private String ni;
    private String email;
    private Integer telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getIdTipoi() {
        return idTipoi;
    }

    public void setIdTipoi(Integer idTipoi) {
        this.idTipoi = idTipoi;
    }

    public String getNi() {
        return ni;
    }

    public void setNi(String ni) {
        this.ni = ni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    
    
}
