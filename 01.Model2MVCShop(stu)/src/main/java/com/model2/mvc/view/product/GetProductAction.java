package com.model2.mvc.view.product;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.Product;

public class GetProductAction extends Action {
	
	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		//request안에서는 항상 STring 상태이기떄문에 이경우 형변환이 필요
		int prodNo = (Integer.parseInt(request.getParameter("prodNo")));
		
		//Product vo = service.getProduct(prodNo); 여기 작업 DAO => DB => 다시 Impl => Action
		ProductService service = new ProductServiceImpl();
		
		//vo 에 정제된 데이터를 넣음
		Product vo = service.getProduct(prodNo);
		
		//request에다가 정제된 vo를 넣는다 (resqueset Session에 저장 한다는 개념)
		request.setAttribute("vo", vo);

		
		//Cookie
		String history;
	    Cookie cookie = null;
	      
	    Cookie[] cookies = request.getCookies();
	    
	    if (cookies != null && cookies.length > 0) {
	         
	    	for (int i = 0; i < cookies.length; i++) {
	           
	    		cookie = cookies[i];
	            	
	            if (cookie.getName().equals("history")) {
	               
	               history = URLDecoder.decode(cookie.getValue(),"euc-kr");
	               history +=","+vo.getProdNo();
	               System.out.println(history);
	               
	               cookie = new Cookie("history",URLEncoder.encode(history,"euc-kr"));
	               
	            }else {
	            	
	               cookie = new Cookie("history", Integer.toString(prodNo));
	            
	            }//end of else	            
	         }//end of for
	      }//end of if
	    
	      cookie.setMaxAge(-1);
	      response.addCookie(cookie);
		

		
		
		return "forward:/product/getProduct.jsp";
	}
}