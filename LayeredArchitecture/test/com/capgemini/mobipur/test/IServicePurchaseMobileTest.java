package com.capgemini.mobipur.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemeni.mobipur.exception.MobilePurchaseException;
import com.capgemini.mobipur.bean.PurchaseDetailsBean;
import com.capgemini.mobipur.service.IServicePurchaseMobile;
import com.capgemini.mobipur.service.ServicePurchaseImpl;

public class IServicePurchaseMobileTest {
	
	private PurchaseDetailsBean PurchaseDetailsBean;
	
	@Before
	public void setUp() throws Exception {
		PurchaseDetailsBean =new PurchaseDetailsBean("abc","abc@abc.com","12345",1003);
	}

	@After
	public void tearDown() throws Exception {
		PurchaseDetailsBean = null;
	}

	@Test
	public void testInsertPurchaseDetails() {
		IServicePurchaseMobile servicePurchaseMobile = new ServicePurchaseImpl();
		try{
		assertTrue(servicePurchaseMobile.insertPurchaseDetails(PurchaseDetailsBean));
		
	}catch(MobilePurchaseException e){
		e.printStackTrace();
	}

}
}
