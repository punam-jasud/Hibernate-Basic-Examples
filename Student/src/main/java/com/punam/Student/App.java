package com.punam.Student;

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
		/*
		 * StudentName name = new StudentName(); name.setFname("Punam");
		 * name.setMname("Jalindar"); name.setLname("Jasud");
		 */
    	 Stud stud = new Stud();
    	 Laptop laptop = new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("Dell");
    	//laptop.setStudent(stud);
    	laptop.getStudent().add(stud);
    	
      
       
       stud.setId(1);
       stud.setName("Sahil");
       stud.setMarks(30);
       stud.getLaptop().add(laptop);
       
       Configuration config = new Configuration().configure().addAnnotatedClass(Stud.class).addAnnotatedClass(Laptop.class);
       ServiceRegistry reg = new  StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();  
       SessionFactory sessionFact = config.buildSessionFactory(reg);   
       Session session = sessionFact.openSession();
       
       Transaction tx = session.beginTransaction();
       
       session.save(laptop);
       session.save(stud);
       
       //stud = (Stud)session.get(Stud.class, 100);
       
       tx.commit();
       System.out.println(laptop);
       System.out.println(stud);
       	
    }
}
