package com.nt.test;

import com.nt.dao.MtoDAO;
import com.nt.dao.MtoDAOImpl;
import com.nt.utility.HibernateUtil;

public class MTOTest {

	public static void main(String[] args) {
		//create DAO class object
		MtoDAO dao= new MtoDAOImpl();
		//dao.saveData();
//		dao.deletingAllChildsAndItsParent();
//		dao.deletingOneChildFromCollectionOfChildsBelonginToAParent();
		dao.loadDataUsingChild();
		
		//close factory
		HibernateUtil.closeSessionFactory();

	}

}
