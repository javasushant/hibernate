package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor

public class Student implements Serializable{
	private Integer sId;
	@NonNull
	private String sname;
	@NonNull
	private String saddrs;
	@NonNull
	private LocalDateTime dob;
	private LibraryMembership libraryDetails;
	
	
	
	public Student() {
		System.out.println("Student.0-param-constructor");
	}



	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sname=" + sname + ", saddrs=" + saddrs + ", dob=" + dob + "]";
	}



	public Integer getsId() {
		return sId;
	}



	public void setsId(Integer sId) {
		this.sId = sId;
	}



	public String getSname() {
		return sname;
	}



	public void setSname(String sname) {
		this.sname = sname;
	}



	public String getSaddrs() {
		return saddrs;
	}



	public void setSaddrs(String saddrs) {
		this.saddrs = saddrs;
	}



	public LocalDateTime getDob() {
		return dob;
	}



	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}



	public LibraryMembership getLibraryDetails() {
		return libraryDetails;
	}



	public void setLibraryDetails(LibraryMembership libraryDetails) {
		this.libraryDetails = libraryDetails;
	}
	
	


	

	
}
