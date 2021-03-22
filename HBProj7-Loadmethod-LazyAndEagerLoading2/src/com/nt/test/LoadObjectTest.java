package com.nt.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Actor;
import com.nt.entity.IActor;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		
		//get session obj
		Session ses= HibernateUtil.openSession();
		
		try {
			IActor actor =ses.load(IActor.class, 1);
			System.out.println(actor +" "+actor.getClass()+" "+actor.getClass().getSuperclass()+" "+Arrays.toString(actor.getClass().getInterfaces()));
		}
		catch(Exception he) {
			System.out.println("Object Not found ");
			he.printStackTrace();
		}
		finally{
			//close session obj(Connection closing)
			HibernateUtil.closeSession(ses);
			//close sessionfactory obj
			HibernateUtil.closeSessionFactory();
		}
	}

}
