package com.model2.mvc.service.product.impl;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.product.vo.Product;

public class ProductServiceImpl implements ProductService {
	
private ProductDAO productDAO;
	
	public ProductServiceImpl() {
		productDAO = new ProductDAO();
	}

	public void addProduct(Product productVO) throws Exception {
		productDAO.insertProduct(productVO);
	}

	public Product getProduct(int prodNo) throws Exception {
		return productDAO.findProduct(prodNo);
	}

	public HashMap<String,Object> getProductList(SearchVO searchVO) throws Exception {
		return productDAO.getProductList(searchVO);
	}

	public void updateProduct(Product productVO) throws Exception {
		productDAO.updateProduct(productVO);
	}

	public boolean checkDuplication(int prodNo) throws Exception {
		boolean result = true;
		Product userVO = productDAO.findProduct(prodNo);
		if(userVO != null) {
			result=false;
		}
		return result;
	}
}