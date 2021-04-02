package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		try {
			// configure HB cfg
			Configuration cfg = new Configuration();
		
			//StandardRegistryBuilder
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			//Standard service registry 
			StandardServiceRegistry registry=builder.configure("com/nt/cfgs/hibernate.cfg.xml").build();
			
			// build sessionFcatory
			factory = cfg.buildSessionFactory(registry);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//static block
	
	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
		ses= factory.openSession();
		return ses;
	}
	
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}//close
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
}
