package com.nt.test;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Actor;
import com.nt.utils.HibernateUtil;

public class SaveObjectTest {
	public static void main(String[] args) {
		System.out.println("SaveObjectTest.main()");
		//get session obj
		Session ses = HibernateUtil.getSession();
		//prepare Entity class object
		Actor actor = new Actor();
		actor.setActorid(110); actor.setActorName("Vicky");
		actor.setActorAddrs("SPJ"); 
		actor.setPhone(88888);
		actor.setRenumeration(50055);
		org.hibernate.Transaction tx = null;
		boolean flag = false;
		try {
			//begin tx
			tx = ses.beginTransaction();//internally calls con.setAutoCommit(false)
	
			ses.save(actor);
			flag = true;
		}//try
		catch(HibernateException he) {
			flag = false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();  //internally calls con.commit() method
				System.out.println("Object is saved -- object data is inserted to Db");
				
			}
			else {
				tx.rollback(); 
				System.out.println("Object is not saved -- Object data is not inserted to Db ");
			}
			//close sssion obj (Connection closing)
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//clas
