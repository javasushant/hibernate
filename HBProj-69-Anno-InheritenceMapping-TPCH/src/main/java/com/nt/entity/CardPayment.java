package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

//@Data
@Entity
@DiscriminatorValue("CARD")
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
	public Long getCardNo() {
		return cardNo;
	}
	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getGateway() {
		return gateway;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	
	
	
	
	
	
	
	
	
	
	
}
