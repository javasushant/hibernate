package com.nt.entity;

import javax.persistence.Embeddable;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
//@NoArgsConstructor
@Embeddable
public class JobDetails {
	private String desg;
	@NotNull
	private String company;
	@NotNull
	private float salary;
	
	
}
