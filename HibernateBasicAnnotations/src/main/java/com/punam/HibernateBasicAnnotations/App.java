package com.punam.HibernateBasicAnnotations;

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
        AlienAnnotations alien1 = new AlienAnnotations();
        alien1.setAid(101);
        alien1.setAname("Punam");
        alien1.setColor("Green");
        
        AlienAnnotations alien2 = new AlienAnnotations();
        alien2.setAid(102);
        alien2.setAname("Sneha");
        alien2.setColor("White");
        
        Configuration config = new Configuration().configure().addAnnotatedClass(AlienAnnotations.class);
        ServiceRegistry reg = new  StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();  
        SessionFactory sessionFact = config.buildSessionFactory(reg);   
        Session session = sessionFact.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(alien1);
        session.save(alien2);
       
        tx.commit();
    }
}
