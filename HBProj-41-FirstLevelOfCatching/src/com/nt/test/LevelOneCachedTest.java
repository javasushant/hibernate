package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class LevelOneCachedTest {

	public static void main(String[] args) {
		
		//get session obj
		Session ses= HibernateUtil.getSession();
		
		try {
			Actor actor =ses.get(Actor.class, 66);
			System.out.println(actor);
			System.out.println("==============================");
			
			Actor actor1 =ses.get(Actor.class, 66);
			System.out.println(actor1);
			System.out.println("==============================");
			ses.evict(actor);
			Actor actor2 =ses.get(Actor.class, 66);
			System.out.println(actor2);
			System.out.println("==============================");
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
