package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class ComponentMappingRetrieveTest {

	public static void main(String[] args) {
		
		try(Session ses= HibernateUtil.getSession()){
			 //prepare object
			Person per=ses.get(Person.class, 2);
			//begin Tx
			System.out.println("object Details are as follows :: "+per);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
