package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.Product;

public class UpdateProductAction extends Action {
	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		System.out.println("======시작");
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		System.out.println("======시작"+prodNo);

		Product productVO = new Product();
		productVO.setProdNo(prodNo);
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		productVO.setManuDate(request.getParameter("manuDate"));
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));
		
		ProductService service = new ProductServiceImpl();
		service.updateProduct(productVO);
		
//		HttpSession session = request.getSession();
//		int sessionId = ((ProductVO)session.getAttribute("product")).getProdNo();
//	
//		if(sessionId == prodNo){
//			session.setAttribute("prod", productVO);
//		}
		
		return "redirect:/getProduct.do?prodNo="+prodNo;
	}
}