package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.secure.internal.StandardJaccServiceImpl;

import com.nt.entity.Programmer_Project;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		//Bootstrap the hibernate obj
		Configuration cfg = new Configuration();
		/*
		 *------       1st method
		 * cfg.configure("com/nt/cfgs/hibernate.cfg.xml"); 
		 * //add mapping annotation
		 * cfg.addAnnotatedClass(Programmer_Project.class); 
		 * //bootstrapping builder
		 * StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder(); 
		 * //Resitry service 
		 * StandardServiceRegistry registery =builder.applySettings(cfg.getProperties()).build(); 
		 * //load and hold the Cfg file
		//create Sessionfactory obj
		factory = cfg.buildSessionFactory(registery);
		
		*/
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder(); 
		StandardServiceRegistry registery =builder.configure("/com/nt/cfgs/hibernate.cfg.xm").build();
		factory = cfg.buildSessionFactory(registery);
	}
	
	public static Session openSession() {
		Session ses=null;
		if(factory!=null)
			ses= factory.openSession();
		return ses;
	}
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
}
