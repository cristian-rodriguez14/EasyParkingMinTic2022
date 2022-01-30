package com.mintic.easyparking.easyparkingback.services;

import com.mintic.easyparking.easyparkingback.shared.dto.ReservaCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.TipovDto;
import com.mintic.easyparking.easyparkingback.shared.dto.VehiculoCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.VehiculoDto;
import java.util.List;

public interface VehiculoServiceInterface {

    public VehiculoDto createVehiculo(VehiculoCreationDto vehiculo);     
    
    public List<VehiculoDto> getAllVehiculos();
    
    public List<TipovDto> getAllTiposv();
    
}
