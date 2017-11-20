package com.capgemini.mobipur.dao;

import java.util.List;

import com.capgemeni.mobipur.exception.MobilePurchaseException;
import com.capgemini.mobipur.bean.MobileBean;

public interface IMobileDAO {
	public boolean updateMobile(final int mobileId, final int quantity) throws MobilePurchaseException;
	
	public List<MobileBean> viewAll() throws MobilePurchaseException;
	
	public boolean deleteMobile(final int mobileId) throws MobilePurchaseException;
	
	public List<MobileBean> searc(final float minPrice, final float maxPrice) throws MobilePurchaseException;
	
	public int getQuantity(int mobileId) throws MobilePurchaseException;
}
