package com.mintic.easyparking.easyparkingback.models.responses;

import java.time.LocalDateTime;

public class VehiculoRest {

    private long vehiculoId;
    private TipovRest idTipov;
    private ReservaRest idReserva;
    private PlazaRest plazaVehiculo;
    private String placaVehiculo;
    private boolean reservoPlaza;        
    private LocalDateTime ingreso;
    private boolean utilizando;

    public long getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(long vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public TipovRest getIdTipov() {
        return idTipov;
    }

    public void setIdTipov(TipovRest idTipov) {
        this.idTipov = idTipov;
    }

    public ReservaRest getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(ReservaRest idReserva) {
        this.idReserva = idReserva;
    }

    public PlazaRest getPlazaVehiculo() {
        return plazaVehiculo;
    }

    public void setPlazaVehiculo(PlazaRest plazaVehiculo) {
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

    public LocalDateTime getIngreso() {
        return ingreso;
    }

    public void setIngreso(LocalDateTime ingreso) {
        this.ingreso = ingreso;
    }

    public boolean isUtilizando() {
        return utilizando;
    }

    public void setUtilizando(boolean utilizando) {
        this.utilizando = utilizando;
    }

}
