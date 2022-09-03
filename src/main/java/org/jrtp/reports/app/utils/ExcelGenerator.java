package org.jrtp.reports.app.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jrtp.reports.web.dto.response.EligibilitySearchResponse;

/**
 * @author vaibhav
 *@date 02-Sep-2022
 * 
 */
public class ExcelGenerator {
	
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
	List<EligibilitySearchResponse> customerList;

	/**
	 * @param responseList
	 */
	public ExcelGenerator(List<EligibilitySearchResponse> responseList) {
		customerList = responseList;
		workbook = new XSSFWorkbook();
	}
	
	
	/**
	 * @param response
	 * @throws IOException 
	 */
	public void generateExcel(HttpServletResponse response) {
        writeHeaderLine();
        writeDataLines();
		try(ServletOutputStream outputStream = response.getOutputStream()) {
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	
	/**
	 * 
	 */
	private void writeDataLines() {
			int rowCount = 1;
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setFontHeight(14);
	        style.setFont(font);
	        for (EligibilitySearchResponse entity : customerList) {
	            Row row = sheet.createRow(rowCount++);
	            int columnCount = 0;
	            createCell(row, columnCount++, (rowCount - 1), style);
	            createCell(row, columnCount++, entity.getName(), style);
	            createCell(row, columnCount++, entity.getEmail(), style);
	            createCell(row, columnCount++, String.valueOf(entity.getMobileNumber()), style);
	            createCell(row, columnCount++, String.valueOf(entity.getGender()), style);
	            createCell(row, columnCount++, entity.getSsn(), style);
	             
	        }
	}


	/**
	 * 
	 */
	private void writeHeaderLine() {
		sheet = workbook.createSheet("UserReport");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        style.setFillBackgroundColor((short) 210);
        createCell(row, 0, "S.No", style);      
        createCell(row, 1, "Full Name", style);       
        createCell(row, 2, "E-mail", style);    
        createCell(row, 3, "Mobile", style);
        createCell(row, 4, "Gender", style);
        createCell(row, 5, "SSN", style);

	}
	
	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
}
