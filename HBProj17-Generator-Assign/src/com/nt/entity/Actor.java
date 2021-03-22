package com.nt.entity;

public class Actor {
	private int actorid;
	private String actorName;
	private String actorAddrs;
	private long phone;
	private float renumeration;
	private String brand;
	
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	//
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public float getRenumeration() {
		return renumeration;
	}
	public void setRenumeration(float renumeration) {
		this.renumeration = renumeration;
	}
	
	
	@Override
	public String toString() {
		return "Actor [actorid=" + actorid + ", actorName=" + actorName + ", actorAddrs=" + actorAddrs + ", phone="
				+ phone + ", renumeration=" + renumeration + "]";
	}
	
	
	
}
