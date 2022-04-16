package com.model2.mvc.service.purchase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.product.vo.Product;
import com.model2.mvc.service.product.vo.Purchase;

public class PurchaseDAO {
	
	//C
	public PurchaseDAO(){
	}
	
	//M
	public void insertPurchase(Purchase purchaseVO) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "INSERT INTO transaction VALUES (SEQ_TRANSACTION_TRAN_NO.NEXTVAL,?,?,TO_CHAR(TO_DATE(?, 'YYYY-MM-DD')),?,?,SYSDATE) " ;
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, purchaseVO.getProdName());
		stmt.setString(2, purchaseVO.getProdDetail());
		stmt.setString(3, purchaseVO.getManuDate());
		stmt.setInt(4, purchaseVO.getPrice());
		stmt.setString(5, purchaseVO.getFileName());
		stmt.executeUpdate();
		
		con.close();
	}

	public Purchase findPurchase(Product purchaseProd) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "SELECT * FROM transaction WHERE PROD_NO=? " ;
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, purchaseProd);

		ResultSet rs = stmt.executeQuery();

		Purchase productVO = null;
		while (rs.next()) {
			productVO = new Purchase();
			productVO.setProdNo(rs.getInt("PROD_NO"));
			productVO.setProdName(rs.getString("PROD_NAME"));
			productVO.setProdDetail(rs.getString("PROD_DETAIL"));
			productVO.setManuDate(rs.getString("MANUFACTURE_DAY"));
			productVO.setPrice(rs.getInt("PRICE"));
			productVO.setFileName(rs.getString("IMAGE_FILE"));
			productVO.setRegDate(rs.getDate("REG_DATE"));

		}
		
		con.close();

		return productVO;
	}

	public HashMap<String,Object> getProductList(SearchVO searchVO) throws Exception {
		
		Connection con = DBUtil.getConnection();
		
		String sql = "SELECT * FROM product ";
		if (searchVO.getSearchCondition() != null) {
			if (searchVO.getSearchCondition().equals("0")) {
				sql += "WHERE PROD_NO='" + searchVO.getSearchKeyword()
						+ "'";
			} else if (searchVO.getSearchCondition().equals("1")) {
				sql += "WHERE PROD_NAME='" + searchVO.getSearchKeyword()
						+ "'";
			}
		}
		sql += " ORDER BY PROD_NO ";

		PreparedStatement stmt = 
			con.prepareStatement(	sql,
														ResultSet.TYPE_SCROLL_INSENSITIVE,
														ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery();

		rs.last();
		int total = rs.getRow();
		System.out.println("로우의 수:" + total);

		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("count", new Integer(total));

		
		rs.absolute(searchVO.getPage() * searchVO.getPageUnit() - searchVO.getPageUnit()+1);
		System.out.println("searchVO.getPage():" + searchVO.getPage());
		System.out.println("searchVO.getPageUnit():" + searchVO.getPageUnit());

		ArrayList<Purchase> list = new ArrayList<Purchase>();
		if (total > 0) {
			for (int i = 0; i < searchVO.getPageUnit(); i++) {
				Purchase vo = new Purchase();
				vo.setProdNo(rs.getInt("PROD_NO"));
				vo.setProdName(rs.getString("PROD_NAME"));
				vo.setProdDetail(rs.getString("PROD_DETAIL"));
				vo.setManuDate(rs.getString("MANUFACTURE_DAY"));
				vo.setPrice(rs.getInt("PRICE"));
				vo.setFileName(rs.getString("IMAGE_FILE"));
				vo.setRegDate(rs.getDate("REG_DATE"));	

				list.add(vo);
				if (!rs.next())
					break;
			}
		}
		System.out.println("list.size() : "+ list.size());
		map.put("list", list);
		System.out.println("map().size() : "+ map.size());

		con.close();
			
		return map;
	}

	public void updateProduct(Purchase productVO) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "UPDATE product SET PROD_NAME=?,PROD_DETAIL=?,MANUFACTURE_DAY=?,PRICE=?,IMAGE_FILE=? WHERE PROD_NO=? " ;
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, productVO.getProdName());
		stmt.setString(2, productVO.getProdDetail());
		stmt.setString(3, productVO.getManuDate());
		stmt.setInt(4, productVO.getPrice());
		stmt.setString(5, productVO.getFileName());
		stmt.setInt(6, productVO.getProdNo());
		
		
		stmt.executeUpdate();
		
		con.close();
	}
}