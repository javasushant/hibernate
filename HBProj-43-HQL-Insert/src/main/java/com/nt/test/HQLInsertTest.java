package com.nt.test;

import java.util.List;

import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
//import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class HQLInsertTest {

	public static void main(String[] args) {
		try(Session ses= HibernateUtil.getSession()){
			//Employee emp=ses.get(Employee.cl);
//			javax.persistence.Query query= ses.createQuery("From Employee");
//			Query query= ses.createQuery("From Employee as e");
//			Query query= ses.createQuery("From Employee WHERE eno>=?1 and eno<=?2");
//			query.setParameter(1, 100);
//			query.setParameter(2, 106);
//			Query query= ses.createQuery("From Employee WHERE eno IN(:no1,:no2,:no3)");
//			query.setParameter("no1", 101);
//			query.setParameter("no2", 102);
//			query.setParameter("no3", 103);
			
//			Query query= ses.createQuery("From Employee WHERE eno=(SELECT MAX(eno) FROM Employee)");
			Query query= ses.createQuery("From Employee WHERE ename like:InitChars");
			query.setParameter("InitChars", "P%%T");
			List<Employee> list =query.getResultList();
			//process the result
			/*list.forEach(emp->{
				System.out.println(emp);
			});
			*/
			list.forEach(System.out::println);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
