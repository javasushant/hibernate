package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class HQLTest {

	public static void main(String[] args) {
		Transaction tx=null;
		try(Session ses= HibernateUtil.getSession()){
			tx=ses.beginTransaction();
			//get Acccess to named HQL query1 and execute it
			Query query1= ses.getNamedQuery("HQL_GET_EMP_DETAILS");
			//set query param
			query1.setParameter("start", 50000.0f);
			query1.setParameter("end", 200000.0f);
			List<Employee> list =query1.getResultList();
			list.forEach(System.out::println);
			System.out.println("............................");
			Query query2=ses.getNamedQuery("UPDATE_SALARY_BONUS");
			query2.setParameter("bonus", 50000.0f);
			query2.setParameter("addrs", "SOJ");
			int count= query2.executeUpdate();
			tx.commit();
			System.out.println("updte No. "+count);
		}
		catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}
	}

}
