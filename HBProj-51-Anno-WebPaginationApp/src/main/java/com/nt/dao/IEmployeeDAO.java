package com.nt.dao;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeDAO {
	public List<Employee> getAllEmployeeByPagination(int startPos,int pageSize);

	public long getRecordCount();
}
