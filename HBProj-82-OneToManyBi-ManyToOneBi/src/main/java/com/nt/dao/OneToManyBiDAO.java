package com.nt.dao;

public interface OneToManyBiDAO {
	public void saveDataUsingParents();
	public void saveDataUsingChild();
	public void loadDataUsingParents();
//	public void saveDataUsingChild();
}
