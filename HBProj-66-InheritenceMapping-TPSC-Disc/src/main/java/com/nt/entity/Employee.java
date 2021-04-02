package com.nt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee extends Person {
	
	@NonNull
	private Float salary;
	@NonNull
	private String desg;
	@NonNull
	private Integer deptNumber;
	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", desg=" + desg + ", deptNumber=" + deptNumber + ", getPid()=" + getPid()
				+ ", getPname()=" + getPname() + ", getPadd()=" + getPadd() + ", getCompany()=" + getCompany()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	
}
