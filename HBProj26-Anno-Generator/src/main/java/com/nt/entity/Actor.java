package com.nt.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Parameter;

import org.hibernate.annotations.GenericGenerator;

@javax.persistence.Entity
public  class Actor  {
	@Id
//	@GenericGenerator(name="gen1", strategy="increment")
//	@GeneratedValue(generator = "gen1")
	
//	@GenericGenerator(name="gen1", strategy="sequence" ,
//					parameters= {@org.hibernate.annotations.Parameter(name="sequence_name" ,value="act_id")}
//			)
//	@GeneratedValue(generator = "gen1")
	
//	@GenericGenerator(name="gen1", strategy="sequence")
//	@GeneratedValue(generator = "gen1")
//	@GenericGenerator(name="gen1", strategy="native")
//	@GeneratedValue(generator = "gen1")
//	@GenericGenerator(name="gen1", strategy="seqhilo")
//	@GeneratedValue(generator = "gen1")
//	@GenericGenerator(name="gen1", strategy="guid")
//	@GeneratedValue(generator = "gen1" )
	
	private String actorid;
	private String actorName;
	private String actorAddrs;
	private Long phone;
	private Float renumeration;
	

	public String getActorid() {
		return actorid;
	}
	public void setActorid(String actorid) {
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
