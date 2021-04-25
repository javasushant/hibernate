package com.nt.test;

import com.nt.dao.OneToOnePKDAO;
import com.nt.dao.OneToOnePKDAOImpl;
import com.nt.utility.HibernateUtil;

public class OneToOnePK {

	public static void main(String[] args) {
		//create DAO class object
		OneToOnePKDAO dao=new OneToOnePKDAOImpl();
//		dao.saveDataUsingCHild();
		dao.loadDataUsingCHild();
		//close factory
		HibernateUtil.closeSessionFactory();

	}

}
