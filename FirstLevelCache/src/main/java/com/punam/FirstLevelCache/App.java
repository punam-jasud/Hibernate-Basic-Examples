package com.punam.FirstLevelCache;

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
        Alien alien = new Alien();
        
        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new  StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();  
        SessionFactory sessionFact = config.buildSessionFactory(reg);   
        
        Session session1 = sessionFact.openSession();
        
        session1.beginTransaction();
        
        alien = (Alien)session1.get(Alien.class, 101);      
        System.out.println(alien);
        
        alien = (Alien)session1.get(Alien.class, 101);      //will take result from first level cache,no query will be fired here
        System.out.println(alien);
       
        session1.getTransaction().commit();
        session1.close();
        
        
        Session session2 = sessionFact.openSession();
        
        session2.beginTransaction();
        
        alien = (Alien)session2.get(Alien.class, 101);      //First Level cache won't work here 
        System.out.println(alien);
       
        session2.getTransaction().commit();
        session2.close();
        
        
    }
}
