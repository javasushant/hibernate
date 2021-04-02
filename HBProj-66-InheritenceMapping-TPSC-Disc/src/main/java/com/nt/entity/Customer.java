package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Customer extends Person {
	@NonNull
	private Float billAmount;
	@NonNull
	private Float discount;
	@Override
	public String toString() {
		return "Customer [billAmount=" + billAmount + ", discount=" + discount + ", getPid()=" + getPid()
				+ ", getPname()=" + getPname() + ", getPadd()=" + getPadd() + ", getCompany()=" + getCompany()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	
}
