package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest3 {

	public static void main(String[] args) {
		//get Session obj
		Session ses=HibernateUtil.openSession();
		Actor actor= ses.get(Actor.class, 1);
		if(actor!=null) {
			System.out.println(actor);
		Transaction tx =null;
		boolean flag=false;
		try {
			//begin tx
			tx=ses.beginTransaction();
			//full object modification
			actor.setActorAddrs("SPJ");
			actor.setRenumeration(5166f);
			flag=true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is Updated");
			}
			else {
				tx.rollback();
				System.out.println("Object is not Updated");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//main
		}//if
		else {
			System.out.println("Object is not Found");
			//close stream
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		
	}//class

}
