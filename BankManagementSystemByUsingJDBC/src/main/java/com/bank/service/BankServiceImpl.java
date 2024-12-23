package com.bank.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.bank.DAO.BankDAO;
import com.bank.DAO.BankDAOImpl;
import com.bank.DAO.BankStatementDAO;
import com.bank.DAO.BankStatementDAOImpl;
import com.bank.model.BankCustomerDetails;
import com.bank.model.BankStatementDetails;

public class BankServiceImpl implements BankService{
	Scanner s=new Scanner(System.in);
	BankCustomerDetails loginPersonDetails;
	@Override
	public void toSleep(String name) {
		for(int i=0;i<name.length();i++)
		{
			System.out.print(name.charAt(i));
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	BankDAO bankDAO=new BankDAOImpl();
	BankStatementDAO bankStatementDAO=new BankStatementDAOImpl();
	@Override
	public void userRegistration() {
		BankCustomerDetails bankCustomerDetails=new BankCustomerDetails();
		
		List<BankCustomerDetails> allBankCustomerDetails=bankDAO.getAllBankCustomerDetails();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your First name");
		String fname=s.next();
		bankCustomerDetails.setFname(fname);
		System.out.println("Enter Your Last Name");
		String lname=s.next();
		bankCustomerDetails.setLname(lname);
		System.out.println("Enter your Email id");
		String email=s.next();
		bankCustomerDetails.setEmail(email);
		System.out.println("Enter Your Password");
//		String password=s.next()
		boolean passwordstatus=true;
		while(passwordstatus)
		{
			String password=s.next();
			if(password.length()==4)
			{
				boolean checkpassword=false;
				for(BankCustomerDetails bankCustomerDetails1: allBankCustomerDetails)
				{
					if(bankCustomerDetails1.getPassword().equalsIgnoreCase(password)) {
						checkpassword=true;
					}
				}
				if(checkpassword)
				{
					System.out.println("Password already in use");
					passwordstatus=true;
				}
				else {
					passwordstatus=false;
					System.out.println("Enter your confirm password");
					boolean cpasswordstatus=true;
					while(cpasswordstatus) {
						String cpassword=s.next();
						if(password.equalsIgnoreCase(cpassword)) {
							bankCustomerDetails.setPassword(password);
							System.out.println("Enter your mobile number");
							boolean mobilestatus=true;
							while(mobilestatus) {
								long mobile=s.nextLong();
								if(mobile>=6000000001l && mobile<=9999999999l) {
									int count=0;
									for(BankCustomerDetails bankCustomerDetails1: allBankCustomerDetails)
									{
										if(bankCustomerDetails1.getMobile()==mobile)
										{
											count++;
										}
									}
									if(count>0)
									{
										System.out.println("Mobile number already in use");
										mobilestatus=true;
									}
									else {
										bankCustomerDetails.setMobile(mobile);
										System.out.println("Enter your adhar number");
										long aadhar=s.nextLong();
										bankCustomerDetails.setAadhar(aadhar);
										System.out.println("Enter your gender");
										String gender=s.next();
										bankCustomerDetails.setGender(gender);
										System.out.println("Enter your address");
										String address=s.next();
										bankCustomerDetails.setAddress(address);
										System.out.println("Enter your amount");
										double amount=s.nextDouble();
										bankCustomerDetails.setAmount(amount);
										System.out.println("Enter your date of birth(YYYY-MM-DD)");
										String dob=s.next();
										bankCustomerDetails.setDate(LocalDate.parse(dob));
										mobilestatus=false;
										Random random=new Random();
										int account=random.nextInt(10000000);
										if(account<1000000)
										{
											account+=1000000;
										}
										bankCustomerDetails.setAccountNo(account);
										int customerDetails=bankDAO.insertBankCustomerDetails(bankCustomerDetails);
										if(customerDetails!=0)
										{
											System.out.println("Registration successfull");
										}
										else {
											System.out.println("Server error 500");
										}
										if(customerDetails!=0)
										{
											if(gender.equals("male")) {
												System.out.println("Hello 😊😊 Mrs:"+fname+" "+lname);
												System.out.println("Your account number is : "+account);
											}
											else if(gender.equals("female")){
												System.out.println("Hello 😊😊 Miss:"+fname+" "+lname);
												System.out.println("Your account number id :"+account);
											}
											System.out.println("Registation Successfull");
										}
									}
								}
							}
							cpasswordstatus=false;
						}
					}
					passwordstatus=false;
				}
			}
		}
	}
	@Override
	public void userLogin() {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your emaild or mobile");
		String emailidOrMobile=s.next();
		System.out.println("Enter your password");
		String password=s.next();
		BankCustomerDetails bankCustomerDetails=new BankCustomerDetails();
		
		List<BankCustomerDetails> allBankCustomerDetails=bankDAO.getAllBankCustomerDetails();
		
		loginPersonDetails=bankDAO.getUserDetailsByUsingEmailIdOrMobile(emailidOrMobile, password);
		if(loginPersonDetails != null)
		{
			Random random=new Random();
			int otp=random.nextInt(10000);
			if(otp<=1000 ) {
				otp+=1000;
			}
			System.out.println("Your otp :"+otp);
			System.out.println("Enter otp to login");
			int userotp=s.nextInt();
			if(userotp==otp)
			{
				if(loginPersonDetails.getGender().equalsIgnoreCase("Male"))
				{
					toSleep("Hello Mr "+loginPersonDetails.getFname()+" "+loginPersonDetails.getLname());
				}
				if(loginPersonDetails.getGender().equalsIgnoreCase("Female"))
				{
					toSleep("Hello Miss "+loginPersonDetails.getFname()+" "+loginPersonDetails.getLname());
				}
				userFunctionalities();
			}
			else {
				System.out.println("Invalid Credentials");
			}
		}
	}
	@Override
	public void userFunctionalities() {
		boolean status=true;
		while(status)
		{
		System.out.println("Enter \n 1.For credit \n 2.For Debit\n3.To check balance\n4.To check statement");
		
		switch(s.nextInt())
		{
		case 1:
			System.out.println("Credit");
			credit();
			break;
		case 2:
			System.out.println("Debit");
			debit();
			break;
		case 3:
			System.out.println("Check balance");
			break;
		case 4:
			System.out.println("Check statement");
			break;
		default:
			System.out.println("Invalid option");
			break;
		}
		System.out.println("Do you want to continue \n yes \n no");
		if(s.next().equalsIgnoreCase("Yes"))
		{
			
		}else {
			status=false;
		}
		}
	}
	@Override
	public void debit() {
		System.out.println("Enter amount ");
		double userEnterAmount=s.nextDouble();
		if(userEnterAmount>=0)
		{
			double databaseamount=loginPersonDetails.getAmount();
			if(databaseamount>=userEnterAmount)
			{
				System.out.println("ok");
				double sub=databaseamount-userEnterAmount;
				long accountNo=loginPersonDetails.getAccountNo();
				if(bankDAO.updateAmountByUsingAccountNumber(sub, accountNo)!=0) {
					loginPersonDetails.setAmount(sub);
					BankStatementDetails bankStatementDetails=new BankStatementDetails();
					bankStatementDetails.setAccountNumber(accountNo);
					bankStatementDetails.setBalanceAmount(sub);
					bankStatementDetails.setTransactionAmount(userEnterAmount);
					 
					bankStatementDAO.insertBankStatement(bankStatementDetails);
					System.out.println("Amount debited Successfull");
				}
				else {
					System.out.println("Insufficient balance ");
				}
			}
			else {
				System.out.println("Insufficient amount");
			}
			
		}else {
			System.out.println("Invalid amount");
		}	
	}
	@Override
	public void credit() {
		System.out.println("Enter amount ");
		double userEnterAmount=s.nextDouble();
		if(userEnterAmount>=0)
		{
			double databaseamount=loginPersonDetails.getAmount();
			if(userEnterAmount!=0)
			{
				System.out.println("ok");
				double add=databaseamount+userEnterAmount;
				long accountNo=loginPersonDetails.getAccountNo();
				if(bankDAO.updateAmountByUsingAccountNumber(add, accountNo)!=0) {
					BankStatementDetails bankStatementDetails=new BankStatementDetails();
					bankStatementDetails.setAccountNumber(accountNo);
					bankStatementDetails.setBalanceAmount(add);
					bankStatementDetails.setTransactionAmount(userEnterAmount);
					 
					bankStatementDAO.insertBankStatement(bankStatementDetails);
					System.out.println("Amount Credited Successfull");
				}
				else {
					System.out.println("Insufficient amount ");
				}
			}
			else {
				System.out.println("Insufficient amount");
			}
			
		}else {
			System.out.println("Invalid amount");
		}	
	}
}


