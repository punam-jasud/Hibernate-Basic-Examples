package com.punam.SpringHibernateIntegrationDemo;


import org.springframework.stereotype.Repository;
 
 
@Repository("employeeDAO")
public interface EmployeeDAO {
    
    void persistEmployee(Employee employee);
     
    Employee findEmployeeById(String id);
     
    void updateEmployee(Employee employee);
     
    void deleteEmployee(Employee employee);
     
}
