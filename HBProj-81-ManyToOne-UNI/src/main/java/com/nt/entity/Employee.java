package com.nt.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
//@NoArgsConstructor
@RequiredArgsConstructor
public class Employee implements Serializable {
	
	private  Integer eno;
	@NonNull
	private String ename;
	@NonNull
	private  String eadd;
	@NonNull
	private  double salary;
	@NonNull
	private  Department dept;   // child to parent association  
	
	public Employee(){
		System.out.println("Employee.:: 0-param-constructor "+this.getClass());
	}
}
