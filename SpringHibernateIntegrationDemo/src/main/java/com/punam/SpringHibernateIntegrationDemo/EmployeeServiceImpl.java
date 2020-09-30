package com.punam.SpringHibernateIntegrationDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
    EmployeeDAO employeeDAO;
     
    @Transactional	
	public void persistEmployee(Employee employee) {
    	employeeDAO.persistEmployee(employee);	
	}

    @Transactional
	public Employee findEmployeeById(String id) {
    	return employeeDAO.findEmployeeById(id); 
	}
    
    @Transactional
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
		
	}
	@Transactional
	public void deleteEmployee(Employee employee) {
		
	    employeeDAO.deleteEmployee(employee);
		
	}
 
    
 
}
