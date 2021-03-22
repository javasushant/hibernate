package com.nt.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
//import org.hibernate.query.Query;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NativeNON_SELECTQueryTest {

	public static void main(String[] args) {
		Transaction tx=null;
		try(Session ses= HibernateUtil.getSession()){
			tx=ses.beginTransaction();
//			NativeQuery query =ses.createSQLQuery("UPDATE HQL_EMPLOYEE SET SALARY=(SALARY*0.5) WHERE EADD=:addrs");
//			query.setParameter("addrs", "SOJ");
			
			NativeQuery query = ses.createSQLQuery("INSERT INTO HQL_EMPLOYEE VALUES(:val1,:val2,:val3,:val4)");
			query.setParameter("val1", 9001);
			query.setParameter("val2", "ROCKEY");
			query.setParameter("val3", "NAM");
			query.setParameter("val4", 115000.0f);
			int count= query.executeUpdate();
			System.out.println("no of records that are updated :: "+count );
			tx.commit();
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
			tx.commit();
		}
	}

}
