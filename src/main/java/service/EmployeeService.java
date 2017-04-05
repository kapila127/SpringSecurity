package service;



import java.util.List;

import model.Employee;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	public Employee saveEmployee(Employee employee){
		Session session= this.sessionFactory.openSession();
		session.save(employee);
		return employee;
	}
	
	public List<Employee> listEmployee(){
		Session session= this.sessionFactory.openSession();
		String query="from Employee";
		Query queryList=  session.createQuery(query);
	    List<Employee>	 list=queryList.list();
		return list;
	}

}
