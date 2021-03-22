package com.nt.service;

import java.util.List;

import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.IEmployeeDAO;
import com.nt.entity.Employee;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	private IEmployeeDAO dao;
	
	public EmployeeMgmtServiceImpl() {
		dao=new EmployeeDAOImpl();
	}
	

	@Override
	public long getPageCount(int pageSize) {
		//use DAO to get record count
		long totalRecords= dao.getRecordCount();
		long pageCount=totalRecords/pageSize;
		if(totalRecords%pageSize!=0)
			pageCount++;
		return pageCount;
	}
	
	@Override
	public List<Employee> fetchEmployeeByPagination(int pageNo, int pageSize) {
		///get StartPosition
		int startPos= (pageNo*pageNo)-pageSize;
		//use DAO
		List<Employee> list = dao.getAllEmployeeByPagination(startPos, pageSize);
		
		return list;
	}
	

}
