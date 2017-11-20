package com.capgemeni.mobipur.pi;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemeni.mobipur.exception.MobilePurchaseException;
import com.capgemini.mobipur.bean.MobileBean;
import com.capgemini.mobipur.bean.PurchaseDetailsBean;
import com.capgemini.mobipur.service.ServiceMobileImpl;
import com.capgemini.mobipur.service.ServicePurchaseImpl;

public class MobilePurchaseMain {
	private static Logger logger=Logger.getRootLogger();
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("resources/log4j.properties");
		
		boolean isInProcess=true;
		boolean isValid=false;
		byte choice=0;
		
		String cname=null;
		String mailId=null;
		String phoneNo=null;
		
		int mobileId=0;
		
		PurchaseDetailsBean purchaseDetailsBean=null;
		
		List<MobileBean>mobileList = null;
		
		ServiceMobileImpl serviceMobile=new ServiceMobileImpl();
		ServicePurchaseImpl servicePurchaseMobile=new ServicePurchaseImpl();
		
		Scanner scInput=new Scanner(System.in);
		
		while(isInProcess){
			System.out.println("1. Insert Mobile Purchase.");
			System.out.println("2. View all mobiles.");
			System.out.println("3. Delete mobile details.");
			System.out.println("4. Search mobiles for a range.");
			System.out.println("0. Exit.");
			
			choice=Byte.parseByte(scInput.nextLine());
			
			switch(choice){
			case 1:
				
				while(!isValid){
				try{
				System.out.println("Enter customer name:");
				cname=scInput.nextLine();
				
				isValid = servicePurchaseMobile.isValidCName(cname);
				}catch(MobilePurchaseException mpe){
					logger.error("Invalid name: "+cname);
					System.err.println("Invalid name: "+cname);
					isValid=false;
				}
				}
				
				isValid=false;
				
				while(!isValid){
					try{
					System.out.println("Enter Mail Id:");
					mailId=scInput.nextLine();
					
					isValid = servicePurchaseMobile.isValidMail(mailId);
					}catch(MobilePurchaseException mpe){
						logger.error("Invalid Mail Id: "+mailId);
						isValid=false;
					}
					}
				isValid=false;
				
				while(!isValid){
					try{
					System.out.println("Enter Phone Number:");
					phoneNo=scInput.nextLine();
					
					isValid = servicePurchaseMobile.isValidPhoneNo(phoneNo);
					}catch(MobilePurchaseException mpe){
						logger.error("Invalid Phone Number: "+phoneNo);
						isValid=false;
					}
					}
				isValid=false;
				
				while(!isValid){
					try{
					System.out.println("Enter Mobile Id:");
					mobileId=Integer.parseInt(scInput.nextLine());
					
					isValid = serviceMobile.isValidMobileId(mobileId);
					}catch(MobilePurchaseException mpe){
						logger.error("Invalid Mobile Id "+mobileId);
						isValid=false;
					}
					}
				
				purchaseDetailsBean=new PurchaseDetailsBean(cname,mailId,phoneNo,mobileId);
				
				try{
					servicePurchaseMobile.insertPurchaseDetails(purchaseDetailsBean);
					System.out.println("Inserted succesfully!");
				} catch(MobilePurchaseException e){
					logger.error(e.getMessage());
				}
				break;
				
			case 2:
				try {
					mobileList = serviceMobile.viewAll();
					
					for (MobileBean mobileBean : mobileList) {
						System.out.println(mobileBean);
					}
					System.out.println("=====================================================");
					
				} catch(MobilePurchaseException e){
					logger.error(e.getMessage());
				}
				break;
			case 3:
				isValid=false;
				
				while(!isValid){
					try{
					System.out.println("Enter Mobile Id:");
					mobileId=Integer.parseInt(scInput.nextLine());
					
					isValid = serviceMobile.isValidMobileId(mobileId);
					}catch(MobilePurchaseException mpe){
						logger.error("Invalid Mobile Id "+mobileId);
						isValid=false;
						}
					}
				
				try {
					boolean isDeleted = serviceMobile.deleteMobile(mobileId);
					
					if(isDeleted){
						System.out.println("Mobile record deleted successfully");
					}
				} catch (MobilePurchaseException e) {
					logger.error(e.getMessage());
				}
				break;
			case 4:
				float minPrice = 0;
				float maxPrice = 0;
				
				System.out.println("Enter minimum price: ");
				minPrice=Float.parseFloat(scInput.nextLine());
				System.out.println("Enter maximum price: ");
				maxPrice=Float.parseFloat(scInput.nextLine());
				
				try{
					mobileList = serviceMobile.search(minPrice, maxPrice);
					
					for (MobileBean mobileBean : mobileList) {
						System.out.println(mobileBean);
					}
					System.out.println("==============================================================");
				} catch(MobilePurchaseException e){
					logger.error(e.getMessage());
				}
				break;
			case 0:
				isInProcess=false;
				System.out.println("Thanks for shopping!");
				break;
			default:
				System.out.println("Invalid Input!");
				logger.error("Invalid input: "+ choice);
				break;
			}
		}
		
			scInput.close();
}
}
