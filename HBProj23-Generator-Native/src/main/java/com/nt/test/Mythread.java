package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class Mythread extends Thread {
	Transaction tx= null;
	@Override
	public void run() {
		try(Session ses=HibernateUtil.openSession()){
			tx=ses.beginTransaction();
			//full object modification
			Actor actor = new Actor();
			actor.setActorid(320);
			actor.setActorName("Pulled");
			actor.setActorAddrs("Ghar");
			actor.setPhone(977000L);
			actor.setRenumeration(50000f);
			int idval =(int) ses.save(actor);
			System.out.println("Object is Saved And id value "+idval);
			tx.commit();
		}//try
		catch(HibernateException he) {
			System.out.println("Save object is not updated");
			he.printStackTrace();
			tx.rollback();
		}
		catch(Exception e) {
			System.out.println("Save object is not updated");
			e.printStackTrace();
			tx.rollback();
		}
	}//mythread
}//class
