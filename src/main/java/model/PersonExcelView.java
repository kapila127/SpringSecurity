/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
 *
 * @author Hp-Pc
 */
public class PersonExcelView extends AbstractExcelView{

    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
       HSSFSheet excelSheet = workbook.createSheet("Person List");
		setExcelHeader(excelSheet);
		
		List personList = (List) model.get("personList");
		setExcelRows(excelSheet,personList); 
        
    }
  
    public void setExcelHeader(HSSFSheet excelSheet) {
		HSSFRow excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Id");
		excelHeader.createCell(1).setCellValue("Name");
		excelHeader.createCell(2).setCellValue("country");
	}
	
	public void setExcelRows(HSSFSheet excelSheet, List<Person> personList){
		int record = 1;
		for (Person person: personList) {
			HSSFRow excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(person.getId());
			excelRow.createCell(1).setCellValue(person.getName());		
			excelRow.createCell(2).setCellValue(person.getCountry());
		}
	}
    
    
}
