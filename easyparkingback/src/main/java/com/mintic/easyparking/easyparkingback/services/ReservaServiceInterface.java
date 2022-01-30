package com.mintic.easyparking.easyparkingback.services;

import com.mintic.easyparking.easyparkingback.shared.dto.EstadoDto;
import com.mintic.easyparking.easyparkingback.shared.dto.PlazaDto;
import com.mintic.easyparking.easyparkingback.shared.dto.ReservaCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.ReservaDto;
import java.util.List;

public interface ReservaServiceInterface {
    
    public ReservaDto createReserva(ReservaCreationDto reserva);
    
    public void getUsername(String username);
    
    public ReservaDto deleteReserva(long reservaId);
    
    public List<ReservaDto> getAllReservas();
    
    public List<ReservaDto> getUsuarioReservas();
    
    public List<PlazaDto> getAllPlazas();
    
    public List<EstadoDto> getAllEstadosr();
}
