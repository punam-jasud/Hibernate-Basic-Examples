package com.punam.FetchingData;

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
    	AlienFetchData alien = new AlienFetchData();
    	
        Configuration config = new Configuration().configure().addAnnotatedClass(AlienFetchData.class);
        ServiceRegistry reg = new  StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();  
        SessionFactory sessionFact = config.buildSessionFactory(reg);   
        Session session = sessionFact.openSession();
        
        Transaction tx = session.beginTransaction();
        
        alien = (AlienFetchData)session.get(AlienFetchData.class, 102);
       
        tx.commit();
        
        System.out.println(alien);
    }
}
