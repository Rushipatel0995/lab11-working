package com.capgemini.mobipur.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemeni.mobipur.exception.MobilePurchaseException;
import com.capgemini.mobipur.bean.MobileBean;
import com.capgemini.mobipur.dao.IMobileDAO;
import com.capgemini.mobipur.dao.IPurchaseDetailsDAO;
import com.capgemini.mobipur.dao.MobileDAOImpl;
import com.capgemini.mobipur.dao.PurchaseDetailsDAOImpl;

public class ServiceMobileImpl implements IServiceMobile {
	
	private IMobileDAO mobileDAO;
	
	public ServiceMobileImpl() {
		mobileDAO = new MobileDAOImpl();
	}
	
	@Override
	public List<MobileBean> viewAll() throws MobilePurchaseException {
		List<MobileBean> mobileList = mobileDAO.viewAll();
		return mobileList;
	}

	
	@Override
	public boolean deleteMobile(int mobileId) throws MobilePurchaseException {
		
		IPurchaseDetailsDAO purchaseDetailsDAO= new PurchaseDetailsDAOImpl();
		boolean isPurchasedDeleted = purchaseDetailsDAO.deletePurchaseDetails(mobileId);
		boolean isDeleted = mobileDAO.deleteMobile(mobileId);
		return (isDeleted && isPurchasedDeleted);
		
	}

	
	@Override
	public List<MobileBean> search(float minPrice, float maxPrice)
			throws MobilePurchaseException {
		
		List<MobileBean> mobileList=mobileDAO.searc(minPrice, maxPrice);
		return mobileList;
	
	}

	public boolean isValidMobileId(int mobileId) throws MobilePurchaseException{
		boolean isValid=false;
		
		String mobile=Integer.toString(mobileId);
		String pattern="[\\d]{4}";
		Pattern ptn=Pattern.compile(pattern);
		Matcher matcher=ptn.matcher(mobile);
		
		isValid=matcher.matches();
		if(!isValid){
			throw new MobilePurchaseException("Invalid mobile id.");
		}
		return isValid;
	}
	
}
