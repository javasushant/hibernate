package com.nt.entity;

public  class Actor  {
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
