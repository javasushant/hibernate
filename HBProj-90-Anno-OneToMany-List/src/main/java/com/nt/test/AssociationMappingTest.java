package com.nt.test;

import com.nt.dao.IPersonDAO;
import com.nt.dao.PersonDAOImpl;
import com.nt.utility.HibernateUtil;

public class AssociationMappingTest {

	public static void main(String[] args) {
		//get DAO
		IPersonDAO dao= new PersonDAOImpl();
		dao.insertData();
//		dao.loadData();
//		dao.deleteDataUsingParent();
//		dao.deleteOnlyChildOfParent();
//		dao.deleteOneChildFromCollectionChildBelongingToParent();
//		dao.addNewChildForExistingParent();
//		dao.TransferChildFromOneParentToAnotherParent();
		//close session
		HibernateUtil.closeSessionFactory();
	}

}
