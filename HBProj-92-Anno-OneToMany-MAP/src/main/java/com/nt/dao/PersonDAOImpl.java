package com.nt.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class PersonDAOImpl implements IPersonDAO {

	@Override
	public void insertData() {
		//Transaction 
		Transaction tx=null;
		try (Session ses=HibernateUtil.getSession()){
			//get CHild obj
			Map<String,BankAccount> accounts =Map.of("Personal Acount",new BankAccount("Saving", "SBI", 110000.0),"Salary Acount",
																			new BankAccount("Saving", "SBH", 115550.0));
			Person per1=new Person("Sushant", "Namapur", accounts);
			//begin transaction to disabled auto commit 
			tx=ses.beginTransaction();
			ses.save(per1);
			tx.commit();
			System.out.println("Object is saved");
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		
	}
	
	@Override
	public void loadData() {
		try (Session ses=HibernateUtil.getSession()){
			Query query=ses.createQuery("from Person");
			List<Person> list=query.getResultList();
			list.forEach(per->{
				System.out.println("Person Details ::  "+per);
				Map<String,BankAccount> child=per.getAccounts();
				System.out.println(child.size());
//				child.forEach(ba->{
//					System.out.println("child details :: "+ba);
//				});
				
			});
		}
		catch (HibernateException he) {
			he.printStackTrace();
		}
		
	}
/*
	@Override
	public void deleteDataUsingParent() {
		Transaction tx=null;
		try (Session ses=HibernateUtil.getSession()){
			//LOAD PARENT OBJ
			Person per = ses.get(Person.class,213 );
			//begin tx
			tx=ses.beginTransaction();
			//delete obj
			ses.delete(per);
			tx.commit();
			System.out.println("Parent and Associated child are deleted");
		}
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}
		
	}

	@Override
	public void deleteOnlyChildOfParent() {
		Transaction tx=null;
		try (Session ses=HibernateUtil.getSession()){
			//load paremt Object
			Person per=ses.get(Person.class, 224);
			//get childs of a object
			Set<BankAccount> child=per.getAccounts();
			//beign transaction
			tx=ses.beginTransaction();
			//delete child object
			child.clear();
			tx.commit();
			System.out.println("All child of a parent are deleted");
		}
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}
		
	}

	@Override
	public void deleteOneChildFromCollectionChildBelongingToParent() {
		Transaction tx=null;
		try (Session ses=HibernateUtil.getSession()){
			//load paremt Object
			Person per=ses.get(Person.class, 233);
			//get childs of a object
			Set<BankAccount> child=per.getAccounts();
			BankAccount acount=ses.get(BankAccount.class, 234L);
			//beign transaction
			tx=ses.beginTransaction();
			//delete child
			child.remove(acount);
			tx.commit();
			System.out.println("Associated child of a parent is deleted");
		}
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}
	}

	@Override
	public void addNewChildForExistingParent() {
		Transaction tx=null;
		try (Session ses=HibernateUtil.getSession()){
			//load paremt Object
			Person per=ses.get(Person.class, 227);
			//get childs of a object
			Set<BankAccount> child=per.getAccounts();
			//create new Child obj
			BankAccount acount= new BankAccount("Currrent", "PNB", 55555555.0);
			//begin transaction
			tx=ses.beginTransaction();
			child.add(acount);
			tx.commit();
			System.out.println("New child is added to existing Parent");
			
			
		}
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null )
				tx.rollback();
		}
	}

	@Override
	public void TransferChildFromOneParentToAnotherParent() {
		Transaction tx=null;
		try (Session ses=HibernateUtil.getSession()){
			//load paremt Object
			Person per=ses.get(Person.class, 227);
			//get all childs of a object
			Set<BankAccount> child=per.getAccounts();
			
			//load paremt2 Object
			Person per2=ses.get(Person.class, 230);
			//get all childs of a object
			Set<BankAccount> child2=per2.getAccounts();
			//Load that child from DB s/w which want to transfer
			BankAccount acount =ses.get(BankAccount.class, 235L);
			//begin tx
			tx=ses.beginTransaction();
			child.add(acount);
			tx.commit();
			Transaction tx1=ses.beginTransaction();
			child2.remove(acount);
			tx.commit();
			System.out.println("Child record is transfered");
			
			
		}
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null )
				tx.rollback();
		}
	}
	*/

}
