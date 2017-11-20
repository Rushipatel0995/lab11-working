package com.capgemini.mobipur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemeni.mobipur.exception.MobilePurchaseException;
import com.capgemini.mobipur.bean.MobileBean;
import com.capgemini.mobipur.util.DBConnection;

public class MobileDAOImpl implements IMobileDAO {

	@Override
	public boolean updateMobile(int mobileId, int quantity)
			throws MobilePurchaseException {
		int records=0;
		boolean isUpdated=false;
		try(Connection connMobile = DBConnection.getInstance().getConnection();	
	
	PreparedStatement preparedStatement=
		connMobile.prepareStatement(QueryMapperMobile.UPDATE_MOBILE);)
		{
			
			
			preparedStatement.setString(1,Integer.toString(quantity));
			
			preparedStatement.setInt(2, mobileId);
			
			records=preparedStatement.executeUpdate();
			
			if(records>0){
				isUpdated=true;
			}
			
		} catch(SQLException sqlEx){
			throw new MobilePurchaseException(sqlEx.getMessage());
		}
	return isUpdated;
	}

	@Override
	public List<MobileBean> viewAll() throws MobilePurchaseException {
		
		
		List<MobileBean>mobileList=new ArrayList<MobileBean>();
		try(Connection connMobile = DBConnection.getInstance().getConnection();	
	
	PreparedStatement preparedStatement=
		connMobile.prepareStatement(QueryMapperMobile.VIEW_MOBILES);
		ResultSet rsMobiles=preparedStatement.executeQuery();
				)
		{
			
		
			
			while(rsMobiles.next()){
				MobileBean mobile=new MobileBean();
				
				mobile.setMobileId(rsMobiles.getInt("mobileid"));
				mobile.setName(rsMobiles.getString("name"));
				mobile.setPrice(rsMobiles.getFloat("price"));
				mobile.setQuantity(rsMobiles.getString("quantity"));
				
				mobileList.add(mobile);
			}
			
			if(mobileList.size()==0){
				throw new MobilePurchaseException("No records Found");
			}
			
		} catch(SQLException sqlEx){
			throw new MobilePurchaseException(sqlEx.getMessage());
		}
	return mobileList;
	}

	@Override
	public boolean deleteMobile(int mobileId) throws MobilePurchaseException {
		int records=0;
		boolean isDeleted=false;
		try(Connection connPurchaseDetails = DBConnection.getInstance().getConnection();	
	
	PreparedStatement preparedStatement=
		connPurchaseDetails.prepareStatement(QueryMapperMobile.DELETE_MOBILES);)
		{
			
			preparedStatement.setInt(1, mobileId);
			
			records=preparedStatement.executeUpdate();
			
			if(records>0){
				isDeleted=true;
			}
			
		} catch(SQLException sqlEx){
			throw new MobilePurchaseException(sqlEx.getMessage());
		}
	return isDeleted;
	}

	@Override
	public List<MobileBean> searc(float minPrice, float maxPrice)
			throws MobilePurchaseException {
		List<MobileBean>mobileList=new ArrayList<MobileBean>();
		try(Connection connMobile = DBConnection.getInstance().getConnection();	
	
	PreparedStatement preparedStatement=
		connMobile.prepareStatement(QueryMapperMobile.SEARCH_MOBILES);
		)
		{
			
			preparedStatement.setFloat(1, minPrice);
			preparedStatement.setFloat(2, maxPrice);
			ResultSet rsMobiles=preparedStatement.executeQuery();
			
			while(rsMobiles.next()){
				MobileBean mobile=new MobileBean();
				
				mobile.setMobileId(rsMobiles.getInt("mobileid"));
				mobile.setName(rsMobiles.getString("name"));
				mobile.setPrice(rsMobiles.getFloat("price"));
				mobile.setQuantity(rsMobiles.getString("quantity"));
				
				mobileList.add(mobile);
			}
			
			if(mobileList.size()==0){
				throw new MobilePurchaseException("No records Found");
			}
			
		} catch(SQLException sqlEx){
			throw new MobilePurchaseException(sqlEx.getMessage());
		}
	return mobileList;
	}

	@Override
	public int getQuantity(int mobileId) throws MobilePurchaseException {
		int mobileQty=0;
		
		try(Connection connMobile = DBConnection.getInstance().getConnection();	
				
				PreparedStatement preparedStatement=
					connMobile.prepareStatement(QueryMapperMobile.GET_MOBILES);
					)
					{
						
						preparedStatement.setInt(1, mobileId);
						
						ResultSet rsMobiles=preparedStatement.executeQuery();
						
						if(rsMobiles.next()){
							mobileQty= Integer.parseInt(rsMobiles.getString("quantity"));
						}
						
					} catch(SQLException sqlEx){
						throw new MobilePurchaseException(sqlEx.getMessage());
					}
		
		return mobileQty;
	}

}
