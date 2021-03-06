package com.punam.EmbeddabbleObject;

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
    	AlienEmbeddable alien = new AlienEmbeddable();
    	AlienName name = new AlienName();
    	
    	name.setFname("Punam");
    	name.setMname("Jalindar");
    	name.setLname("Jasud");
    	
        alien.setAid(101);
        alien.setAname(name);
        alien.setColor("Green");
        
        Configuration config = new Configuration().configure().addAnnotatedClass(AlienEmbeddable.class);
        ServiceRegistry reg = new  StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();  
        SessionFactory sessionFact = config.buildSessionFactory(reg);   
        Session session = sessionFact.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(alien);
        
       
        tx.commit();
        System.out.println(alien);
    }
}
