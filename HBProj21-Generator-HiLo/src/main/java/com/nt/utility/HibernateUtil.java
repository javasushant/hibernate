package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		//Bootstrap the hibernate obj
		Configuration cfg = new Configuration();
		//load and hold the Cfg file 
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//create Sessionfactory obj
		factory = cfg.buildSessionFactory();
		
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
