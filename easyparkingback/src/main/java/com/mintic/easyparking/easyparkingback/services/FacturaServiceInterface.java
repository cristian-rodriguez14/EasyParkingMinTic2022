package com.mintic.easyparking.easyparkingback.services;

import com.mintic.easyparking.easyparkingback.entities.FacturaEntity;
import com.mintic.easyparking.easyparkingback.shared.dto.FacturaCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.FacturaDto;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface FacturaServiceInterface {
    
    public FacturaDto createFactura(FacturaCreationDto factura);
    
    public List<FacturaDto> getAllFacturas();
    
//    public List<TrazabilidadD> getMonthTrace(LocalDate inicio, LocalDate fin);
//    
//    public List<TrazabilidadD> getAnualTrace(LocalDate inicio, LocalDate fin);
}
