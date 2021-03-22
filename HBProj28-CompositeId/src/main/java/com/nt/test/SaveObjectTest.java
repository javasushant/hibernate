package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.Programmer_Project;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		//get Session obj
		Transaction tx =null;
		try (Session ses=HibernateUtil.openSession()){
			//begin tx
			tx=ses.beginTransaction();
			//full object modification
			//Object of identity class
			PrgmrProjId id = new PrgmrProjId();
			id.setPrgmrId(101); id.setProjId(1001);
			//object of Project class
			Programmer_Project entity = new Programmer_Project();
			entity.setId(id);
			entity.setPrgmrName("Rock"); entity.setAge(26);
			entity.setProjName("openFx"); entity.setTeamSize(5);
			
			tx.commit();
			PrgmrProjId idval = (PrgmrProjId) ses.save(entity);
			System.out.println("Saved id value "+idval);
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			System.out.println("Object is not saved");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Object is not saved");
		}
	}//main
}//class
