package com.punam.ManyToMany;

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
    	
    	Laptop laptop1 = new Laptop();
    	Laptop laptop2 = new Laptop();
    	Student stud = new Student();
    	Student stud1 = new Student();
    	
    	laptop1.setLid(101);
    	laptop1.setLname("Dell");
    	laptop1.getStudent().add(stud);
    	laptop1.getStudent().add(stud1);
    	
    	laptop2.setLid(102);
    	laptop2.setLname("HP");
    	laptop2.getStudent().add(stud);
    	
    	
    	stud.setRollno(1);
    	stud.setName("Punam");
    	stud.setMarks(50);
    	stud.getLatop().add(laptop1);
    	stud.getLatop().add(laptop2);
   
    	
    	stud1.setRollno(2);
    	stud1.setName("Sneha");
    	stud1.setMarks(30);
    	stud1.getLatop().add(laptop1);
    	
    	 Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
         ServiceRegistry reg = new  StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();  
         SessionFactory sessionFact = config.buildSessionFactory(reg);   
         Session session = sessionFact.openSession();
         
         Transaction tx = session.beginTransaction();
         
         session.save(stud);
         session.save(stud1);
         session.save(laptop1);
         session.save(laptop2);
        
         tx.commit();
        
    }
}
