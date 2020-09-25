package com.punam.EagerFetchTechnique;

import java.util.Collection;

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
       
        
        Configuration config = new Configuration().configure().addAnnotatedClass(AlienEager.class).addAnnotatedClass(LaptopEagar.class);
        ServiceRegistry reg = new  StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();  
        SessionFactory sessionFact = config.buildSessionFactory(reg);   
        Session session = sessionFact.openSession();
        
        Transaction tx = session.beginTransaction();
        
        AlienEager a1 = session.get(AlienEager.class, 101);
        
		
        
		  System.out.println(a1.getAname());
		  
			/*
			 * Collection<LaptopEagar> laps = a1.getLaps(); for (LaptopEagar laptopEagar :
			 * laps) { System.out.println(laptopEagar); }
			 */
		 
      
        tx.commit();
    }
}