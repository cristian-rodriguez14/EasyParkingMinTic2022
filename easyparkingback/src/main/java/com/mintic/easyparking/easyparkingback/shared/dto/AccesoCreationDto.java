package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class AccesoCreationDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private long idUsuario;
    private long idRol;
    private long idDescuento;
    private String username;
    private String password;
    private String encryptedPassword;
    private String resetPasswordToken;
    private boolean estadoAcceso;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdRol() {
        return idRol;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

    public long getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(long idDescuento) {
        this.idDescuento = idDescuento;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public boolean isEstadoAcceso() {
        return estadoAcceso;
    }

    public void setEstadoAcceso(boolean estadoAcceso) {
        this.estadoAcceso = estadoAcceso;
    }

}
