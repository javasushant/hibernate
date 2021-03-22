package com.nt.entity;

public class NGO_Member {
	
	private Integer  mid;
	private String ename;
	private String eadd;
	private Float salary;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEadd() {
		return eadd;
	}
	public void setEadd(String eadd) {
		this.eadd = eadd;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public NGO_Member() {
		super();
	}
	@Override
	public String toString() {
		return "NGO_Member [mid=" + mid + ", ename=" + ename + ", eadd=" + eadd + ", salary=" + salary + "]";
	}
	
	
}

