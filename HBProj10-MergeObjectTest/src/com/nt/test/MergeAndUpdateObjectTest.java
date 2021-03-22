package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class MergeAndUpdateObjectTest {

	public static void main(String[] args) {
		//get Session obj
		Session ses=HibernateUtil.openSession();
		Transaction tx =null;
		boolean flag=false;
		try {
			//begin tx
			tx=ses.beginTransaction();
			//full object modification
			Actor actor1 = ses.get(Actor.class, 4);
			if(actor1!=null)
				System.out.println(actor1);
//			 Load object twice 
			Actor actor = new Actor();
			actor.setActorid(4);
			actor.setActorName("Bull");
			actor.setActorAddrs("Ghar");
			actor.setPhone(977000L);
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
				System.out.println("Object is Merged / saved");
			}
			else {
				tx.rollback();
				System.out.println("Object is not Merged / saved");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//main
		
	}//class

}
