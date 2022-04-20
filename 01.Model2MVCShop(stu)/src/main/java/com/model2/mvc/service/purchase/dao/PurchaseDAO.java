package com.model2.mvc.service.purchase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.product.vo.Purchase;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class PurchaseDAO {
	
	//C
	public PurchaseDAO(){
	}
	
	//M
	public void insertPurchase(PurchaseVO purchaseVO) throws Exception {
		
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

	public PurchaseVO findPurchase(PurchaseVO purchaseVO) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "SELECT * FROM transaction WHERE buyer_id=? " ;
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, purchaseProd);

		ResultSet rs = stmt.executeQuery();

		PurchaseVO purchaseVO = null;
		while (rs.next()) {
			purchaseVO = new PurchaseVO();
			purchaseVO.setProdNo(rs.getInt("PROD_NO"));
			purchaseVO.setProdName(rs.getString("PROD_NAME"));
			purchaseVO.setProdDetail(rs.getString("PROD_DETAIL"));
			purchaseVO.setManuDate(rs.getString("MANUFACTURE_DAY"));
			purchaseVO.setPrice(rs.getInt("PRICE"));
			purchaseVO.setFileName(rs.getString("IMAGE_FILE"));
			purchaseVO.setRegDate(rs.getDate("REG_DATE"));

		}
		
		con.close();

		return purchaseVO;
	}

	public HashMap<String,Object> getPurchaseList(SearchVO searchVO) throws Exception {
		
		Connection con = DBUtil.getConnection();
		
		String sql = "SELECT * FROM transaction ";
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

		ArrayList<PurchaseVO> list = new ArrayList<PurchaseVO>();
		if (total > 0) {
			for (int i = 0; i < searchVO.getPageUnit(); i++) {
				PurchaseVO vo = new PurchaseVO();
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

	public void updatePurchase(PurchaseVO purchaseVO) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "UPDATE transaction SET PROD_NAME=?,PROD_DETAIL=?,MANUFACTURE_DAY=?,PRICE=?,IMAGE_FILE=? WHERE PROD_NO=? " ;
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, purchaseVO.getProdName());
		stmt.setString(2, purchaseVO.getProdDetail());
		stmt.setString(3, purchaseVO.getManuDate());
		stmt.setInt(4, purchaseVO.getPrice());
		stmt.setString(5, purchaseVO.getFileName());
		stmt.setInt(6, purchaseVO.getProdNo());
		
		
		stmt.executeUpdate();
		
		con.close();
	}
}