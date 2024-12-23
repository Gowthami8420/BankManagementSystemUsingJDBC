package com.bank.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class BankStatementDetails {
	private int id;
	private LocalDate dateOfTransaction;
	private LocalTime timeOfTransaction;
	private double transactionAmount;
	private double balanceAmount;
	private long accountNumber;
	
	public BankStatementDetails() {
		
	}

	public BankStatementDetails(int id, LocalDate dateOfTransaction, LocalTime timeOfTransaction,
			double transactionAmount, double balanceAmount, long accountNumber) {
		super();
		this.id = id;
		this.dateOfTransaction = dateOfTransaction;
		this.timeOfTransaction = timeOfTransaction;
		this.transactionAmount = transactionAmount;
		this.balanceAmount = balanceAmount;
		this.accountNumber = accountNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public LocalTime getTimeOfTransaction() {
		return timeOfTransaction;
	}

	public void setTimeOfTransaction(LocalTime timeOfTransaction) {
		this.timeOfTransaction = timeOfTransaction;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "BankStatementDetails [id=" + id + ", dateOfTransaction=" + dateOfTransaction + ", timeOfTransaction="
				+ timeOfTransaction + ", transactionAmount=" + transactionAmount + ", balanceAmount=" + balanceAmount
				+ ", accountNumber=" + accountNumber + "]";
	}	
}
