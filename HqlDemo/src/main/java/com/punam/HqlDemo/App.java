package com.punam.HqlDemo;

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
		 * Random r = new Random();
		 * 
		 * for (int i = 1; i <= 50; i++) { StudentHqlDemo s = new StudentHqlDemo();
		 * s.setName("Name "+i); s.setRollno(i); s.setMarks(r.nextInt(100));
		 * session.save(s); }
		 */
		
        
        Query q = session.createQuery("from StudentHqlDemo where rollno = 7");
        StudentHqlDemo stud  = (StudentHqlDemo) q.uniqueResult();
        System.out.println(stud);
        
       // q = session.createQuery("from StudentHqlDemo");
        q = session.createQuery("from StudentHqlDemo where marks > 50");
        List<StudentHqlDemo> students = q.list();
        
        for (StudentHqlDemo student : students) {
			System.out.println(student);
		}
        
       session.getTransaction().commit();
    }
}
