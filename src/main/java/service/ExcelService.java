/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import model.Person;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Hp-Pc
 */
@Service
public class ExcelService {
    public Workbook uploadToExcel(CommonsMultipartFile fileBean) {
       ByteArrayInputStream bis = new ByteArrayInputStream(fileBean.getBytes());
        Workbook workbook=null;
        Person obj=null;
        try {
            fileBean.getOriginalFilename();
            String fileName=fileBean.getOriginalFilename();
            workbook = new HSSFWorkbook(bis);
//            if (fileName.endsWith("xls")) {
//                workbook = new HSSFWorkbook(bis);
//            } else if (fileName.endsWith("xlsx")) {
//                workbook = new XSSFWorkbook(bis);
//            } else {
//                throw new IllegalArgumentException("Received file does not have a standard excel extension.");
//         }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }
    public String getCellValue(Cell cell,int index)
    { 
    	 String cellvalue="";
    	   int cellType=    cell.getCellType();
           if(cellType==Cell.CELL_TYPE_STRING)
           {
           cellvalue= cell.getStringCellValue();
           }
           else if(cellType==Cell.CELL_TYPE_NUMERIC)
           {
           cellvalue=String.valueOf(cell.getNumericCellValue());
 
           }
           return cellvalue;
    }

}

