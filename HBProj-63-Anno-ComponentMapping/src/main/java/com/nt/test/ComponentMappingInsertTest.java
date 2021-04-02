package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class ComponentMappingInsertTest {

	public static void main(String[] args) {
		
		Transaction tx=null;
		try(Session ses= HibernateUtil.getSession()){
			 //prepare object
			Person per=new Person("Rock", new JobDetails("IT","Auskeny",115000.0f));
			//begin Tx
			tx=ses.beginTransaction();
			  int idval=(int) ses.save(per);
			tx.commit();
			System.out.println("object is  saved with idVal:: "+idval);
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
				tx.rollback();
		}
	}

}
