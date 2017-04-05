package controller;

import java.util.List;

import model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired EmployeeService employeeService;
	
	@RequestMapping(value="insertEmployee",method=RequestMethod.POST)
	public Employee insertEmployee(@RequestBody Employee emp){
		employeeService.saveEmployee(emp);
		return emp;
	}
	
	@RequestMapping(value="listEmployee",method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody Employee listEmployee(){
		
		return employeeService.listEmployee().get(0);
	}
	
	
}
