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
			//Get Access  to NamedNativeQuery query
			NativeQuery query = ses.getNamedNativeQuery("GET_EMPS_BY_SAL_RANGE");
			//set  param values
			query.setParameter(1, 100000.0f);
			query.setParameter(2, 1000000.0f);
			//execute the query
			List<Employee> list= query.getResultList();
			list.forEach(System.out::println);
			
			System.out.println("-------------------------------");
			//Get Access  to NamedNativeQuery query
			NativeQuery query1 = ses.getNamedNativeQuery("GET_EMPS_BY_ADDRS");
			//set the param value
			query1.setParameter("addrs", "SOJ");
			//execute the value
			List<Object[]> list1=query1.getResultList();
			list1.forEach(row->{
				for(Object val:row) {
					System.out.print(val+" ");
				}
				System.out.println();
			});
			
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
