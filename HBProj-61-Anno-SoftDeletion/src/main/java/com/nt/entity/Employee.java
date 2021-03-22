package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BANKACOUNT")
@SQLDelete(sql = "UPDATE BANKACOUNT SET STATUS='ACTIVE' WHERE ACNO=?")
public class Employee {
	@Id
	@GeneratedValue
	private Integer ACNO;
	private String HOLDERNAME;
	private Long BALANCE;
	private String STATUS;
	
}