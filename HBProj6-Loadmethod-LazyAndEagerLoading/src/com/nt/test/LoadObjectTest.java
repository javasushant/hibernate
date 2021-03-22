package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		
		//get session obj
		Session ses= HibernateUtil.openSession();
		
		try {
			Actor actor =ses.load(Actor.class, 1);
//			System.out.println(actor);
			System.out.println(actor.getClass()+" "+actor.getClass().getSimpleName());
		}
		catch(Exception he) {
			System.out.println("Object Not found ");
			he.printStackTrace();
		}
		finally{
			//close session obj(Connection closing)
			HibernateUtil.closeSession(ses);
			//close sessionfactory obj
			HibernateUtil.closeSessionFactory();
		}
	}

}
