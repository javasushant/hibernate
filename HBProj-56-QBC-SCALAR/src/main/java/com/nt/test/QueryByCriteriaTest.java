package com.nt.test;


import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class QueryByCriteriaTest {

	public static void main(String[] args) {
		
		//getting al records from Db s/w
		//SELECT ENO,ENAME FROM HQL_EMPLOYEE WHERE EADD='DDP'
		try(Session ses= HibernateUtil.getSession()){
			/*
			//create Criteria Buider
			CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
			//create criteraia query
			CriteriaQuery ctQuery=ctBuilder.createQuery(Object[].class);
			//prepare Object to specify from "DB table/Entity class name" From Employee/HQL_EMPLOYEE
			Root<Employee> root= ctQuery.from(Employee.class);
			//specify root object for select operation //gives SELECT * FROM Employee/HQL_EMPLOYEE
			//Specify select clause with col names
			ctQuery.multiselect(root.get("eno"),root.get("ename"));
			//specify where clause
			ctQuery.where(ctBuilder.equal(root.get("eadd"), "DDP"));
			//prepare Query Object
			Query query=ses.createQuery(ctQuery);
			//execute the query
			List<Object[]> list=query.getResultList();
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+" ");
				}
				System.out.println();
			});
			*/
			//create CriteriaBuilder object
			//SELECT ENAME FROM HQL_EMPLOYEE WHERE SALARY>=100000 AND SALARY<=100000 ORDER BY ENAME DESC
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//create CriteriaQuery objectbuilder
			CriteriaQuery<Object> ctQuery=builder.createQuery(Object.class);
			//add from clause pointing to table/Entity name
			Root<Employee> root=ctQuery.from(Employee.class);
			/*
			//add select clause specifying the col/property name
			ctQuery.multiselect(root.get("ename")).where(builder.and(builder.ge(root.get("salary"), 10000.0f),
					builder.le(root.get("salary"),100000.0f))).orderBy(builder.desc(root.get("ename")));
			//prepare query Object to execute the query
			Query query=ses.createQuery(ctQuery);
			//execute the Query
			List<Object> list=query.getResultList();
			list.forEach(System.out::println);
			*/
			/*
			//SELECT COUNT(*) FROM HQL_EMPLOYEE
			//PREPARE CRITERIABUILDER OBJECT
			//add select clause to specifying the col/property
			ctQuery.multiselect(builder.count(root.get("eno")));
			//prepare query object to execute the query
			Query query=ses.createQuery(ctQuery);
			//execute the Query
			List<Object> list=query.getResultList();
			System.out.println("Record count :: "+list.get(0));
			*/
			/*
			//JPA criteriaQBC to get multiple aggregate results (scalar query)
			//SELECT COUNT(*),SUM(SAL),AVG(SAL),FROM HQL_EMPLOYEE
			//specify select clause col/property
			ctQuery.multiselect(builder.count(root.get("eno")),builder.sum(root.get("salary")),builder.avg(root.get("salary")));
			//prepare query object to execute the query
			Query query=ses.createQuery(ctQuery);
			//execute the Query
			List<Object[]> list=query.getResultList();
			Object row[] =list.get(0);
			System.out.println("Record count : "+row[0]);
			System.out.println("========================");
			System.out.println("Record SUM : "+row[1]);
			System.out.println("========================");
			System.out.println("Record AVG : "+row[2]);
			System.out.println("========================");
			*/
			ctQuery.select(root);
			//prepare query object to execute the query
			Query query=ses.createQuery(ctQuery);
			query.setFirstResult(3);
			query.setMaxResults(2);
			//execute the Query
			List<Employee> list=query.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});
			
			
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
