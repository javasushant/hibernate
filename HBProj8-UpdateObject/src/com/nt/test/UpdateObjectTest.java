package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest {

	public static void main(String[] args) {
		//get Session obj
		Session ses=HibernateUtil.openSession();
		Transaction tx =null;
		boolean flag=false;
		try {
			//begin tx
			tx=ses.beginTransaction();
			//full object modification
			Actor actor = new Actor();
			actor.setActorid(1);
			actor.setActorName("BOLBAM");
			actor.setActorAddrs("Kailash");
			actor.setPhone(97711918L);
			actor.setRenumeration(50000f);
			ses.update(actor);
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
		
	}//class

}
