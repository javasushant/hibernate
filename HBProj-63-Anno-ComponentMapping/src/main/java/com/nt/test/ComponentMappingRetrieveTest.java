package com.nt.test;


import java.util.List;

import javax.persistence.Query;

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
//			Person per=ses.get(Person.class, 2);
//			//begin Tx
//			System.out.println("object Details are as follows :: "+per);
			
			/* HQL Query*/
			/*
			Query query= ses.createQuery("FROM Person");
			List<Person> list=query.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});
			*/
			Query query=ses.createQuery("SELECT pname FROM Person WHERE pid=:id ");
			query.setParameter("id", 2);
			List<Object> list=query.getResultList();
			list.forEach(row->{
				
					System.out.println(row);
				
			});
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
