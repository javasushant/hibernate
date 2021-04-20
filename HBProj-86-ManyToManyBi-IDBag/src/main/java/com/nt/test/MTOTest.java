package com.nt.test;

import com.nt.dao.MTOMDAO;
import com.nt.dao.MTOMDAOImpl;
import com.nt.utility.HibernateUtil;

public class MTOTest {

	public static void main(String[] args) {
		//create DAO class object
		MTOMDAO dao=new MTOMDAOImpl();
		dao.saveDataUsingParent();
//		dao.saveDataUsingChild();
//		dao.loadaUsingparent();
//		dao.loadDataUsingChild();
		//close factory
		HibernateUtil.closeSessionFactory();

	}

}
