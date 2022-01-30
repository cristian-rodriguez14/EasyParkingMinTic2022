package com.mintic.easyparking.easyparkingback.services;

import com.mintic.easyparking.easyparkingback.entities.EstadoEntity;
import com.mintic.easyparking.easyparkingback.entities.PlazaEntity;
import com.mintic.easyparking.easyparkingback.entities.ReservaEntity;
import com.mintic.easyparking.easyparkingback.entities.TipovEntity;
import com.mintic.easyparking.easyparkingback.entities.VehiculoEntity;
import com.mintic.easyparking.easyparkingback.repositories.EstadorRepository;
import com.mintic.easyparking.easyparkingback.repositories.PlazaRepository;

import com.mintic.easyparking.easyparkingback.repositories.TipovRepository;
import com.mintic.easyparking.easyparkingback.repositories.ReservaRepository;
import com.mintic.easyparking.easyparkingback.repositories.VehiculoRepository;
import com.mintic.easyparking.easyparkingback.shared.dto.ReservaCreationDto;

import com.mintic.easyparking.easyparkingback.shared.dto.TipovDto;
import com.mintic.easyparking.easyparkingback.shared.dto.VehiculoCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.VehiculoDto;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService implements VehiculoServiceInterface {
    
    @Autowired
    VehiculoRepository vehiculoRepository;
    
    @Autowired
    ReservaRepository reservaRepository;
    
    @Autowired
    TipovRepository tipovRepository;
    
    @Autowired
    EstadorRepository estadorRepository;
    
    @Autowired
    PlazaRepository plazaRepository;
    
    @Autowired
    ModelMapper mapper;
    
    @Override
    public VehiculoDto createVehiculo(VehiculoCreationDto vehiculo) {
        
        TipovEntity tipovEntity = tipovRepository.findById(vehiculo.getIdTipov());
        ReservaEntity reservaEntity = reservaRepository.findById(vehiculo.getIdReserva());
        PlazaEntity plazaEntity = plazaRepository.findById(vehiculo.getPlazaVehiculo());
        EstadoEntity estadorEntity = estadorRepository.findById(2);
        
        VehiculoEntity vehiculoEntity = new VehiculoEntity();        
        vehiculoEntity.setIdTipov(tipovEntity);
        vehiculoEntity.setReservoPlaza(vehiculo.isReservoPlaza());        
        vehiculoEntity.setIngresoVeh(LocalDateTime.now());
        
        if(vehiculo.isReservoPlaza() == true){
            reservaEntity.setIdEstado(estadorEntity);
            vehiculoEntity.setPlacaVehiculo(reservaEntity.getPlacaReserva());
            vehiculoEntity.setIdReserva(reservaEntity);                
        } else {
            vehiculoEntity.setPlacaVehiculo(vehiculo.getPlacaVehiculo());
            vehiculoEntity.setPlazaVehiculo(plazaEntity);
            plazaEntity.setEstadoPlaza(false);
            plazaRepository.save(plazaEntity);
        }
        
        VehiculoEntity createdVehiculo = vehiculoRepository.save(vehiculoEntity);
        
        VehiculoDto vehiculoToReturn = mapper.map(createdVehiculo, VehiculoDto.class);
        
        return vehiculoToReturn;
    }
    
    @Override
    public List<VehiculoDto> getAllVehiculos() {
        
        List<VehiculoEntity> vehiculoEntities = vehiculoRepository.getDatosVehiculos();
        
        List<VehiculoDto> vehiculoDtos = new ArrayList<>();
        
        for(VehiculoEntity vehiculo: vehiculoEntities){
            VehiculoDto vehiculoDto = mapper.map(vehiculo, VehiculoDto.class);
            vehiculoDtos.add(vehiculoDto);
        }
        return vehiculoDtos;
    }

    @Override
    public List<TipovDto> getAllTiposv() {
        
        List<TipovEntity> tipovEntities = tipovRepository.getTiposv();
        
        List<TipovDto> tipovDtos = new ArrayList<>();
        
        for(TipovEntity tipov: tipovEntities){
            TipovDto tipovDto = mapper.map(tipov, TipovDto.class);
            tipovDtos.add(tipovDto);
        }
        return tipovDtos;
    }
                
}
