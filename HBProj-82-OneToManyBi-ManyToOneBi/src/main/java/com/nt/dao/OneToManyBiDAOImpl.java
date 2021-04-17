package com.nt.dao;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Owner;
import com.nt.entity.Vehicle;
import com.nt.utility.HibernateUtil;

public class OneToManyBiDAOImpl implements OneToManyBiDAO {

	@Override
	public void saveDataUsingParents() {
		//get Session
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//prepare Object (Parent)
			Owner o1= new Owner("Rockey", "Namapur");
			Owner o2= new Owner("Sushant", "SPJ");
			Vehicle v1=new Vehicle("Scorpio", "Mahindra");
			Vehicle v2=new Vehicle("Vagnor", "Maruti");
			Vehicle v3=new Vehicle("Inova", "Toyota");
			Vehicle v4=new Vehicle("Civic", "Huindai");
			//set  parent to child
			v1.setOwner(o1);
			v2.setOwner(o1);
			v3.setOwner(o2);
			v4.setOwner(o2);
			//set childs to parent
			Set<Vehicle> childs=new HashSet();
			childs.add(v1);
			childs.add(v2);
			childs.add(v3);
			childs.add(v4);
			o1.setVehicles(childs);
			
			//begin transaction
			tx=ses.beginTransaction();
			ses.save(o1);
			tx.commit();
			System.out.println("Parent and child objects are saved (parent to child)");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				 System.out.println("Objects are not saved (child to parent)");
			}//if
		}//catch
	}//saveData

	@Override
	public void saveDataUsingChild() {
		//get Session
				Transaction tx=null;
				try(Session ses=HibernateUtil.getSession()){
					//prepare Object (Parent)
					Owner o1= new Owner("Sushant", "Delhi");
//					Owner o2= new Owner("Sushant", "SPJ");
					Vehicle v1=new Vehicle("Fortuner", "TOYOTA");
					Vehicle v2=new Vehicle("BENZ", "BMW");
					
					//set  parent to child
					v1.setOwner(o1);
					v2.setOwner(o1);
					
					//set childs to parent
					Set<Vehicle> childs=new HashSet();
					childs.add(v1);
					childs.add(v2);
					
					o1.setVehicles(childs);
					
					//begin transaction
					tx=ses.beginTransaction();
					ses.save(v1);
					ses.save(v2);
					tx.commit();
					System.out.println("Parent and child objects are saved (parent to child)");
				}//try
				catch(HibernateException he) {
					he.printStackTrace();
					if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
						tx.rollback();
						 System.out.println("Objects are not saved (child to parent)");
					}//if
				}//catch
		
	}

	@Override
	public void loadDataUsingParents() {
		
		try(Session ses=HibernateUtil.getSession()){
			Query query=ses.createQuery("FROM Owner");
			List<Owner> o1=query.getResultList();
			o1.forEach(row->{
				System.out.println("Parent "+row);
				Set<Vehicle> v1=row.getVehicles();
				v1.forEach(row1->{
					System.out.println("Child "+row1);
				});
			});
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

	
}//class
