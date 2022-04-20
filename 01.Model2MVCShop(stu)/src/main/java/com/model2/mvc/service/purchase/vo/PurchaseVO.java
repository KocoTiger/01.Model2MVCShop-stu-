package com.model2.mvc.service.purchase.vo;

import java.sql.Date;

import com.model2.mvc.service.product.vo.Product;
import com.model2.mvc.service.user.vo.UserVO;


public class PurchaseVO {
	
	private Product purchaseProd;	//ProductVO타입의 구매물품 정보
	private UserVO buyer;			//UserVo타입의 구매자 정보 // 
	/* UserVO = (UserVO)session.getAttribute("user");
	 * => 로그인한 정보가 이렇게 하면 세팅이 된다.
	 */
	private String divyAddr;		//String 타입의 배송지 주소
	private String divyDate;		//String 타입의 배송희망 일자
	private String divyRequest;		//String 타입의 배송시 요구사항
	private Date orderDate;			//java.sql.Date타입의 구매 일자
	private String paymentOption;	//String 타입의 지불방식
	
	private String receiverName;	//String타입의 받는 사람 이름
	private String receiverPhone;	//String 타입의 받는사람 전화번호
	private String tranCode;		//String타입의 구매 상태 코드
	private int tranNo;				//int타입의 구매 번호 => prodNo같은 거네 ===> seq로 자동으로 매겨지는 번호
	
	public PurchaseVO(){
	}
	
	public UserVO getBuyer() {
		return buyer;
	}
	public void setBuyer(UserVO buyer) {
		this.buyer = buyer;
	}
	public String getDivyAddr() {
		return divyAddr;
	}
	public void setDivyAddr(String divyAddr) {
		this.divyAddr = divyAddr;
	}
	public String getDivyDate() {
		return divyDate;
	}
	public void setDivyDate(String divyDate) {
		this.divyDate = divyDate;
	}
	public String getDivyRequest() {
		return divyRequest;
	}
	public void setDivyRequest(String divyRequest) {
		this.divyRequest = divyRequest;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	public Product getPurchaseProd() {
		return purchaseProd;
	}
	public void setPurchaseProd(Product purchaseProd) {
		this.purchaseProd = purchaseProd;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getTranCode() {
		return tranCode;
	}
	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}
	public int getTranNo() {
		return tranNo;
	}
	public void setTranNo(int tranNo) {
		this.tranNo = tranNo;
	}
	
	@Override
	public String toString() {
		return "PurchaseVO [buyer=" + buyer + ", divyAddr=" + divyAddr
				+ ", divyDate=" + divyDate + ", divyRequest=" + divyRequest
				+ ", orderDate=" + orderDate + ", paymentOption="
				+ paymentOption + ", purchaseProd=" + purchaseProd
				+ ", receiverName=" + receiverName + ", receiverPhone="
				+ receiverPhone + ", tranCode=" + tranCode + ", tranNo="
				+ tranNo + "]";
	}
}