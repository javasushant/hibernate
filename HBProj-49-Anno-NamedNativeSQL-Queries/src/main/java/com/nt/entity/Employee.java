package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HQL_EMPLOYEE")
@NamedNativeQuery(name ="GET_EMPS_BY_SAL_RANGE" , 
                      query = "SELECT ENO,ENAME,EADD,SALARY FROM HQL_EMPLOYEE WHERE SALARY>=? AND SALARY<=?", 
                      resultClass = Employee.class)
@NamedNativeQuery(name = "GET_EMPS_BY_ADDRS",
                         query = "SELECT ENO,ENAME,EADD FROM HQL_EMPLOYEE WHERE EADD=:addrs")
public class Employee {
	@Id
	@GeneratedValue
	private Integer eno;
	private String ename;
	private String eadd;
	private float salary;
	
}