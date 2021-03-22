package com.nt.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		try {
			//bootstrap HB f/w
			Configuration cfg = new Configuration();
			// load and hold the configuration file
			cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
			// create SessionFactory obj on confuguration reference
			factory= cfg.buildSessionFactory();
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//static
	//create session obj on SessionFcatory obj reference
	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses= factory.openSession();
		return ses;
	}//session
	
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
		}//sessionClose
	
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
}
