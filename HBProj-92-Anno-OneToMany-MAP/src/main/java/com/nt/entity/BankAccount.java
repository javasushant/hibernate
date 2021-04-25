package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "OTM_BANKACOUNT_ANNO_MAP")
public class BankAccount implements Serializable {
	@Id
	@GeneratedValue
	private Long accountNo;
	@NonNull
	@Column(length = 15)
	private String accountType;
	@NonNull
	@Column(length = 15)
	private String bankName;
	@NonNull
	@Column(length = 15)
	private Double balance;
	
	public BankAccount(){
		System.out.println("BankAccount.BankAccount()");
	}
}
