package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class HibernateUtil {
	private static SessionFactory factory;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal();
	static {
		// Bootstrap the hibernate obj
		Configuration cfg = new Configuration();
		// build service registrry
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		// make service registry
		StandardServiceRegistry registry = builder.configure("com/nt/cfgs/hibernate.cfg.xml").build();
		// create Sessionfactory obj
		factory = cfg.buildSessionFactory(registry);

	}

	public static Session openSession() {
		Session ses=null;
			if(factory!=null)
//				ses= factory.openSession();
				ses=factory.getCurrentSession();
		return ses;
	}

	public static void closeSession(Session ses) {
		
		if (ses != null)
			ses.close();
	}

	public static void closeSessionFactory() {
		if (factory != null)
			factory.close();
	}
}
