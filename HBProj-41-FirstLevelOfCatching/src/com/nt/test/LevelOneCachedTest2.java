package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class LevelOneCachedTest2 {

	public static void main(String[] args) {
		
		//get session obj
		Session ses= HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			tx=ses.beginTransaction();
			Actor actor =ses.get(Actor.class, 66);
			actor.setActorName("Deilip");
			actor.setPhone(8888155L);
			ses.update(actor);
			System.out.println("==============11===============");
			actor.setActorAddrs("SSPPPJJ");
			flag=true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				System.out.println("===========22==========");
				tx.commit();
			}
			else {
				tx.rollback();
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}

}
