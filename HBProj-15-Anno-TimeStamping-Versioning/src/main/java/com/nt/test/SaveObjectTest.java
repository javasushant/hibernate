package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.CallerTune;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		Transaction tx= null;
		//getSession obj
		try(Session ses= HibernateUtil.openSession() ){
			tx= ses.beginTransaction();
			//save Obj
			CallerTune tune=new CallerTune();
			tune.setCallerTune("Fan of   india");
			tune.setMobileNo(8881225253L);
			tune.setProvider("Airtel");
			int idVal = (int)ses.save(tune);
			tx.commit();
			System.out.println("Object is Saved "+idVal);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			System.out.println("Object is not save ");
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("Object is not save ");
		}
	}//main

}//class
