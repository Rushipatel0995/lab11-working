package com.capgemini.mobipur.service;

import java.util.List;

import com.capgemeni.mobipur.exception.MobilePurchaseException;
import com.capgemini.mobipur.bean.MobileBean;

public interface IServiceMobile {
	
	
	public List<MobileBean> viewAll()throws MobilePurchaseException;
	
	public boolean deleteMobile(int mobileId)throws MobilePurchaseException;
	
	public List<MobileBean>search(float minPrice,float maxPrice)throws MobilePurchaseException;
	
	
	
	
}
