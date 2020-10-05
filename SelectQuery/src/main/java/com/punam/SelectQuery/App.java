package com.punam.SelectQuery;

import java.util.List;
import java.util.Random;

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
        
        Configuration config = new Configuration().configure().addAnnotatedClass(StudentHqlDemo.class);
        ServiceRegistry reg = new  StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();  
        SessionFactory sessionFact = config.buildSessionFactory(reg);   
        Session session = sessionFact.openSession();
        
        session.beginTransaction();
         
		/*
		 * Query q = session.
		 * createQuery("select rollno,name,marks from StudentHqlDemo where rollno = 7");
		 * Object[] stud = (Object[]) q.uniqueResult();
		 * System.out.println(stud[0]+" : "+stud[1]+" : "+stud[2]);
		 */
        
       // Query q = session.createQuery("select rollno,name,marks from StudentHqlDemo");
        //Query q = session.createQuery("select rollno,name,marks from StudentHqlDemo where marks > 60");
        Query q = session.createQuery("select rollno,name,marks from StudentHqlDemo s where s.marks > 60");
        List<Object[]> stud  = (List<Object[]>) q.list();
        
        for (Object[] objects : stud) {
        	System.out.println(objects[0]+" : "+objects[1]+" : "+objects[2]);
		}
      
       // Query q1 = session.createQuery("select sum(marks) from StudentHqlDemo s where s.marks > 60");
        int b = 60;
        Query q1 = session.createQuery("select sum(marks) from StudentHqlDemo s where s.marks > : b");
        q1.setParameter("b",b);
        Long sum = (Long)q1.uniqueResult();
        System.out.println("Sum : "+sum);
      
       session.getTransaction().commit();
       session.close();
    }
}
