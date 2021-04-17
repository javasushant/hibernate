package com.nt.test;

import com.nt.dao.OneToManyBiDAO;
import com.nt.dao.OneToManyBiDAOImpl;
import com.nt.utility.HibernateUtil;

public class MTOTest {

	public static void main(String[] args) {
		//create DAO class object
		OneToManyBiDAO dao= new OneToManyBiDAOImpl(); 
//		dao.loadDataUsingParentToChildJoins();
		dao.loadDataUsingChildToParentJoins();
		//close factory
		HibernateUtil.closeSessionFactory();

	}

}
