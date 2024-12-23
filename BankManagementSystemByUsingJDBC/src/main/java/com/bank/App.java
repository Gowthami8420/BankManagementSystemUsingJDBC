package com.bank;

import java.util.Scanner;

import com.bank.service.BankService;
import com.bank.service.CustomerRelationAssociater;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner s=new Scanner(System.in);
    	BankService bankservice=CustomerRelationAssociater.customerService();
    	bankservice.toSleep("***---***---Dinga Dingii Bank ---***---***");
    	while(true)
    	{
        	bankservice.toSleep("Enter \n 1.For Registration \n 2.For login");
    		switch(s.nextInt())
        	{
        	case 1:
        		bankservice.toSleep("***---**--*-Registration-*--**---***");
        		bankservice.userRegistration();
        		break;
        	case 2:
        		bankservice.toSleep("***---**--*-Login-*--**---***");
        		bankservice.userLogin();
        		break;
        	default:
        		bankservice.toSleep("***---**--*-Invalid Selection-*--**---***");
        		break;
        	}
        	System.out.println("Do you want to continue...");
        	String choice=s.next();
        	if(!choice.equalsIgnoreCase("yes"))
        	{
        		bankservice.toSleep("Thank you visit again");
        		break;
        	}
    	}    	
    }
}
