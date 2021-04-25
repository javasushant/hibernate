package com.nt.dao;

import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.DrivingLicence;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneFKDAOImpl implements OneToOneFKDAO {

	@Override
	public void saveDataUsingCHild() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//making the Person object
			Person p1=new Person("Rockey", "Namapur", LocalDateTime.of(1993, 9, 30, 4, 34)); 
			Person p2=new Person("Vicky", "Namapur", LocalDateTime.of(1990, 6, 2, 4, 34)); 
			//make a DrivingLicence class object
			DrivingLicence d1=new DrivingLicence("2-wheeler", "RTO", LocalDateTime.now(), LocalDateTime.of(2041, 4, 24, 12, 15));
			DrivingLicence d2=new DrivingLicence("4-wheeler", "RTO", LocalDateTime.now(), LocalDateTime.of(2030, 4, 24, 12, 15));
			//set special property into drivingLicence
			d1.setLicenseHolder(p1);
			d2.setLicenseHolder(p2);
			
			//begin transaction 
			tx=ses.beginTransaction();
			//save the object using child ref
			ses.save(d1);
			ses.save(d2);
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
	
}
