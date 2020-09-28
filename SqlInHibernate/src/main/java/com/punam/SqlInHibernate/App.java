package com.punam.SqlInHibernate;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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
		 * SQLQuery query =
		 * session.createSQLQuery("select *from StudentHqlDemo where marks > 60");
		 * query.addEntity(StudentHqlDemo.class); List<StudentHqlDemo> students =
		 * query.list();
		 * 
		 * for (StudentHqlDemo student : students) { System.out.println(student); }
		 */
        
        //Native Queries
        SQLQuery query = session.createSQLQuery("select name,marks from StudentHqlDemo where marks > 60");
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List  students = query.getResultList();
        
        for (Object student : students) {
        	Map m = (Map)student;
			System.out.println(m.get("name")+" : "+m.get("marks"));
		}
        
        
        
        
       session.getTransaction().commit();
    }
}
