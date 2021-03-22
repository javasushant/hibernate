package com.nt.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
//import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class HQLTest1 {

	public static void main(String[] args) {
		try(Session ses= HibernateUtil.getSession()){
			//Executing HQL select query that gives multiple col values (scal query
//			Query query= ses.createQuery("SELECT eno,ename From Employee WHERE ename like '___'");
//			List<Object[]> list =query.getResultList();
//			list.forEach(row->{
//				for(Object val:row) {
//					System.out.print(val+" ");
//				}
//				System.out.println();
//			});
			
			//Executing HQL select query that gives single col value
//			Query query=ses.createQuery("select salary  from Employee where eno=:addrs");
//			query.setParameter("addrs", 102);
//			List<Float> list=query.getResultList();
//			list.forEach(System.out::println);
			
			//in HQL Queries we can place both Named PARAMETER AND jpa style ordinal positional parameter
//			Query query= ses.createQuery("from Employee where eno>=:start and eno<=?1");
//			query.setParameter("start", 101);
//			query.setParameter(1, 102);
			
//			Query query= ses.createQuery("from Employee where eno>=?1 and eno<=:end");
//			query.setParameter(1, 102);
//			query.setParameter("end", 104);
//			List<Employee> list= query.getResultList();
//			list.forEach(System.out::println);
			
//			Query query= ses.createQuery("SELECT  count(*) from Employee");
//			List<Long> list= query.getResultList();
//		System.out.println("records count ::"+list.get(0));
			
//			Query query= ses.createQuery("SELECT COUNT(*),MAX(salary),MIN(salary),AVG(salary),SUM(salary) FROM Employee");
//			List<Object[]> list= query.getResultList();
//			Object row[] =list.get(0);
//			System.out.println("Total no. of count "+row[0]);
//			System.out.println("maximum salary "+row[1]);
//			System.out.println("minimum salary "+row[2]);
//			System.out.println("Avg of salary "+row[3]);
//			System.out.println("Sum of salary "+row[4]);
			
//			Query query= ses.createQuery("SELECT eno,ename From Employee WHERE ename like :'%S'");
//			Iterator<Object[]> it=query.iterate
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
