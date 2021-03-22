package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class ObjectSavedForThread  {
	public static void main(String[] args) {
		Mythread t1= new Mythread();
		Mythread t2= new Mythread();
		Mythread t3= new Mythread();
		
		t1.run();
		t2.run();
		t3.run();
	}
}//class
