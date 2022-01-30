package com.mintic.easyparking.easyparkingback.controllers;

import com.mintic.easyparking.easyparkingback.models.requests.ReservaDetailsRequestModel;
import com.mintic.easyparking.easyparkingback.models.responses.EstadoRest;
import com.mintic.easyparking.easyparkingback.models.responses.PlazaRest;
import com.mintic.easyparking.easyparkingback.models.responses.ReservaRest;

import com.mintic.easyparking.easyparkingback.services.ReservaServiceInterface;

import com.mintic.easyparking.easyparkingback.shared.dto.EstadoDto;
import com.mintic.easyparking.easyparkingback.shared.dto.PlazaDto;
import com.mintic.easyparking.easyparkingback.shared.dto.ReservaCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.ReservaDto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserva")

public class ReservaController {
    
    @Autowired
    ReservaServiceInterface reservaService;    
    
    @Autowired
    ModelMapper mapper;
    
    @PostMapping(path = "/newReserva")
    public ReservaRest crearReserva(@RequestBody ReservaDetailsRequestModel reservaDetails){
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        String username = authentication.getPrincipal().toString();        
        reservaService.getUsername(username);
        ReservaCreationDto reservaCreationDto = mapper.map(reservaDetails, ReservaCreationDto.class);
        
        ReservaDto reservaDto = reservaService.createReserva(reservaCreationDto);
        ReservaRest reservaToReturn = mapper.map(reservaDto, ReservaRest.class);
        
        return reservaToReturn;                
    }    
    
    @GetMapping(path = "/allReservas")
    public List<ReservaRest> datosReservas() {
        List<ReservaDto> reservas = reservaService.getAllReservas();
        
        List<ReservaRest> reservaRests = new ArrayList<>();
        
        for (ReservaDto reserva : reservas) {
            ReservaRest reservaRest = mapper.map(reserva, ReservaRest.class);
            reservaRests.add(reservaRest);
        }
        return reservaRests;
    }
    
    @GetMapping(path = "/allReservaUsuario")
    public List<ReservaRest> datosReservasUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        String username = authentication.getPrincipal().toString();
        reservaService.getUsername(username);
        List<ReservaDto> reservas = reservaService.getUsuarioReservas();
        
        List<ReservaRest> reservaRests = new ArrayList<>();
        
        for (ReservaDto reserva : reservas) {
            ReservaRest reservaRest = mapper.map(reserva, ReservaRest.class);
            reservaRests.add(reservaRest);
        }
        return reservaRests;
    }
    
    @GetMapping(path = "/allPlazas")
    public List<PlazaRest> tablaPlazas() {
        List<PlazaDto> plazas = reservaService.getAllPlazas();
        
        List<PlazaRest> plazaRests = new ArrayList<>();
        
        for (PlazaDto plaza : plazas) {
            PlazaRest plazaRest = mapper.map(plaza, PlazaRest.class);
            plazaRests.add(plazaRest);
        }
        return plazaRests;
    }
    
    @GetMapping(path = "/allEstadosr")
    public List<EstadoRest> tablaEstadosr() {
        List<EstadoDto> estadosr = reservaService.getAllEstadosr();
        
        List<EstadoRest> estadorRests = new ArrayList<>();
        
        for (EstadoDto estador : estadosr) {
            EstadoRest estadorRest = mapper.map(estador, EstadoRest.class);
            estadorRests.add(estadorRest);
        }
        return estadorRests;
    }
    
    
    @PutMapping(path = "/{id}")
    public ReservaRest borrarReserva(@PathVariable long id) {

        ReservaDto reservaDto = reservaService.deleteReserva(id);

        ReservaRest updatedReserva = mapper.map(reservaDto, ReservaRest.class);

        return updatedReserva;
    }
}
