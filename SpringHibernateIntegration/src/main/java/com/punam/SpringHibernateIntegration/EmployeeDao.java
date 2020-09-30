package com.punam.SpringHibernateIntegration;

import java.util.ArrayList;
import java.util.List;



import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = false)
public class EmployeeDao {

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	// save employee object

	public void saveEmployee(Employee e) {
		template.save(e);
	}

	// update employee object
	public void updateEmployee(Employee e) {
		template.update(e);
	}

	// delete employee object
	public void deleteEmployee(Employee e) {
		template.delete(e);
	}

	// Return employee object of given Id
	public Employee getById(int id) {
		Employee e = template.get(Employee.class, id);
		return e;
	}
	
	//Return all employees
	public List<Employee> getEmployees(){
		List<Employee> list = new ArrayList<Employee>();
		list = template.loadAll(Employee.class);
		return list;
	}
}
