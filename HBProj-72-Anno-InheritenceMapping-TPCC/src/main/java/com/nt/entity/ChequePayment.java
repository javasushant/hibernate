package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "INH_CHEQUEPAYMENT_TPCC")
public class ChequePayment extends Payment {
	
	private Long chequeNo;
	@Column(length = 24)
	private String chequeType;
	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", getPid()=" + getPid()
				+ ", getAmount()=" + getAmount() + ", getPdate()=" + getPdate() + "]";
	}
	

	
	
	
	
	
	
	
}
