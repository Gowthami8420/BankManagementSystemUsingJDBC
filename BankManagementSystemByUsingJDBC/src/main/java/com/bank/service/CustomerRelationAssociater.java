package com.bank.service;

public class CustomerRelationAssociater {
	public static BankService customerService() {
		return new BankServiceImpl();
	}
}

 