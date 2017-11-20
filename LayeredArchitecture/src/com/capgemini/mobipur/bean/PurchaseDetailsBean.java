package com.capgemini.mobipur.bean;

import java.time.LocalDate;

public class PurchaseDetailsBean {
	private int purchaseId;
	private String name;
	private String mailId;
	private String phnNo;
	private LocalDate purDate;
	private int mobileId;
	public PurchaseDetailsBean() {
		super();
	}
	public PurchaseDetailsBean(String name, String mailId,
			String phnNo, int mobileId) {
		super();
		
		this.name = name;
		this.mailId = mailId;
		this.phnNo = phnNo;
		
		this.mobileId = mobileId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPhnNo() {
		return phnNo;
	}
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	
	@Override
	public String toString() {
		return "PurchaseDetailsBean [purchaseId=" + purchaseId + ", name="
				+ name + ", mailId=" + mailId + ", phnNo=" + phnNo
				+ ", purDate=" + purDate + ", mobileId=" + mobileId + "]";
	}
	
	

	
}
