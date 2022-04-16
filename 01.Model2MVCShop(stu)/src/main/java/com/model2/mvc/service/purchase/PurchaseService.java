package com.model2.mvc.service.purchase;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;

public interface PurchaseService {

	public void addPurchase(Purchase PurchaseVO) throws Exception;
	
	public Purchase getPurchase(int PurchaseVO) throws Exception;
	
	public HashMap<String, Object> getPurchaseList(SearchVO searchVO) throws Exception;
	
	public HashMap<String, Object> getSaleList(SearchVO searchVO) throws Exception;
	
	public void updatePurchase(Purchase purchaseVO) throws Exception;
	
	public void updateTranCode(Purchase purchaseVO) throws Exception;
	
}
