package com.nt.entity;

import javax.annotation.processing.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Parameter;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

@javax.persistence.Entity
public  class Actor  {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@SequenceGenerator(name = "gen1", sequenceName = "ACTOR_SEQ", initialValue = 50,allocationSize = 11)
//	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	
//	@TableGenerator(name = "gen1",table="IDGEN_TAB", pkColumnName = "PK_COL",pkColumnValue = "A_VAL",valueColumnName = "COL_VAL",initialValue = 99,allocationSize = 5)
//	@GeneratedValue(generator = "gen1", strategy = GenerationType.TABLE)
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int actorid;
	private String actorName;
	private String actorAddrs;
	private Long phone;
	private Float renumeration;
	

	public int getActorid() {
		return actorid;
	}
	public void setActorid(int actorid) {
		this.actorid = actorid;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getActorAddrs() {
		return actorAddrs;
	}
	public void setActorAddrs(String actorAddrs) {
		this.actorAddrs = actorAddrs;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Float getRenumeration() {
		return renumeration;
	}
	public void setRenumeration(Float renumeration) {
		this.renumeration = renumeration;
	}
	
	@Override
	public String toString() {
		return "Actor [actorid=" + actorid + ", actorName=" + actorName + ", actorAddrs=" + actorAddrs + ", phone="
				+ phone + ", renumeration=" + renumeration + "]";
	}
	
	
}
