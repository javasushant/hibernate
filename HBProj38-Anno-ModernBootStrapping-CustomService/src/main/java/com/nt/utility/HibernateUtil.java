package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.nt.service.ApacheDBCP2ConnectionProviderService;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		//Bootstrap the hibernate obj
		Configuration cfg = new Configuration();
		// build service registrry
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		// add service to builer
		builder.addService(ConnectionProvider.class,new ApacheDBCP2ConnectionProviderService() );
		//make service registry
		StandardServiceRegistry registry = builder.configure("com/nt/cfgs/hibernate.cfg.xml").build();
		//create Sessionfactory obj
		factory = cfg.buildSessionFactory(registry);
		
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

