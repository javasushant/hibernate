package com.nt.test;

import java.util.List;

//import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class HQLInsertTest {

	public static void main(String[] args) {
		Transaction tx=null;
		try(Session ses= HibernateUtil.getSession()){
			tx=ses.beginTransaction();
			Query query=ses.createQuery("insert into NGO_Member(mid,ename,eadd,salary) select e.eid,e.ename,e.eadd,e.salary from Employee as e where e.salary>=:sal");
			query.setParameter("sal", 5000.0f);
			int count= query.executeUpdate();
			System.out.println("No. of records that are transfered :: "+count);
			tx.commit();
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()==true)
				tx.rollback();
		}
	}

}
