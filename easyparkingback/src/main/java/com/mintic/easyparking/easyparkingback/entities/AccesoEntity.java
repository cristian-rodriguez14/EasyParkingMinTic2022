package com.mintic.easyparking.easyparkingback.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity(name = "acceso")
@Table(indexes = { @Index(columnList = "username", name = "index_username", unique = true) })
public class AccesoEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long accesoId;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity idUsuario;
    
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RolEntity idRol;
    
    @ManyToOne
    @JoinColumn(name = "id_descuento")
    private DescuentoEntity idDescuento;
    
    @Column(nullable = false, length = 50)
    private String username;
    
    @Column(nullable = false)
    private String encryptedPassword;
    
    @Column(name = "reset_password_token", length = 30)
    private String resetPasswordToken;
    
    @Column(nullable = false)
    private boolean estadoAcceso;        
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAcceso")
    private List<FacturaEntity> facturasA = new ArrayList<>();

    public long getAccesoId() {
        return accesoId;
    }

    public void setAccesoId(long accesoId) {
        this.accesoId = accesoId;
    }

    public UsuarioEntity getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioEntity idUsuario) {
        this.idUsuario = idUsuario;
    }

    public RolEntity getIdRol() {
        return idRol;
    }

    public void setIdRol(RolEntity idRol) {
        this.idRol = idRol;
    }

    public DescuentoEntity getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(DescuentoEntity idDescuento) {
        this.idDescuento = idDescuento;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<FacturaEntity> getFacturasA() {
        return facturasA;
    }

    public void setFacturasA(List<FacturaEntity> facturasA) {
        this.facturasA = facturasA;
    }

}
