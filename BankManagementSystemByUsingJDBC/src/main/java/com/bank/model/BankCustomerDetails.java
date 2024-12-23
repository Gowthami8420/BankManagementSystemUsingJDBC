package com.bank.model;

import java.time.LocalDate;

public class BankCustomerDetails {
	
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private long mobile;
	private long aadhar;
	private String gender;
	private String address;
	private double amount;
	private long accountNo;
	private LocalDate date;
	
	public BankCustomerDetails() {
		
	}

	public BankCustomerDetails(int id, String fname, String lname, String email, String password, long mobile,
			long aadhar, String gender, String address, double amount, long accountNo, LocalDate date) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.aadhar = aadhar;
		this.gender = gender;
		this.address = address;
		this.amount = amount;
		this.accountNo = accountNo;
		this.date = date;
	}

	@Override
	public String toString() {
		return "BankCustomerDetails [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", password=" + password + ", mobile=" + mobile + ", aadhar=" + aadhar + ", gender=" + gender
				+ ", address=" + address + ", amount=" + amount + ", accountNo=" + accountNo + ", date=" + date + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public long getAadhar() {
		return aadhar;
	}

	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
