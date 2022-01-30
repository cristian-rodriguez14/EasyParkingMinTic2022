package com.mintic.easyparking.easyparkingback.utils;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.mintic.easyparking.easyparkingback.entities.FacturaEntity;
import com.mintic.easyparking.easyparkingback.shared.dto.FacturaCreationDto;
import java.awt.Color;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class PrintPDF {    
    private FacturaEntity printDatos;
    private String newPlaca;

    public PrintPDF(FacturaEntity printDatos) {
        this.printDatos = printDatos;
    }
    
    public void export(HttpServletResponse response) throws DocumentException, IOException{
        
        Document document = new Document(PageSize.A8);
        
        PdfWriter.getInstance(document, response.getOutputStream());
        
        document.open();
        
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);
        font.setSize(7);
        
        Paragraph title = new Paragraph("EASY PARKING", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);
        
        Paragraph subtitle = new Paragraph("CRISTIAN RODRIGUEZ", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(subtitle);
        
        Paragraph nit = new Paragraph("NIT. 1098695730-1", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(nit);
        
        Paragraph other = new Paragraph("REGIMEN SIMPLIFICADO", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(other);
        
        Paragraph dir = new Paragraph("\nCarrera X # Y - Z", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(dir);
        
        Paragraph tel = new Paragraph("6984532", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(tel);
        
        Paragraph more = new Paragraph("FACTURA DE VENTA", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(more);
        
        Paragraph aten = new Paragraph(String.valueOf(printDatos.getEgreso()), font);
        title.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        document.add(aten);
        
        String fullname = printDatos.getIdAcceso().getIdUsuario().getNombreUsuario()+ " " + printDatos.getIdAcceso().getIdUsuario().getApellidoUsuario();
        Paragraph nombre = new Paragraph(fullname, font);
        title.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        document.add(nombre);
        
        Paragraph doc = new Paragraph(printDatos.getIdAcceso().getIdUsuario().getIdentificacionUsuario(), font);
        title.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        document.add(doc);
        
        if(printDatos.getIdVehiculo().isReservoPlaza() == true){
            newPlaca = printDatos.getIdVehiculo().getIdReserva().getPlacaReserva();
        } else {
            newPlaca = printDatos.getIdVehiculo().getPlacaVehiculo();
        }
        
        Paragraph placa = new Paragraph(newPlaca, font);
        title.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        document.add(placa);
        
        String precio = "$ "+String.valueOf(printDatos.getCobro());
        
        Paragraph mon = new Paragraph(precio, font);
        title.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        document.add(mon);
        
        document.close();
    }
}
