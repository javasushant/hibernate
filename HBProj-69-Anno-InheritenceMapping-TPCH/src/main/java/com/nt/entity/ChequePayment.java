package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
//@Data
@Entity
@DiscriminatorValue("CHEQUE")
public class ChequePayment extends Payment {
	
	private Long chequeNo;
	@Column(length = 24)
	private String chequeType;
	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", getPid()=" + getPid()
				+ ", getAmount()=" + getAmount() + ", getPdate()=" + getPdate() + "]";
	}
	public Long getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getChequeType() {
		return chequeType;
	}
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	
	
	
	
	
	
	
}
