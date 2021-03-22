package com.nt.test;


import java.util.Scanner;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class HBFilterTest1 {

	public static void main(String[] args) {
		//take a serial no from end user on which he has to be closed status
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Acount Number");
		int no=sc.nextInt();
		Transaction tx=null;
		try(Session ses= HibernateUtil.getSession()){
			//Load the record/object
			Employee emp=ses.get(Employee.class, no);
			if(emp!=null) {
				tx=ses.beginTransaction();
				ses.delete(emp);
				tx.commit();
				System.out.println("Record is Closed");
			}//if
			else {
				System.out.println("Acount not found/Already closed");
			}//else
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly())
				tx.rollback();
		}
	}

}
