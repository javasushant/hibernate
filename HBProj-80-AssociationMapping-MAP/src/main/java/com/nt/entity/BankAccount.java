package com.nt.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class BankAccount implements Serializable {
	private Long accountNo;
	@NonNull
	private String accountType;
	@NonNull
	private String bankName;
	@NonNull
	private Double balance;
	
	public BankAccount(){
		System.out.println("BankAccount.BankAccount()");
	}
}
