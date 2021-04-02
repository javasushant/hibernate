package com.nt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class PersonDAOImpl implements IPersonDAO {

	@Override
	public void saveData() {
		//get TRANSACTION
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			tx=ses.beginTransaction();			
			//Person obj
			Person per=new Person("vicky","SPJ","IBM");
			
			Employee emp=new Employee(15000.0f,"it",150);
			emp.setPname("PRASHHANT"); emp.setPadd("DDP");emp.setCompany("Auskeny");
			
			Customer cust=new Customer(6110.0f,610.56f);
			cust.setPname("ANNU");cust.setPadd("NMP"); cust.setCompany("SCHOOL");
			
			//save object
			ses.save(cust);
			ses.save(emp);
			ses.save(per);
			System.out.println("Object is are saved");
			tx.commit();
	}
		catch (Exception e) {
			e.printStackTrace();
			if(tx!=null && tx.getStatus()!=null  && tx.getRollbackOnly()) { 
			      tx.rollback();
			      System.out.println("Problem in saving object");
			}
		}
	}

	@Override
	public void loadData() {
		try(Session ses=HibernateUtil.getSession()){
			   //prepare and  execute HQL query
			Query query1=ses.createQuery("from Person");
			List<Person> list1=query1.getResultList();
			list1.forEach(per->{
				System.out.println(per);
			});
			System.out.println(".....................................");
			Query query2=ses.createQuery("from Employee");
			List<Employee> list2=query2.getResultList();
			list2.forEach(emp->{
				System.out.println(emp);
			});
			System.out.println(".....................................");
			Query query3=ses.createQuery("from Customer");
			List<Customer> list3=query3.getResultList();
			list3.forEach(cust->{
				System.out.println(cust);
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}
}
