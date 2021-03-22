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
		
		Session ses=threadLocal.get();
		if(ses==null) {
			if(factory!=null)
				ses= factory.openSession();
				threadLocal.set(ses);
		}//if
		return ses;
	}

	public static void closeSession(Session ses) {
		Session ses1 = threadLocal.get();
		
		if (ses1 != null)
			ses1.close();
			threadLocal.remove();
	}

	public static void closeSessionFactory() {
		if (factory != null)
			factory.close();
	}
}
