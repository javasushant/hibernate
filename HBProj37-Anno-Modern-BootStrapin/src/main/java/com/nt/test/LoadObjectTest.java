package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.Programmer_Project;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		//get Session obj
		try (Session ses=HibernateUtil.openSession()){
			//begin tx
			//full object modification
			//Object of identity class
			PrgmrProjId id = new PrgmrProjId();
			id.setPrgmrId(101); id.setProjId(1001);
			//Load of Project class
			Programmer_Project entity = ses.get(Programmer_Project.class, id);
			if(entity==null)
				System.out.println("Object is not found");
			else
				System.out.println("Object found and result is "+entity);
		}
		catch(HibernateException he) {
			he.printStackTrace();
			System.out.println("Object is not saved");
		}
		catch (Exception e) {
			System.out.println("Object is not saved");
		}
	}//main
}//class
