package com.nt.entity;

import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@RequiredArgsConstructor

public class Doctor {
	private Integer docId;
	@NonNull
	private String docName;
	@NonNull
	private String hospital;
	@NonNull
	private String docQlfy;
	
	private Set<Patient> patients;
	
	public Doctor() {
		System.out.println("Doctor.0-param-constructor");
	}

	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", docName=" + docName + ", hospital=" + hospital + ", docQlfy=" + docQlfy
				;
	}

	

	
	
	
}
