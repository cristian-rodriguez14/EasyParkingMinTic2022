package com.mintic.easyparking.easyparkingback.controllers;

import com.mintic.easyparking.easyparkingback.models.requests.ReservaDetailsRequestModel;
import com.mintic.easyparking.easyparkingback.models.requests.VehiculoDetailsRequestModel;
import com.mintic.easyparking.easyparkingback.models.responses.TipovRest;
import com.mintic.easyparking.easyparkingback.models.responses.VehiculoRest;
import com.mintic.easyparking.easyparkingback.services.VehiculoServiceInterface;
import com.mintic.easyparking.easyparkingback.shared.dto.ReservaCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.TipovDto;
import com.mintic.easyparking.easyparkingback.shared.dto.VehiculoCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.VehiculoDto;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    VehiculoServiceInterface vehiculoService;
    
    @Autowired
    ModelMapper mapper;
 
    @PostMapping(path = "/newVehiculo")
    public VehiculoRest crearVehiculo(@RequestBody VehiculoDetailsRequestModel vehiculoDetails) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        authentication.getPrincipal().toString();
        
        VehiculoCreationDto vehiculoCreationDto = mapper.map(vehiculoDetails, VehiculoCreationDto.class);
        
        VehiculoDto vehiculoDto = vehiculoService.createVehiculo(vehiculoCreationDto);
        
        VehiculoRest vehiculoToReturn = mapper.map(vehiculoDto, VehiculoRest.class);
        
        return vehiculoToReturn;
    }
    
    @GetMapping(path = "/allVehiculos")
    public List<VehiculoRest> datosVehiculos() {
        List<VehiculoDto> vehiculos = vehiculoService.getAllVehiculos();
        
        List<VehiculoRest> vehiculoRests = new ArrayList<>();
        
        for (VehiculoDto vehiculo : vehiculos) {
            VehiculoRest vehiculoRest = mapper.map(vehiculo, VehiculoRest.class);
            vehiculoRests.add(vehiculoRest);
        }
        return vehiculoRests;
    }
    
    @GetMapping(path = "/allTiposv")
    public List<TipovRest> tablaTiposv() {
        List<TipovDto> tiposv = vehiculoService.getAllTiposv();
        
        List<TipovRest> tipovRests = new ArrayList<>();
        
        for (TipovDto tipov : tiposv) {
            TipovRest tipovRest = mapper.map(tipov, TipovRest.class);
            tipovRests.add(tipovRest);
        }
        return tipovRests;
    }
}
