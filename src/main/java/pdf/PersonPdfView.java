/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Person;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/**
 *
 * @author Hp-Pc
 */
public class PersonPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map model, Document document, PdfWriter writer, HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        List personList = (List) model.get("personList");

        String[] cellList = {"ID", "Name", "Country"};
        PdfPTable table = setCell(cellList);

        for (Object pe : personList) {
            Person person = (Person) pe;
            table.addCell(String.valueOf(person.getId()));
            table.addCell(person.getName());
            table.addCell(person.getCountry());
        }
        document.add(table);
    }

    public PdfPTable setCell(String[] cellList) {
        PdfPTable table = new PdfPTable(cellList.length);
        for(String cellLabel:cellList)
        {
        PdfPCell cell = new PdfPCell(new Phrase(cellLabel));
        cell.setBackgroundColor(Color.RED);
        table.addCell(cell);
        
        }
        return table;
    }
}
