package com.punam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.punam.model.Person;

@Transactional(readOnly = false)
public class PersonDaoImpl implements PersonDao {
	
	private HibernateTemplate 	template;		

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public void save(Person p) {
		
		template.save(p);
		
	}

	@Override
	public List<Person> list() {
		
		/*
		 * Session session = this.sessionFactory.openSession(); List<Person> personList
		 * = session.createQuery("from person").list(); session.close(); return
		 * personList;
		 */
		return null;
	}

}
