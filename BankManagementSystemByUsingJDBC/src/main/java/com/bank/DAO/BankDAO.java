package com.bank.DAO;

import java.util.List;

import com.bank.model.BankCustomerDetails;

public interface BankDAO {
	 List<BankCustomerDetails> getAllBankCustomerDetails();

	int insertBankCustomerDetails(BankCustomerDetails bankCustomerDetails);
	BankCustomerDetails getUserDetailsByUsingEmailIdOrMobile(String emailidOrMobile,String password);
	int updateAmountByUsingAccountNumber(double amount,long accountNo);
}
