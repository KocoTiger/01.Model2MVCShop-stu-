package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.product.vo.Product;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.dao.PurchaseDAO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class PurchaseServiceImpl implements PurchaseService {
	
private PurchaseDAO purchaseDAO;
	
	public PurchaseServiceImpl() {
		purchaseDAO = new PurchaseDAO();
	}

	public void addPurchase(PurchaseVO purchaseVO) throws Exception {
		purchaseDAO.insertPurchase(purchaseVO);
	}

	public PurchaseVO getPurchase(Product purchaseProd) throws Exception {
		return purchaseDAO.findPurchase(purchaseProd);
	}

	public HashMap<String,Object> getPurchaseList(SearchVO searchVO) throws Exception {
		return purchaseDAO.getPurchaseList(searchVO);
	}

	public void updatePurchase(PurchaseVO purchaseVO) throws Exception {
		purchaseDAO.updatePurchase(purchaseVO);
	}

//	public boolean checkDuplication(Product purchaseProd) throws Exception {
//		boolean result = true;
//		PurchaseVO userVO = purchaseDAO.findProduct(prodNo);
//		if(userVO != null) {
//			result=false;
//		}
//		return result;
//	}
}