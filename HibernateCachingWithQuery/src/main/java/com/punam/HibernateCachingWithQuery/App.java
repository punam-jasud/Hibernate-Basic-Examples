package com.punam.HibernateCachingWithQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        Query q1 = session1.createQuery("from Alien where aid=101");
        q1.setCacheable(true);
        alien = (Alien)q1.uniqueResult();      
        System.out.println(alien);
       
        session1.getTransaction().commit();
        session1.close();
        
        
        Session session2 = sessionFact.openSession();
        
        session2.beginTransaction();
        Query q2 = session2.createQuery("from Alien where aid=101");
        q2.setCacheable(true);					
        alien = (Alien)q2.uniqueResult();    //will fetch from second level cache because this query is already cached in session1
        System.out.println(alien);
       
        session2.getTransaction().commit();
        session2.close();
        
        
    }
}
