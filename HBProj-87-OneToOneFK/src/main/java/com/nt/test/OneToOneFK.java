package com.nt.test;

import com.nt.dao.OneToOneFKDAO;
import com.nt.dao.OneToOneFKDAOImpl;
import com.nt.utility.HibernateUtil;

public class OneToOneFK {

	public static void main(String[] args) {
		//create DAO class object
		OneToOneFKDAO dao=new OneToOneFKDAOImpl();
		dao.saveDataUsingCHild();
		
		//close factory
		HibernateUtil.closeSessionFactory();

	}

}
