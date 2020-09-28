package com.punam.GetVsLoad;

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
    	
    	
    	 Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);
         ServiceRegistry reg = new  StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();  
         SessionFactory sessionFact = config.buildSessionFactory(reg);   
         Session session = sessionFact.openSession();
         
         session.beginTransaction();
         
         //Laptop lap = session.get(Laptop.class,101);  //will fire query immediately
         Laptop lap = session.load(Laptop.class,101);   //will create proxy , Here it will not fire query ..later when obj is used then it will fire
         System.out.println(lap);                        
        
         session.getTransaction().commit();
         
         
        
    }
}

//get will throw NullPointerException , Load will throw ObjectNotFoundException

