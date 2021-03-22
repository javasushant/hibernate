package com.nt.entity;

import java.io.Serializable;

import lombok.Data;
@Data
public class Programmer_Project implements Serializable {
	private PrgmrProjId id;
	private String prgmrName;
	private Integer age;
	private String projName;
	private Integer teamSize;
}
