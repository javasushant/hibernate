package com.nt.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "PERSON_JOB_DETAILS")
public class Person {

		@Id
	@GeneratedValue
	private Integer pid;
	@NotNull
	private String pname;
	@NotNull
	@Embedded
	private JobDetails details;
	public Person(String pname, JobDetails details) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.details = details;
	}
	
	
}