package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		//get Session obj
		Transaction tx =null;
		try (Session ses=HibernateUtil.openSession()){
			//begin tx
			tx=ses.beginTransaction();
			//full object modification
			Actor actor = new Actor();
//			actor.setActorid(111);
			actor.setActorName("Pulled");
			actor.setActorAddrs("Ghar");
			actor.setPhone(977000L);
			actor.setRenumeration(50000f);
			int idval =(int) ses.save(actor);
			System.out.println("Gathered id value "+idval);
			tx.commit();
			System.out.println("Saved id value "+idval);
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			System.out.println("Object is not saved");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Object is not saved");
		}
		
	}//main
		
}//class


