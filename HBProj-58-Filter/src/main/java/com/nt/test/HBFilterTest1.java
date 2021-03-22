package com.nt.test;


import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class HBFilterTest1 {

	public static void main(String[] args) {
		//getting al records from Db s/w
		//SELECT ENO,ENAME FROM HQL_EMPLOYEE WHERE EADD='DDP'
		try(Session ses= HibernateUtil.getSession()){
			//get Access to filter by enabling filter
			Filter filter1=ses.enableFilter("IGNORE_ACOUNT_FILTER");
			//set values to filter paramtere
			filter1.setParameter("acountType1", "BLOCKED");
			filter1.setParameter("acountType2", "CLOSED");
			filter1.setParameter("acountType3", "SUSPENDED");
			//PREPARE QUERY  AND HQL SELECT QUERY
			Query query= ses.createQuery("FROM Employee");
			List<Employee> list= query.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});
			
			//TO DISABLE FILTER
			ses.disableFilter("IGNORE_ACOUNT_FILTER");
			Query query2=ses.createQuery("SELECT COUNT(*) FROM Employee");
			List<Employee> list1=query2.getResultList();
			System.out.println("Records count  : "+list1.get(0));
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
