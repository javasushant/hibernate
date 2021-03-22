package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class InsurancePolicyDAOImpl implements IInsurancePolicyDAO {

	@Override
	public InsurancePolicy getDeatilsByPolicyId(int policyId) {
		//get Session obj
		try(Session ses=HibernateUtil.openSession()){
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
