package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class AccesoDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private long accesoId;
    private UsuarioDto idUsuario;
    private RolDto idRol;
    private DescuentoDto idDescuento;
    private String username;
    private String password;
    private String encryptedPassword;
    private String resetPasswordToken;
    private boolean estadoAcceso;    
    private List<FacturaDto> facturasA;

    public long getAccesoId() {
        return accesoId;
    }

    public void setAccesoId(long accesoId) {
        this.accesoId = accesoId;
    }

    public UsuarioDto getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioDto idUsuario) {
        this.idUsuario = idUsuario;
    }

    public RolDto getIdRol() {
        return idRol;
    }

    public void setIdRol(RolDto idRol) {
        this.idRol = idRol;
    }

    public DescuentoDto getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(DescuentoDto idDescuento) {
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

    public List<FacturaDto> getFacturasA() {
        return facturasA;
    }

    public void setFacturasA(List<FacturaDto> facturasA) {
        this.facturasA = facturasA;
    }

}
