package com.capgemini.mobipur.dao;

import com.capgemeni.mobipur.exception.MobilePurchaseException;
import com.capgemini.mobipur.bean.PurchaseDetailsBean;

public interface IPurchaseDetailsDAO {
	public boolean insertPurchase(final PurchaseDetailsBean purchaseDetailsBean)
	throws MobilePurchaseException;
	
	public boolean deletePurchaseDetails(final int mobileId) throws MobilePurchaseException;

}
