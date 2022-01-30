package com.mintic.easyparking.easyparkingback.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.data.annotation.CreatedDate;

@Entity(name = "vehiculo")
public class VehiculoEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long vehiculoId;
    
    @ManyToOne
    @JoinColumn(name = "id_tipov")
    private TipovEntity idTipov;
    
    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private ReservaEntity idReserva;
    
    @ManyToOne
    @JoinColumn(name = "plaza_vehiculo")
    private PlazaEntity plazaVehiculo;
    
    @Column(nullable = true, length = 10)
    private String placaVehiculo;
    
    @Column(nullable = false)
    private boolean reservoPlaza;
    
    @CreatedDate
    private LocalDateTime ingresoVeh;
    
    @Column(nullable = false)
    private boolean utilizando;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculo")
    private List<FacturaEntity> facturasV = new ArrayList<>();

    public long getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(long vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public TipovEntity getIdTipov() {
        return idTipov;
    }

    public void setIdTipov(TipovEntity idTipov) {
        this.idTipov = idTipov;
    }

    public ReservaEntity getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(ReservaEntity idReserva) {
        this.idReserva = idReserva;
    }

    public PlazaEntity getPlazaVehiculo() {
        return plazaVehiculo;
    }

    public void setPlazaVehiculo(PlazaEntity plazaVehiculo) {
        this.plazaVehiculo = plazaVehiculo;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public boolean isReservoPlaza() {
        return reservoPlaza;
    }

    public void setReservoPlaza(boolean reservoPlaza) {
        this.reservoPlaza = reservoPlaza;
    }

    public LocalDateTime getIngresoVeh() {
        return ingresoVeh;
    }

    public void setIngresoVeh(LocalDateTime ingresoVeh) {
        this.ingresoVeh = ingresoVeh;
    }

    public boolean isUtilizando() {
        return utilizando;
    }

    public void setUtilizando(boolean utilizando) {
        this.utilizando = utilizando;
    }
    
    public List<FacturaEntity> getFacturasV() {
        return facturasV;
    }

    public void setFacturasV(List<FacturaEntity> facturasV) {
        this.facturasV = facturasV;
    }    
}
