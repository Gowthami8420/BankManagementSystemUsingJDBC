package com.bank.DAO;

import com.bank.model.BankStatementDetails;

public interface BankStatementDAO {
	int insertBankStatement(BankStatementDetails bankStatementDetails);
}
