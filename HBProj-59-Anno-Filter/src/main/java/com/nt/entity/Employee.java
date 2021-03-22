package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BANKACOUNT")
@FilterDef(name = "IGNORE_ACOUNT_FILTER",
			parameters = {@ParamDef(type = "string",name = "acountType1"),
			@ParamDef(type = "string",name = "acountType2"),
			@ParamDef(type = "string",name = "acountType3")
			
})
@Filter(name="IGNORE_ACOUNT_FILTER", condition = "STATUS NOT IN(:acountType1,:acountType2,:acountType3)")
public class Employee {
	@Id
	@GeneratedValue
	private Integer ACNO;
	private String HOLDERNAME;
	private Integer BALANCE;
	private String STATUS;
	
}