package com.punam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.punam.dao.PersonDao;
import com.punam.model.Person;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		PersonDao personDao = (PersonDao)context.getBean("personDAO");
		
		Person person = new Person();
		person.setId(241);
		person.setName("Punam");
		person.setCountry("US");
		
		personDao.save(person);
		
		System.out.println("saved successfully");

	}

}
