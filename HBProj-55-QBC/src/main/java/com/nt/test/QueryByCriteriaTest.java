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
		try(Session ses= HibernateUtil.getSession()){
			//create Criteria Buider
			CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
			//create criteraia query
			CriteriaQuery<Employee> ctQuery=ctBuilder.createQuery(Employee.class);
			//prepare Object to specify from "DB table/Entity class name" From Employee/HQL_EMPLOYEE
			Root<Employee> root= ctQuery.from(Employee.class);
			//specify root object for select operation //gives SELECT * FROM Employee/HQL_EMPLOYEE
			/*
			ctQuery.select(root);
			//prrepare Query object for execution of query
			Query query=ses.createQuery(ctQuery);
			//execute the query
			List<Employee> list=query.getResultList();
			list.forEach(System.out::println);
			*/
			
			/*
			ctQuery.select(root);
			//prepared NAamed Parameter
			ParameterExpression<Integer> param1=ctBuilder.parameter(Integer.class,"start");
			ParameterExpression<Integer> param2=ctBuilder.parameter(Integer.class,"end");
			//prepare condition having the named parameter
			Predicate pdc1 =ctBuilder.ge(root.get("eno"), param1);//gives eno>=:start
			Predicate pdc2 =ctBuilder.le(root.get("eno"), param2);//gives eno>=:end
			Predicate pdc3=ctBuilder.and(pdc1,pdc2);//gives eno>=:start and eno<=:end
			ctQuery.where(pdc3);//SELECT * FROM HQL_EMPLOYEE WHERE ENO>:START AND ENO<:END
			//ADD ORDER OBJECT
			Order order=ctBuilder.desc(root.get("ename"));
			ctQuery.orderBy(order);

			//prepared Query object to execute the query
			Query query= ses.createQuery(ctQuery);
			//set value tonamed parameter
			query.setParameter("start", 1);
			query.setParameter("end", 1000);
			List<Employee> list = query.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});
			*/
			
			/*
			//METHOD CHAINING 
			
			//specify root object for select operayion // gives select * from HQL_EMPLOYEE where eno=1 and eno>=1000 order by ename;
			ctQuery.select(root).where(ctBuilder.and(ctBuilder.ge(root.get("eno"), 1),
					ctBuilder.le(root.get("eno"), 1000)
					)).orderBy(ctBuilder.desc(root.get("ename")));
			//prepare query object to execute the query
			Query query=ses.createQuery(ctQuery);
			//execute Query
			List<Employee> list=query.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});
			*/
			
			/* USE OF CLAUE ( IN )*/
			/*
			ctQuery.select(root).where(root.get("eadd").in("DDP","DOJ")).orderBy(ctBuilder.desc(root.get("ename")));
			//prepare query object to execute the query
			Query query=ses.createQuery(ctQuery);
			//execute Query
			List<Employee> list=query.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});
			*/
			/*
			ctQuery.select(root).where(ctBuilder.like(root.get("ename"), "S%"));
			//prepare query object to execute the query
			Query query=ses.createQuery(ctQuery);
			//execute Query
			List<Employee> list=query.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});
			*/
			ctQuery.select(root).where(ctBuilder.like(root.get("name"), "S__"));
			//prepare query object to execute the query
			Query query=ses.createQuery(ctQuery);
			//execute Query
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
