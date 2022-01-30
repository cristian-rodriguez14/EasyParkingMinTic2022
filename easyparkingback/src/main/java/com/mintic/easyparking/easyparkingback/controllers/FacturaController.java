package com.mintic.easyparking.easyparkingback.controllers;

import com.lowagie.text.DocumentException;
import com.mintic.easyparking.easyparkingback.entities.FacturaEntity;
import com.mintic.easyparking.easyparkingback.models.requests.FacturaDetailsRequestModel;
import com.mintic.easyparking.easyparkingback.models.requests.TrazabilidadDetailsRequestModel;
import com.mintic.easyparking.easyparkingback.models.responses.FacturaRest;
import com.mintic.easyparking.easyparkingback.models.responses.TrazabilidadModel;
import com.mintic.easyparking.easyparkingback.services.FacturaServiceInterface;
import com.mintic.easyparking.easyparkingback.shared.dto.FacturaCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.FacturaDto;
import com.mintic.easyparking.easyparkingback.shared.dto.TrazabilidadD;
import com.mintic.easyparking.easyparkingback.utils.PDFExporter;
import com.mintic.easyparking.easyparkingback.utils.PrintPDF;
import java.io.IOException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factura")
public class FacturaController {
    
    private FacturaEntity ultimaFacturaCreada;

    @Autowired
    FacturaServiceInterface facturaService;

    @Autowired
    ModelMapper mapper;

    @PostMapping(path = "/newFactura")
    public FacturaRest crearFactura(@RequestBody FacturaDetailsRequestModel facturaDetails,HttpServletResponse response) throws DocumentException, IOException {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        authentication.getPrincipal().toString();

        FacturaCreationDto facturaCreationDto = mapper.map(facturaDetails, FacturaCreationDto.class);
        
        FacturaDto facturaDto = facturaService.createFactura(facturaCreationDto);
        
        ultimaFacturaCreada = mapper.map(facturaDto, FacturaEntity.class);
//        printFactura(response);
        FacturaRest facturaToReturn = mapper.map(facturaDto, FacturaRest.class);
       
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=EasyParking.pdf";
        
        response.setHeader(headerKey, headerValue);
        
        PrintPDF exporter = new PrintPDF(ultimaFacturaCreada);
//        PDFExporter exporter = new PDFExporter(datosPDF);
        exporter.export(response);
        return facturaToReturn;
    }

    @GetMapping(path = "/allFacturas")
    public List<FacturaRest> datosFacturas() {
        List<FacturaDto> facturas = facturaService.getAllFacturas();

        List<FacturaRest> facturaRests = new ArrayList<>();

        for (FacturaDto factura : facturas) {
            FacturaRest facturaRest = mapper.map(factura, FacturaRest.class);
            facturaRests.add(facturaRest);
        }
        return facturaRests;
    }

//    @GetMapping(path = "/monthTrace")
//    public List<TrazabilidadModel> TrazaMensual(@RequestBody TrazabilidadDetailsRequestModel trazabilidadDetails) {
//        List<TrazabilidadD> graficas = facturaService.getMonthTrace(trazabilidadDetails.getInicio(), trazabilidadDetails.getFin());
//        System.out.println("Respuesta servicio: "+ graficas);
//        List<TrazabilidadModel> trazabilidadModels = new ArrayList<>();
//
//        for (TrazabilidadD grafica : graficas) {
//            TrazabilidadModel trazabilidadModel = mapper.map(grafica, TrazabilidadModel.class);
//            trazabilidadModels.add(trazabilidadModel);
//        }
//        return trazabilidadModels;
//    }
//
//    @GetMapping(path = "/anualTrace")
//    public List<TrazabilidadModel> TrazaAnual(@RequestBody TrazabilidadDetailsRequestModel trazabilidadDetails) {
//        List<TrazabilidadD> graficas = facturaService.getAnualTrace(trazabilidadDetails.getInicio(), trazabilidadDetails.getFin());
//        System.out.println("Respuesta servicio: "+ graficas);
//        List<TrazabilidadModel> trazabilidadModels = new ArrayList<>();
//
//        for (TrazabilidadD grafica : graficas) {
//            TrazabilidadModel trazabilidadModel = mapper.map(grafica, TrazabilidadModel.class);
//            trazabilidadModels.add(trazabilidadModel);
//        }
//        return trazabilidadModels;
//    }

    @GetMapping("/export")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        System.out.println("Entró al otro controlador");
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=EasyParking.pdf";
        
        response.setHeader(headerKey, headerValue);
        
        List<FacturaDto> datosPDF = facturaService.getAllFacturas();
        
        PDFExporter exporter = new PDFExporter(datosPDF);
        exporter.export(response);
    }
}
