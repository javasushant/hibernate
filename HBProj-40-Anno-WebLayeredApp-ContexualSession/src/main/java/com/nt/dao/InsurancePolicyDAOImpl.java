package com.nt.dao;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class InsurancePolicyDAOImpl implements IInsurancePolicyDAO {

	@Override
	public InsurancePolicy getDeatilsByPolicyId(int policyId) {
		//get Session obj
		try(Session ses=HibernateUtil.openSession();
				Session ses1=HibernateUtil.openSession()){
			System.out.println(ses.hashCode()+"  "+ses1.hashCode());
			org.hibernate.Transaction tx = ses.beginTransaction();
			//Load obj
			InsurancePolicy policy = ses.get(InsurancePolicy.class, policyId);
			if(policy!=null)
				return policy;
			else
				return null;
		}//try
		catch(HibernateException he) {
			throw he;
		}
	}//method
}//class
