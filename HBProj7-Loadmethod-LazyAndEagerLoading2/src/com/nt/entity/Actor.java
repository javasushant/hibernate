package com.nt.entity;

public final class Actor implements IActor {
	private Integer actorid;
	private String actorName;
	private String actorAddrs;
	private Long phone;
	private Float renumeration;
	
	
	public Actor() {
		System.out.println("Actor.0-Pram constructor "+this.getClass()+" "+this.getClass().getSuperclass());
	}
	public Integer getActorid() {
		return actorid;
	}
	public void setActorid(Integer actorid) {
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
