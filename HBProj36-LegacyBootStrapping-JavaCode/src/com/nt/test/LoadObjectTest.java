package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		
		//get session obj
		Session ses= HibernateUtil.getSession();
		
		try {
			Actor actor =ses.get(Actor.class, 66);
			if(actor==null)
				System.out.println("Record not inserted");
			else
				System.out.println(actor.getActorid()+" "+actor.getActorName()+" "+actor.getActorAddrs()+" "+actor.getPhone()+ +actor.getRenumeration());
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
