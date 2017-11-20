package com.capgemini.mobipur.service;

import com.capgemeni.mobipur.exception.MobilePurchaseException;
import com.capgemini.mobipur.bean.PurchaseDetailsBean;

public interface IServicePurchaseMobile {
		public boolean insertPurchaseDetails(PurchaseDetailsBean purchaseDetailsBean)
		throws MobilePurchaseException;
		
		
		
		
}
