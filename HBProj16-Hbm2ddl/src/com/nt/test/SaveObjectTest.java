package com.nt.test;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Actor;

public class SaveObjectTest {
	public static void main(String[] args) {
		//bootStrapping hibernate (Active DB f/w)
		Configuration cfg = new Configuration();
		//Specify the name and location of HB cfg file (indirectly mpping file)
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//create HB SessionFactory object
		SessionFactory factory = cfg.buildSessionFactory();
		//create HB session Object
		Session ses = factory.openSession();
		//prepare Entity class object
		Actor actor = new Actor();
		actor.setActorid(101); actor.setActorName("Prahant");
		actor.setActorAddrs("DUH"); actor.setPhone(888122);
		actor.setRenumeration(100000);
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
			ses.close();
			factory.close();
		}//finally
	}//main
}//clas
