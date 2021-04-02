package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.CardPayment;
import com.nt.entity.ChequePayment;
import com.nt.entity.Payment;
import com.nt.utility.HibernateUtil;

public class PersonDAOImpl implements IPersonDAO {
	Transaction tx=null;
	@Override
	public void saveData() {
		//get TRANSACTION
		
		try(Session ses=HibernateUtil.getSession()){
			tx=ses.beginTransaction();			
			//CardPayment obj
			CardPayment card=new CardPayment();
			card.setAmount(1100000.0);
			card.setCardNo(32137265126L);
			card.setCardType("Credit card");
			card.setGateway("Maestro");
			
			//ChequePAYMENT obj
			ChequePayment chq=new ChequePayment();
			chq.setAmount(1555555.5);
			chq.setChequeNo(9771191815L);
			chq.setChequeType("Business acount");
			
			//saving the Object
			int idVal1=(int) ses.save(card);
			int idVal2=(int) ses.save(chq);
			
			System.out.println("Object /Result has been saved "+idVal1+"  "+idVal2);
			
			
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
	

	
}
