package com.model2.mvc.service.purchase.vo;

import java.sql.Date;

import com.model2.mvc.service.product.vo.Product;
import com.model2.mvc.service.user.vo.UserVO;


public class PurchaseVO {
	
	private Product purchaseProd;	//ProductVOŸ���� ���Ź�ǰ ����
	private UserVO buyer;			//UserVoŸ���� ������ ���� // 
	/* UserVO = (UserVO)session.getAttribute("user");
	 * => �α����� ������ �̷��� �ϸ� ������ �ȴ�.
	 */
	private String divyAddr;		//String Ÿ���� ����� �ּ�
	private String divyDate;		//String Ÿ���� ������ ����
	private String divyRequest;		//String Ÿ���� ��۽� �䱸����
	private Date orderDate;			//java.sql.DateŸ���� ���� ����
	private String paymentOption;	//String Ÿ���� ���ҹ��
	
	private String receiverName;	//StringŸ���� �޴� ��� �̸�
	private String receiverPhone;	//String Ÿ���� �޴»�� ��ȭ��ȣ
	private String tranCode;		//StringŸ���� ���� ���� �ڵ�
	private int tranNo;				//intŸ���� ���� ��ȣ => prodNo���� �ų� ===> seq�� �ڵ����� �Ű����� ��ȣ
	
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