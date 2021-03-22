package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class SaveMoreObjectTest {

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
			actor.setActorid(320);
			actor.setActorName("Pulled");
			actor.setActorAddrs("Ghar");
			actor.setPhone(977000L);
			actor.setRenumeration(50000f);
			
			Actor actor1 = new Actor();
			actor1.setActorid(320);
			actor1.setActorName("Pulled");
			actor1.setActorAddrs("Ghar");
			actor1.setPhone(977000L);
			actor1.setRenumeration(50000f);
			int idval =(int) ses.save(actor);
			int idval1 =(int) ses.save(actor1);
			System.out.println("id value "+idval);
			System.out.println("id value "+idval1);
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
				System.out.println("Object is saved");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//main
		
	}//class

}
