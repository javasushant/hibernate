package com.nt.test;

import com.nt.command.IBankService;
import com.nt.factory.BankServiceFactory;

public class BankCustomer1 {

	public static void main(String[] args) {
		IBankService service  = BankServiceFactory.getInstance(true);
		System.out.println(service.withdraw(321372651, 40000));
		IBankService service1  = BankServiceFactory.getInstance(false);
		System.out.println(service1.withdraw(321372651,50000));
	}

}
