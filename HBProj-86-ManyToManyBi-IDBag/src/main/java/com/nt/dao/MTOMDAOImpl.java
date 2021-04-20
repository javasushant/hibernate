package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.utility.HibernateUtil;

public class MTOMDAOImpl implements MTOMDAO {

	@Override
	public void saveDataUsingParent() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//get Parent obj(DOctor)
			Doctor d1=new Doctor("Abhishek", "KIIMS", "MBBS");
			Doctor d2=new Doctor("Sushant", "PMCH", "MD");
			
			//get Child object
			Patient p1=new Patient("golu", "Namapur", "Fever");
			Patient p2=new Patient("Monu", "SPJ", "Covid");
			Patient p3=new Patient("Baby", "DDP", "cold");
			Patient p4=new Patient("Pintu", "Sormar", "elergy");
			//set special property to doctor
			d1.setPatients(Set.of(p1,p2));
			d2.setPatients(Set.of(p3,p4));
			//set special property to patient
			p1.setDoctors(List.of(d1,d2));
			p2.setDoctors(List.of(d2));
			p3.setDoctors(List.of(d1));
			p4.setDoctors(List.of(d2));
			//begin transaction
			tx=ses.beginTransaction();
			ses.save(d1);
			ses.save(d2);
			tx.commit();
			System.out.println("OBject data is saved with parent reference");
		}
		catch(HibernateException he) {
			if(tx!=null || tx.getRollbackOnly()) {
				tx.rollback();
			}
			System.out.println("Object data is not saved");
			he.printStackTrace();
		}
		
	}

	@Override
	public void saveDataUsingChild() {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//get Parent obj(DOctor)
			Doctor d1=new Doctor("Rocky", "NMCH", "MBBS");
			Doctor d2=new Doctor("Axs", "DMCH", "MD");
			
			//get Child object
			Patient p1=new Patient("Pinki", "DBG", "Fever");
			Patient p2=new Patient("Reems", "NDLS", "Covid");
			Patient p3=new Patient("Vicks", "MFP", "cold");
			Patient p4=new Patient("suresh", "ANVT", "elergy");
			//set special property to doctor
			d1.setPatients(Set.of(p1,p2));
			d2.setPatients(Set.of(p3,p4));
			//set special property to patient
			p1.setDoctors(List.of(d1,d2));
			p2.setDoctors(List.of(d2));
			p3.setDoctors(List.of(d1));
			p4.setDoctors(List.of(d2));
			//begin transaction
			tx=ses.beginTransaction();
			ses.save(p1);
			ses.save(p2);
			ses.save(p3);
			ses.save(p4);
			tx.commit();
			System.out.println("OBject data is saved with Child reference");
		}
		catch(HibernateException he) {
			if(tx!=null || tx.getRollbackOnly()) {
				tx.rollback();
			}
			System.out.println("Object data is not saved");
			he.printStackTrace();
		}
		
	}

	@Override
	public void loadaUsingparent() {
		try(Session ses=HibernateUtil.getSession()){
		 //prepare and execute HQL/JPQL Query
		Query<Doctor> query=ses.createQuery("from Doctor");
		List<Doctor> list=query.getResultList();
		list.forEach(doc->{
			System.out.println("parent::"+doc);
			Set<Patient> childs=doc.getPatients();
			childs.forEach(pat->{
				System.out.println("patient::"+pat);
			});
			System.out.println("--------------------");
		});
		}
		
		
	}

	@Override
	public void loadDataUsingChild() {
		try(Session ses=HibernateUtil.getSession()){
			 //prepare and execute HQL/JPQL Query
			Query<Patient> query=ses.createQuery("from Patient");
			List<Patient> list=query.getResultList();
			list.forEach(pat->{
				System.out.println("parent::"+pat);
				List<Doctor> childs=pat.getDoctors();
				childs.forEach(doc->{
					System.out.println("patient::"+doc);
				});
				System.out.println("--------------------");
			});
			}
			
		
	}

	
}//class
