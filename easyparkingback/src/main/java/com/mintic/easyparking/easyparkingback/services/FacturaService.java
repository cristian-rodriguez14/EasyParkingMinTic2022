package com.mintic.easyparking.easyparkingback.services;

import com.lowagie.text.DocumentException;
import com.mintic.easyparking.easyparkingback.entities.AccesoEntity;
import com.mintic.easyparking.easyparkingback.entities.FacturaEntity;
import com.mintic.easyparking.easyparkingback.entities.PlazaEntity;
import com.mintic.easyparking.easyparkingback.entities.TrazabilidadE;
import com.mintic.easyparking.easyparkingback.entities.VehiculoEntity;

import com.mintic.easyparking.easyparkingback.repositories.AccesoRepository;
import com.mintic.easyparking.easyparkingback.repositories.FacturaRepository;
import com.mintic.easyparking.easyparkingback.repositories.PlazaRepository;
import com.mintic.easyparking.easyparkingback.repositories.TrazabilidadR;
import com.mintic.easyparking.easyparkingback.repositories.VehiculoRepository;

import com.mintic.easyparking.easyparkingback.shared.dto.FacturaCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.FacturaDto;
import com.mintic.easyparking.easyparkingback.shared.dto.TrazabilidadD;
import com.mintic.easyparking.easyparkingback.utils.PrintPDF;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService implements FacturaServiceInterface {    
       
    @Autowired
    FacturaRepository facturaRepository;    
    
    @Autowired
    AccesoRepository accesoRepository;    
    
    @Autowired
    VehiculoRepository vehiculoRepository;
    
    @Autowired
    PlazaRepository plazaRepository;
    
    @Autowired
    TrazabilidadR trazabilidadR;
    
    @Autowired
    ModelMapper mapper;
    
    @Override
    public FacturaDto createFactura(FacturaCreationDto factura) {
        
        AccesoEntity accesoEntity = accesoRepository.findById(factura.getIdAcceso());
        VehiculoEntity vehiculoEntity = vehiculoRepository.findById(factura.getIdVehiculo());
        PlazaEntity plazaEntity;
        if(vehiculoEntity.isReservoPlaza()== true) {
             plazaEntity = plazaRepository.findById(vehiculoEntity.getIdReserva().getIdPlaza().getPlazaId());
        } else {
            plazaEntity = plazaRepository.findById(vehiculoEntity.getPlazaVehiculo().getPlazaId());
        }
        
        LocalDateTime FechaActual = LocalDateTime.now();
        int horaEntrada = vehiculoEntity.getIngresoVeh().getHour();
        int minutoEntrada = vehiculoEntity.getIngresoVeh().getMinute();
        int horaSalida = FechaActual.getHour(); 
        int minutoSalida = FechaActual.getMinute();
        int horaAMinutosIn = horaEntrada *60;
        int horaAMinutosOut = horaSalida *60;
        int totalTiempoEntrada = horaAMinutosIn + minutoEntrada;
        int totalTiempoSalida = horaAMinutosOut + minutoSalida;
        int tiempoTotal = totalTiempoSalida - totalTiempoEntrada;
        double cobroVehiculo = 0;
        double cobroTotal = 0;
        
        if(vehiculoEntity.getIdTipov().getTipovId() == 1){
            cobroVehiculo = 500;
        } else {
            cobroVehiculo = 1000;
        }
        cobroTotal = ((double) tiempoTotal)*cobroVehiculo;                 
        
        FacturaEntity facturaEntity = new FacturaEntity();
        facturaEntity.setIdAcceso(accesoEntity);
        facturaEntity.setIdVehiculo(vehiculoEntity);        
        facturaEntity.setCobro(cobroTotal);
        facturaEntity.setPago(factura.isPago());
        facturaEntity.setCopia(factura.isCopia());
        facturaEntity.setEgreso(LocalDateTime.now());
        plazaEntity.setEstadoPlaza(true);
        plazaRepository.save(plazaEntity);
        
        FacturaEntity createdFactura = facturaRepository.save(facturaEntity);
        
        FacturaDto facturaToReturn = mapper.map(createdFactura, FacturaDto.class);
        
        return facturaToReturn;
    }

    @Override
    public List<FacturaDto> getAllFacturas() {
        List<FacturaEntity> facturaEntities = facturaRepository.getDatosFacturas();
        
        List<FacturaDto> facturaDtos = new ArrayList<>();
        
        for(FacturaEntity factura: facturaEntities){
            FacturaDto facturaDto = mapper.map(factura, FacturaDto.class);
            facturaDtos.add(facturaDto);
        }
        return facturaDtos;
    }      
}
