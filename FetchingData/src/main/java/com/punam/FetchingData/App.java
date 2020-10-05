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
        
        alien.setAid(103);         
        alien.setAname("Fang Lie");
        alien.setColor("Purple");
        
        Transaction tx2 = session.beginTransaction();  //Transaction 1 
          
        session.save(alien);
       
        tx2.commit();
           
        Transaction tx1 = session.beginTransaction();   //Transaction 2
        
        alien = (AlienFetchData)session.get(AlienFetchData.class, 103);
       
        tx1.commit();
        
        System.out.println(alien);
        session.close();
    }
}
