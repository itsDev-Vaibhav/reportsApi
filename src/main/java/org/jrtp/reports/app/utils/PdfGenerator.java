package org.jrtp.reports.app.utils;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.jrtp.reports.web.dto.response.EligibilitySearchResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 * @author vaibhav
 *@date 01-Sep-2022
 * 
 */
public class PdfGenerator {
	
	
	List<EligibilitySearchResponse> responseList;
	
	/**
	 * @param responseList
	 */
	public PdfGenerator(List<EligibilitySearchResponse> responseList) {
		this.responseList = responseList;
	}

	/**
	 * @param responseList
	 * @param response
	 */
	public void createPDF(HttpServletResponse response) {
		Document document = new Document(PageSize.A4);
        try {
			PdfWriter.getInstance(document, response.getOutputStream());
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
        Paragraph p = new Paragraph("Insurance PDF Report", font);
        p.setAlignment(Paragraph.ALIGN_CENTER); 
        document.add(p);
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 5.0f, 3.0f, 1.5f, 3.5f,});
        table.setSpacingBefore(10);
        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();
	}



	/**
	 * @param table
	 */
	private void writeTableData(PdfPTable table) {
		int i = 0;
		for(EligibilitySearchResponse resp : this.responseList) {
	    	  table.addCell(Integer.toString(++i));
	    	  table.addCell(resp.getName());
	    	  table.addCell(resp.getEmail());
	    	  table.addCell(String.valueOf(resp.getMobileNumber()));
	    	  table.addCell(String.valueOf(resp.getGender()));
	    	  table.addCell(resp.getSsn());
	      }
	}



	/**
	 * @param table
	 */
	private void writeTableHeader(PdfPTable table) {
		
		PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("S. No", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Full Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Mobile", font));
        table.addCell(cell);
            
        cell.setPhrase(new Phrase("Gen", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("SSN", font));
        table.addCell(cell);
	}
}