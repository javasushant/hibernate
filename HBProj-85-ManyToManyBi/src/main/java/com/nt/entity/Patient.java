package com.nt.entity;

import java.util.Set;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@RequiredArgsConstructor
public class Patient {
	
	private Long patId;
	@NonNull
	private String patName;
	@NonNull
	private String patAddrs;
	@NonNull
	private String problem;
	
	private Set<Doctor> doctors;
	
	public Patient() {
		System.out.println("Parent :: 0-param -constructor");
	}

	@Override
	public String toString() {
		return "Patient [patId=" + patId + ", patName=" + patName + ", patAddrs=" + patAddrs + ", problem=" + problem
				;
	}

	
	

	
	
}
