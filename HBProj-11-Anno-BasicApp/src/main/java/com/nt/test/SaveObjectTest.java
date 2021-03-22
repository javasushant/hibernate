package com.nt.test;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.util.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		//
		org.hibernate.Transaction tx=null;
		try(Session ses= HibernateUtil.openSession()){
			tx=ses.beginTransaction();
			InsurancePolicy policy = new InsurancePolicy();
			policy.setPolicyNo(12);
			policy.setPolicyName("Sushant");
			policy.setTenure("Five");
			policy.setAmount(150000.0f);
			int idVal= (int) ses.save(policy);
			tx.commit();
			System.out.println("Save object of idVal  "+idVal);
		}
		catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			System.out.println("Save is not completed");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Save is not completed");
		}
	}

}
