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
public class Employee {
	@Id
	@GeneratedValue
	private Integer eno;
	private String ename;
	private String eadd;
	private float salary;
	
}