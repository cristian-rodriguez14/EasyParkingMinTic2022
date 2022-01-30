package com.mintic.easyparking.easyparkingback.entities;

import java.io.Serializable;
import java.util.ArrayList;
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

@Entity(name = "usuario")
@Table(indexes = { @Index(columnList = "email", name = "index_email", unique = true) })
public class UsuarioEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long usuarioId;
    
    @ManyToOne
    @JoinColumn(name = "id_tipoi")
    private TidentificacionEntity idTipoi;
    
    @Column(nullable = false, length = 50)
    private String nombreUsuario;
    
    @Column(nullable = false, length = 50)
    private String apellidoUsuario;        
    
    @Column(nullable = false, length = 50)
    private String identificacionUsuario;
    
    @Column(nullable = false, length = 100)
    private String emailUsuario;
    
    @Column(nullable = false)
    private Integer telefonoUsuario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<AccesoEntity> accesosU = new ArrayList<>();

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public TidentificacionEntity getIdTipoi() {
        return idTipoi;
    }

    public void setIdTipoi(TidentificacionEntity idTipoi) {
        this.idTipoi = idTipoi;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public Integer getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(Integer telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }
    
    public List<AccesoEntity> getAccesosU() {
        return accesosU;
    }

    public void setAccesosU(List<AccesoEntity> accesosU) {
        this.accesosU = accesosU;
    }    
}
