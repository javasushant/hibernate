package com.nt.dao;

public interface MtoDAO {
	 public void saveData();
	 public  void deletingAllChildsAndItsParent();
	 public   void  deletingOneChildFromCollectionOfChildsBelonginToAParent();
	 public void loadDataUsingChild();
}
