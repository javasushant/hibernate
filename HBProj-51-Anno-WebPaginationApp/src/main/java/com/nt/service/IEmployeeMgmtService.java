package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> fetchEmployeeByPagination(int pageNo, int pageSize);
	public long getPageCount(int pageSize);
}
