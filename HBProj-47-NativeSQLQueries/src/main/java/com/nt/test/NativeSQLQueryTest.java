package com.nt.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;import org.hibernate.internal.build.AllowSysOut;
//import org.hibernate.query.Query;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NativeSQLQueryTest {

	public static void main(String[] args) {
		try(Session ses= HibernateUtil.getSession()){
			/*
			 * NativeQuery query=ses.
			 * createNativeQuery("SELECT * FROM HQL_EMPLOYEE WHERE SALARY>=? AND SALARY<=?"
			 * ); query.addEntity(Employee.class); query.setParameter(1, 50000.0f);
			 * query.setParameter(2, 500000.0f); List<Employee> list =
			 * query.getResultList(); 
			 * list.forEach(System.out::println);
			 */
			
			/*
			 * NativeQuery query=ses.
			 * createNativeQuery("SELECT * FROM HQL_EMPLOYEE WHERE SALARY>=? AND SALARY<=?"); 
			 * // query.addEntity(Employee.class); 
			 * query.setParameter(1, 50000.0f);
			 * query.setParameter(2, 500000.0f); 
			 * List<Object[]> list =query.getResultList(); 
			 * list.forEach(row->{
			 * System.out.println(Arrays.toString(row));
			 *  });
			 */
			/*
			NativeQuery query=ses.createNativeQuery("SELECT ENO,ENAME FROM HQL_EMPLOYEE WHERE EADD IN(?1,?2,?3)");
			//map col names with hibernate data types
			query.addScalar("ENO",StandardBasicTypes.INTEGER);
			query.addScalar("ENAME",StandardBasicTypes.STRING);
			//set values to query param
			query.setParameter(1, "SOJ");
			query.setParameter(2, "NNMP");
			query.setParameter(3, "DDP");
			//execute query
			List<Object[]> list =query.getResultList();
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+" ");
				}
				System.out.println();
			});
			list.forEach(System.out::println);
			*/
			/*
			NativeQuery query=ses.createNativeQuery("SELECT ENAME FROM HQL_EMPLOYEE WHERE ENAME LIKE:initChars");
			//map col names with hibernate data types
			query.addScalar("ENAME",StandardBasicTypes.STRING);
			//se vales to query param
			query.setParameter("initChars", "S%");
			List<Object> list = query.getResultList();
			list.forEach(System.out::println);
			*/
			
			NativeQuery query=ses.createNativeQuery("SELECT COUNT(*) FROM HQL_EMPLOYEE");
			//map col names with hibernate data types
			query.addScalar("COUNT(*)",StandardBasicTypes.INTEGER);
			List<Integer> list=query.getResultList();
			int count=list.get(0);
			System.out.println(count);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
