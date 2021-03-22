package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HQL_EMPLOYEE")
@NamedQuery(name = "HQL_GET_EMP_DETAILS" ,query="FROM Employee where salary>=:start and salary<=:end")
@NamedQuery(name = "UPDATE_SALARY_BONUS" ,query="UPDATE Employee SET salary=salary+:bonus where eadd=:addrs")
public class Employee {
	@Id
	@GeneratedValue
	private Integer eno;
	private String ename;
	private String eadd;
	private float salary;
	
}