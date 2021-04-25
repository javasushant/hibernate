package com.nt.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.LibraryMembership;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class OneToOnePKDAOImpl implements OneToOnePKDAO {

	@Override
	public void saveDataUsingCHild() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//making the Person object
			Student s1=new Student("Rockey", "Namapur", LocalDateTime.of(1993, 9, 30, 4, 34)); 
			Student s2=new Student("Vicky", "Namapur", LocalDateTime.of(1990, 6, 2, 4, 34)); 
			//make a DrivingLicence class object
			LibraryMembership l1=new LibraryMembership("1-person", "RTO", LocalDateTime.now(), LocalDateTime.of(2041, 4, 24, 12, 15));
			LibraryMembership l2=new LibraryMembership("2-person", "RTO", LocalDateTime.now(), LocalDateTime.of(2030, 4, 24, 12, 15));
			//set special property into Student
			s1.setLibraryDetails(l1);
			s2.setLibraryDetails(l2);
			//set special property into LibraryMembership
			l1.setStudentDetails(s1);
			l2.setStudentDetails(s2);
			//begin transaction 
			tx=ses.beginTransaction();
			//save the object using child ref
			ses.save(s1);
			ses.save(s2);
			tx.commit();
			System.out.println("Object is saved using child ref");
			
		}
		catch (HibernateException  he) {
			he.printStackTrace();
			if(tx!=null || tx.getRollbackOnly() ) {
				tx.rollback();
			}
			System.out.println("object is not saved");
		}
		
	}

	@Override
	public void loadDataUsingCHild() {
		try(Session ses=HibernateUtil.getSession()){
			Query<LibraryMembership> query=ses.createQuery("from LibraryMembership");
			List<LibraryMembership> lib=query.getResultList();
			lib.forEach(l->{
				System.out.println(l);
				Student s=l.getStudentDetails();
				System.out.println(s);
			});
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}

//	@Override
	public void deleteDataUsingCHild() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			LibraryMembership l=ses.get(LibraryMembership.class, 340);
			//begin transction
			tx=ses.beginTransaction();
			ses.delete(l);
			tx.commit();
			System.out.println("Object is deleted from both table");
		}
		catch (HibernateException  he) {
			he.printStackTrace();
			if(tx!=null || tx.getRollbackOnly() ) {
				tx.rollback();
			}
			System.out.println("object is not deleted ");
		}
		
	}

	

	
	
}
