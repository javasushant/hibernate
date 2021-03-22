package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NGO_Member {
	
	private Integer mid;
	private String ename;
	private String eadd;
	private float salary;
	
}

