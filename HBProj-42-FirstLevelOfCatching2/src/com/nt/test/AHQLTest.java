package com.nt.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class AHQLTest {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSession()){
			Query query=ses.createQuery("From Actor as a");
			List<Actor> list=query.getResultList();
			list.forEach(actor->{
				System.out.println(actor);
			});
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
