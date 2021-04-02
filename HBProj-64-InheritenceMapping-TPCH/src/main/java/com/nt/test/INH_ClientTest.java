package com.nt.test;

import com.nt.dao.IPersonDAO;
import com.nt.dao.PersonDAOImpl;
import com.nt.utility.HibernateUtil;

public class INH_ClientTest {

	public static void main(String[] args) {
		IPersonDAO dao=new PersonDAOImpl();
//		dao.saveData();
		dao.loadData();
		
		HibernateUtil.closeSessionFactory();
	}

}
