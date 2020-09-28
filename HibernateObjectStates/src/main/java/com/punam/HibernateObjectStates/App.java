package com.punam.HibernateObjectStates;

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
         
         Laptop l = new Laptop();     //New state
         
         l.setLid(106);              //Transient state
         l.setLname("Lenovo");
         
         session.save(l);            //Persistent state
         
         l.setLname("Sony");        //Will make change in DB
        
        // session.remove(l);     //Will remove obj from db
         
         session.getTransaction().commit();
         
         session.detach(l);        //Detach state
         
         l.setLname("Asus");       ////Will not make change in DB
        
    }
}
