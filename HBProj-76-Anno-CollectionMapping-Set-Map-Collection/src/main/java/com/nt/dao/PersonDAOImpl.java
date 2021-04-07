package com.nt.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Traveller;
import com.nt.utility.HibernateUtil;

public class PersonDAOImpl implements IPersonDAO {
	Transaction tx=null;
	@Override
	public void saveData() {
		//get TRANSACTION
		
		try(Session ses=HibernateUtil.getSession()){
			tx=ses.beginTransaction();			
			//prepare Objects
			Traveller t=new Traveller();
			t.setTravellerName("Hamsafer");
			t.setDob(LocalDateTime.now());
			t.setNickNames(List.of("Rockey","vickey","Annu","baliram"));
			t.setPhones(Set.of(8881225253L,9771191815L,7484943789L));
			t.setPlaceVisited(Map.of("India","Delhi,Jammu-Kashmir,Uttrakhand","Nepal","Kathmandu,Janakpur"));
			ses.save(t);
			tx.commit();
			System.out.println("Object are Saved");
	}
		catch (Exception e) {
			e.printStackTrace();
			if(tx!=null && tx.getStatus()!=null  && tx.getRollbackOnly()) { 
			      tx.rollback();
			      System.out.println("Problem in saving object");
			}
		}
	}
	/*
	@Override
	public void loadData() {
		try(Session ses=HibernateUtil.getSession()){
			   //prepare and  execute HQL query
			Query query1=ses.createQuery("from Payment");
			List<Payment> list1=query1.getResultList();
			list1.forEach(per->{
				System.out.println(per);
			});
			System.out.println(".....................................");
			Query query2=ses.createQuery("from CardPayment");
			List<CardPayment> list2=query2.getResultList();
			list2.forEach(emp->{
				System.out.println(emp);
			});
			System.out.println(".....................................");
			Query query3=ses.createQuery("from ChequePayment");
			List<ChequePayment> list3=query3.getResultList();
			list3.forEach(cust->{
				System.out.println(cust);
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}
	
   */
	
}
