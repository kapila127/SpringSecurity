package controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.Person;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import service.ExcelService;
import service.PersonService;
import service.PersonServiceImpl;


@Controller
@RemoteProxy(name="personController")
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private ExcelService excelService;

    public ExcelService getExcelService() {
        return excelService;
    }

    public void setExcelService(ExcelService excelService) {
        this.excelService = excelService;
    }

    public void setPersonService(PersonService ps) {
        this.personService = ps;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }

    //For add and update person both
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p) {

        if (p.getId() == 0) {

            this.personService.addPerson(p);
        } else {

            this.personService.updatePerson(p);
        }

        return "redirect:/person/persons";
    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id) {

        this.personService.removePerson(id);
        return "redirect:/person/persons";
    }

    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }

    @RequestMapping("/exportToExcel")
    public ModelAndView exportToExcel() {
        List persons = this.personService.listPersons();
        return new ModelAndView("personListExcel", "personList", persons);
    }

    @RequestMapping("/exportToPdf")
    public ModelAndView exportToPdf() {
        List persons = this.personService.listPersons();
        return new ModelAndView("personListPdf", "personList", persons);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/importToPdf")
    public String importToPdf(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload) {
                Workbook workbook = excelService.uploadToExcel(aFile);
                Sheet sheet = workbook.getSheetAt(0);
                for (Row row : sheet) {
                    int index = 0;
                    if (row.getRowNum() != 0) {
                        Cell cell = row.getCell(0);
                        String id = excelService.getCellValue(cell, index);
                        index += 1;
                        cell = row.getCell(1);
                        String name = excelService.getCellValue(cell, index);
                        index += 1;
                        cell = row.getCell(2);
                        String country = excelService.getCellValue(cell, index);
                        if (!id.isEmpty()) {
                            Double idVal = Double.parseDouble(id);
                            int value = idVal.intValue();
                            Person p = null;
                            try {
                                p = personService.getPersonById(value);
                            } catch (Exception e) {
                            }
                            if (p == null) {
                                p = new Person();
                                p.setName(name);
                                p.setCountry(country);
                                personService.addPerson(p);
                            } else {
                                p.setName(name);
                                p.setCountry(country);
                                personService.updatePerson(p);
                            }

                        }
                    }
                }
            }
        }
        return "redirect:/person/persons";
    }
    @RemoteMethod
    public String testDwr()
    {
        return "hello";
    }
}
