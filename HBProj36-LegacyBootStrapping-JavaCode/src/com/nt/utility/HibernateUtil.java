package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		try {
			// configure HB cfg
			Configuration cfg = new Configuration();
			cfg.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
			cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:SYS");
			cfg.setProperty("hibernate.connection.username", "system");
			cfg.setProperty("hibernate.connection.password", "manager");
			
			cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
			cfg.setProperty("hibernate.hbm2ddl.auto", "update");
			cfg.setProperty("hibernate.show_sql", "true");
			cfg.setProperty("hibernate.format_sql", "true");
			cfg.addFile("src/com/nt/entity/Actor.hbm.xml");
			// load the configuration file
//			cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
			// build sessionFcatory
			factory = cfg.buildSessionFactory();
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
