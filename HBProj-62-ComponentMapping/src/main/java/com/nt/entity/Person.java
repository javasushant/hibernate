package com.nt.entity;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
//@Entity
//@AllArgsConstructor
@RequiredArgsConstructor
//@NoArgsConstructor
//@Table(name = "BANKACOUNT")
public class Person {

	//	@Id
//	@GeneratedValue
	private Integer pid;
	@NotNull
	private String pname;
	@NotNull
	private JobDetails details;
	public Person(String pname, JobDetails details) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.details = details;
	}
	
	
}