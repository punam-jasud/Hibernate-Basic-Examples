package com.punam.dao;

import java.util.List;

import com.punam.model.Person;

public interface PersonDao {
	
		public void save(Person p);
		public List<Person> list();

}
