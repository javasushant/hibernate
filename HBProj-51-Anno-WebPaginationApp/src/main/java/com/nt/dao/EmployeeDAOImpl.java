package com.nt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public List<Employee> getAllEmployeeByPagination(int startPos, int pageSize) {
		//get session
		Session ses= HibernateUtil.getSession();
		//Dummy tx
		Transaction tx=null;
		if(ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		//execute HQL with pagination
		Query query = ses.createQuery("FROM Employee");
		query.setFirstResult(startPos);
		query.setMaxResults(pageSize);
		List<Employee> list =query.getResultList();
		
		return list;
	}
	
	@Override
	public long getRecordCount() {
		//use service
		Session ses =HibernateUtil.getSession();
		//Dummy Tx
		Transaction tx=null;
		if(ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		
		//execute HQL with pagination
		Query query=ses.createQuery("SELECT COUNT(*) FROM Employee ");
		List<Long> list =query.getResultList();
		return list.get(0);
		
	
		
	}
}
