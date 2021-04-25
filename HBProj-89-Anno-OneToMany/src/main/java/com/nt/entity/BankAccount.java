package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "OTM_BANKACOUNT")
public class BankAccount implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1" , sequenceName = "ACNO_SEQ",initialValue = 1000,allocationSize = 5)
	@GeneratedValue(generator = "gen1" )
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
