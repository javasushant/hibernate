package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTestRefresh4 {

	public static void main(String[] args) {
		//get Session obj
		Session ses=HibernateUtil.openSession();
		
	
		try {
			//Load object
			Actor actor= ses.get(Actor.class, 1);
			System.out.println(actor);
			System.out.println("===============================================");
			Thread.sleep(40000);
			ses.refresh(actor);
			System.out.println(actor);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//main
		
		
	}//class

}
