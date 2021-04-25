package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@Table(name = "OTM_ANNO_BANKACOUNT_LIST")
public class BankAccount implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "BANK_SEQ",initialValue = 50,allocationSize = 3)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
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
