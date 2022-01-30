package com.mintic.easyparking.easyparkingback.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class VehiculoDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private long vehiculoId;
    private TipovDto idTipov;
    private ReservaDto idReserva;
    private PlazaDto plazaVehiculo;
    private String placaVehiculo;
    private boolean reservoPlaza;    
    private LocalDateTime ingresoVeh;
    private boolean utilizando;
    private List<FacturaDto> facturasV;

    public long getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(long vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public TipovDto getIdTipov() {
        return idTipov;
    }

    public void setIdTipov(TipovDto idTipov) {
        this.idTipov = idTipov;
    }

    public ReservaDto getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(ReservaDto idReserva) {
        this.idReserva = idReserva;
    }

    public PlazaDto getPlazaVehiculo() {
        return plazaVehiculo;
    }

    public void setPlazaVehiculo(PlazaDto plazaVehiculo) {
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

    public List<FacturaDto> getFacturasV() {
        return facturasV;
    }

    public void setFacturasV(List<FacturaDto> facturasV) {
        this.facturasV = facturasV;
    }

}
