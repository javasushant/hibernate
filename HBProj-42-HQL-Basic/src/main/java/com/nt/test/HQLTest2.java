package com.nt.test;


import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class HQLTest2 {

	public static void main(String[] args) {
		Transaction tx=null;
		try(Session ses= HibernateUtil.getSession()){
			tx=ses.beginTransaction();
			Query query= ses.createQuery("update Employee set salary=salary+:bonus where salary<=:range");
			query.setParameter("bonus", 10000.0f);
			query.setParameter("range", 60000.0f);
			int count = query.executeUpdate();
			System.out.println("No of records are inserted is ::"+count);
			tx.commit();
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()==true)
			tx.rollback();
		}
	}

}
