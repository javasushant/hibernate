package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "INH_CARDPAYMENT_TPCC")
public class CardPayment extends Payment {

	private Long cardNo;
	@Column(length = 25)
	private String cardType;
	@Column(length = 30)
	private String gateway;

	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", gateway=" + gateway + ", getPid()="
				+ getPid() + ", getAmount()=" + getAmount() + ", getPdate()=" + getPdate() + "]";
	}

}
