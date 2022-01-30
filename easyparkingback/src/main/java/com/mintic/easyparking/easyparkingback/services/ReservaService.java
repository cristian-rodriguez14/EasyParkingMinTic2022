package com.mintic.easyparking.easyparkingback.services;

import com.mintic.easyparking.easyparkingback.entities.EstadoEntity;
import com.mintic.easyparking.easyparkingback.entities.PlazaEntity;
import com.mintic.easyparking.easyparkingback.entities.ReservaEntity;

import com.mintic.easyparking.easyparkingback.repositories.EstadorRepository;
import com.mintic.easyparking.easyparkingback.repositories.PlazaRepository;
import com.mintic.easyparking.easyparkingback.repositories.ReservaRepository;
import com.mintic.easyparking.easyparkingback.shared.dto.EstadoDto;

import com.mintic.easyparking.easyparkingback.shared.dto.PlazaDto;
import com.mintic.easyparking.easyparkingback.shared.dto.ReservaCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.ReservaDto;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService implements ReservaServiceInterface {
    
    private String usuarioActual;

    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    PlazaRepository plazaRepository;

    @Autowired
    EstadorRepository estadorRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public ReservaDto createReserva(ReservaCreationDto reserva) {
        
        EstadoEntity estadorEntity = estadorRepository.findById(1);
        PlazaEntity plazaEntity = plazaRepository.findById(reserva.getIdPlaza());
        
        ReservaEntity reservaEntity = new ReservaEntity();
        reservaEntity.setIdPlaza(plazaEntity);
        reservaEntity.setPlacaReserva(reserva.getPlacaReserva());
        reservaEntity.setCreadoPor(usuarioActual);
        reservaEntity.setHoraReserva(reserva.getHoraReserva());
        reservaEntity.setFechaReserva(reserva.getFechaReserva());        
        reservaEntity.setIdEstado(estadorEntity);
        plazaEntity.setEstadoPlaza(false);
        plazaRepository.save(plazaEntity);
        
        ReservaEntity createdReserva = reservaRepository.save(reservaEntity);

        ReservaDto reservaToReturn = mapper.map(createdReserva, ReservaDto.class);

        return reservaToReturn;
    }
    
    @Override
    public void getUsername(String username){
        usuarioActual = username;
    }

    @Override
    public List<ReservaDto> getAllReservas() {

        List<ReservaEntity> reservaEntities = reservaRepository.getDatosReservas();

        List<ReservaDto> reservaDtos = new ArrayList<>();

        for (ReservaEntity reserva : reservaEntities) {
            ReservaDto reservaDto = mapper.map(reserva, ReservaDto.class);
            reservaDtos.add(reservaDto);
        }
        return reservaDtos;
    }
    
    @Override
    public List<ReservaDto> getUsuarioReservas() {

        List<ReservaEntity> reservaEntities = reservaRepository.getDatosReservaByUsuario(usuarioActual);

        List<ReservaDto> reservaDtos = new ArrayList<>();

        for (ReservaEntity reserva : reservaEntities) {
            ReservaDto reservaDto = mapper.map(reserva, ReservaDto.class);
            reservaDtos.add(reservaDto);
        }
        return reservaDtos;
    }
    
    @Override
    public List<PlazaDto> getAllPlazas() {
        
        List<PlazaEntity> plazaEntities = plazaRepository.getPlazas();
        
        List<PlazaDto> plazaDtos = new ArrayList<>();
        
        for(PlazaEntity plaza: plazaEntities){
            PlazaDto plazaDto = mapper.map(plaza, PlazaDto.class);
            plazaDtos.add(plazaDto);
        }
        return plazaDtos;
    }

    @Override
    public List<EstadoDto> getAllEstadosr() {
        
        List<EstadoEntity> estadorEntities = estadorRepository.getEstadosr();
        
        List<EstadoDto> estadorDtos = new ArrayList<>();
        
        for(EstadoEntity estador: estadorEntities){
            EstadoDto estadorDto = mapper.map(estador, EstadoDto.class);
            estadorDtos.add(estadorDto);
        }
        return estadorDtos;
    }

    @Override
    public ReservaDto deleteReserva(long reservaId) {
        ReservaEntity reservaEntity = reservaRepository.findById(reservaId);
        ReservaCreationDto reserva = mapper.map(reservaEntity, ReservaCreationDto.class);
        PlazaEntity plazaEntity = plazaRepository.findById(reserva.getIdPlaza());
        EstadoEntity estadorEntity = estadorRepository.findById(3);

        reservaEntity.setIdEstado(estadorEntity);
        plazaEntity.setEstadoPlaza(true);
        plazaRepository.save(plazaEntity);
        ReservaEntity updatedReserva = reservaRepository.save(reservaEntity);

        ReservaDto reservaDto = mapper.map(updatedReserva, ReservaDto.class);

        return reservaDto;
    }    

}
