package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.Product;



	public class AddPurchaseViewAction extends Action {

		public AddPurchaseViewAction() {
		}

		@Override
		public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("==========AddpurchaseView����==================");
			
			System.out.println("���� prodNO: "+request.getParameter("prodNo"));
			int prodNo=Integer.parseInt(request.getParameter("prodNo"));
			
			
			
			ProductService service=new ProductServiceImpl();
			Product vo=service.getProduct(prodNo);
			System.out.println("purchase getprodNo>>>>>:"+prodNo);
			System.out.println("purchase getprodNo vo>>>>>:"+vo);
			request.setAttribute("vo", vo);
			
			System.out.println("=========��==================");
			return "forward:/purchase/addPurchaseView.jsp";
		}

	}
