package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.CallerTune;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Transaction tx= null;
		//getSession obj
		try(Session ses= HibernateUtil.openSession() ){
			tx= ses.beginTransaction();
			CallerTune tune= ses.get(CallerTune.class, 1);
			tune.setCallerTune("Fk the busturd");
			tune.setMobileNo(9771191815L);
			tx.commit();
			System.out.println("Object is updated for "+tune.getChangeCount()+" times");
		}
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
	}

}

