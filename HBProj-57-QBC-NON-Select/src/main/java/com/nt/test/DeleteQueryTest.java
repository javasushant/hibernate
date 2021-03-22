package com.nt.test;


import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class DeleteQueryTest {

	public static void main(String[] args) {
		Transaction tx=null;
		//getting al records from Db s/w
		//SELECT ENO,ENAME FROM HQL_EMPLOYEE WHERE EADD='DDP'
		try(Session ses= HibernateUtil.getSession()){
			tx=ses.beginTransaction();
			//create Criteria Buider
			CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
			//create CriteriaDelete
			CriteriaDelete<Employee> ctdelete=ctBuilder.createCriteriaDelete(Employee.class);
			//specify from db table/entity
			Root<Employee> root=ctdelete.from(Employee.class);
			//modify col value
			ctdelete.where(ctBuilder.equal(root.get("eadd"), "DDP"));
			//prepare Query 
			Query query= ses.createQuery(ctdelete);
			//execute the Query
			int result=query.executeUpdate();
			System.out.println("no of records effected "+result);
			tx.commit();
			
			
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
