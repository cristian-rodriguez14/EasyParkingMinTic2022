package com.mintic.easyparking.easyparkingback.utils;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.mintic.easyparking.easyparkingback.shared.dto.FacturaDto;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class PDFExporter {
    private List<FacturaDto> datosPDF;

    public PDFExporter(List<FacturaDto> datosPDF) {
        this.datosPDF = datosPDF;
    }
    
    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
        
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
        
        cell.setPhrase(new Phrase("Placa", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Documento", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Cobro", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Pago", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Copia", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Egreso", font));
        table.addCell(cell);

    }
    
    private void writeTableData(PdfPTable table){
        for (FacturaDto factura : datosPDF) {
            if(factura.getIdVehiculo().isReservoPlaza()== true){
                table.addCell(String.valueOf(factura.getIdVehiculo().getIdReserva().getPlacaReserva()));
            }else{
                table.addCell(String.valueOf(factura.getIdVehiculo().getPlacaVehiculo()));
            }
            table.addCell(String.valueOf(factura.getIdAcceso().getIdUsuario().getIdentificacionUsuario()));
            table.addCell(String.valueOf(factura.getCobro()));
            if(factura.isCopia() == true){
                table.addCell("Si");
            }else{
                table.addCell("No");
            }
            if(factura.isPago() == true){
                table.addCell("Si");
            }else{
                table.addCell("No");
            }
            table.addCell(String.valueOf(factura.getEgreso()));
        }
    }
    
    public void export(HttpServletResponse response) throws DocumentException, IOException{
        Document document = new Document(PageSize.A4);
        
        PdfWriter.getInstance(document, response.getOutputStream());
        
        document.open();
        
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.BLUE);
        font.setSize(8);
        
        Paragraph title = new Paragraph("Listado de Facturas", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);
        
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        table.setWidths(new float[] {3.0f,3.0f,3.5f,1.5f,1.5f,4.5f});
        
        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();
    }
}
