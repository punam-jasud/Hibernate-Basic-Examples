package com.punam.OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class App 
{
    public static void main( String[] args )
    {
    	
    	Laptop laptop = new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("Dell");
    	
    	Student stud = new Student();
    	stud.setRollno(1);
    	stud.setName("Punam");
    	stud.setMarks(50);
    	stud.setLatop(laptop);
   
    	
    	 Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
         ServiceRegistry reg = new  StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();  
         SessionFactory sessionFact = config.buildSessionFactory(reg);   
         Session session = sessionFact.openSession();
         
         Transaction tx = session.beginTransaction();
         
         session.save(stud);
         session.save(laptop);
        
         tx.commit();
        
    }
}
