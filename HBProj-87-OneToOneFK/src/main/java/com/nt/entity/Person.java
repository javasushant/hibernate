package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor

public class Person implements Serializable{
	private Integer pId;
	@NonNull
	private String pname;
	@NonNull
	private String paddrs;
	@NonNull
	private LocalDateTime dob;
	
	
	
	public Person() {
		System.out.println("Person.0-param-constructor");
	}



	@Override
	public String toString() {
		return "Person [pId=" + pId + ", pname=" + pname + ", paddrs=" + paddrs + ", dob=" + dob + "]";
	}



	public Integer getpId() {
		return pId;
	}



	public void setpId(Integer pId) {
		this.pId = pId;
	}



	public String getPname() {
		return pname;
	}



	public void setPname(String pname) {
		this.pname = pname;
	}



	public String getPaddrs() {
		return paddrs;
	}



	public void setPaddrs(String paddrs) {
		this.paddrs = paddrs;
	}



	public LocalDateTime getDob() {
		return dob;
	}



	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}

	
}
