package com.bank.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.BankCustomerDetails;

public class BankDAOImpl implements BankDAO
{
	private static final String url="jdbc:mysql://localhost:3306/teca62projects?user=root&password=root";
	private Connection connection;
	private static final String select="select * from bank_customer_details";
	private static final String insert="insert into bank_customer_details(fname, lname, email, password, mobile, aadhar, gender, address, accountNo, amount,dateofbirth)values(?,?,?,?,?,?,?,?,?,?,?)";

	@Override
	public List<BankCustomerDetails> getAllBankCustomerDetails() {
		try {
			connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(select);
			ResultSet result=ps.executeQuery();
			List<BankCustomerDetails> listBankCustomerDetails=new ArrayList<BankCustomerDetails>();
			if(result.next())
			{
				while(result.next())
				{
					BankCustomerDetails bankCustomerDetails=new BankCustomerDetails();
					bankCustomerDetails.setAadhar(result.getLong("aadhar"));
					bankCustomerDetails.setEmail(result.getString("email"));
					bankCustomerDetails.setPassword(result.getString("password"));
					bankCustomerDetails.setMobile(result.getLong("mobile"));
					listBankCustomerDetails.add(bankCustomerDetails);
				}
				return listBankCustomerDetails;
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	//fname, lname, email, password, mobile, aadhar, gender, address, accountNo, amount
	@Override
	public int insertBankCustomerDetails(BankCustomerDetails bankCustomerDetails)
	{
		try {
			connection=DriverManager.getConnection(url);
			PreparedStatement prepareStatement=connection.prepareStatement(insert);
			prepareStatement.setString(1, bankCustomerDetails.getFname());
			prepareStatement.setString(2, bankCustomerDetails.getLname());
			prepareStatement.setString(3, bankCustomerDetails.getEmail());
			prepareStatement.setString(4, bankCustomerDetails.getPassword());
			prepareStatement.setLong(5, bankCustomerDetails.getMobile());
			prepareStatement.setLong(6, bankCustomerDetails.getAadhar());
			prepareStatement.setString(7, bankCustomerDetails.getGender());
			prepareStatement.setString(8, bankCustomerDetails.getAddress());
			prepareStatement.setLong(9, bankCustomerDetails.getAccountNo());
			prepareStatement.setDouble(10, bankCustomerDetails.getAmount());
			LocalDate dateofbirth=bankCustomerDetails.getDate();
			prepareStatement.setDate(11, Date.valueOf(dateofbirth));
			
			
			return prepareStatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public BankCustomerDetails getUserDetailsByUsingEmailIdOrMobile(String emailidOrMobile,String password) {
		String login="select * from bank_customer_details where email=? or mobile=? and password=?";
		try {
			connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(login);
			preparedStatement.setString(1, emailidOrMobile);
			preparedStatement.setString(2,emailidOrMobile);
			preparedStatement.setString(3, password);
			ResultSet result=preparedStatement.executeQuery();
			if(result.next())
			{
				BankCustomerDetails bankCustomerDetails=new BankCustomerDetails();
				bankCustomerDetails.setFname(result.getString("fname"));
				bankCustomerDetails.setLname(result.getString("lname"));
				bankCustomerDetails.setGender(result.getString("gender"));
				bankCustomerDetails.setAmount(result.getDouble("amount"));
				bankCustomerDetails.setAccountNo(result.getLong("accountNo"));
				return bankCustomerDetails;
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public int updateAmountByUsingAccountNumber(double amount,long accountNo) {
		// TODO Auto-generated method stub
		String update="update bank_customer_details set amount=? where accountNo=?";
		try {
			connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(update);
			ps.setDouble(1, amount);
			ps.setLong(2, accountNo);
			return ps.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}	
}



