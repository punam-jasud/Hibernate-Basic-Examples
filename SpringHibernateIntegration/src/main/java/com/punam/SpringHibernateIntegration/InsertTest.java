package com.punam.SpringHibernateIntegration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;  

public class InsertTest {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	      
	    EmployeeDao dao=(EmployeeDao)context.getBean("d");  
	      
	    Employee emp = new Employee();
	    
	    emp.setId(242);
	    emp.setName("Sneha");
	    emp.setSalary(40000);
		
	    
	    dao.saveEmployee(emp);
	}   
    
}
