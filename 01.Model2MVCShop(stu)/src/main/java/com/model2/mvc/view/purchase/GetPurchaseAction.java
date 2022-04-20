package com.model2.mvc.view.purchase;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class GetPurchaseAction extends Action {
	
	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		int purchaseProd = (Integer.parseInt(request.getParameter("purchaseProd")));
		
		PurchaseService service = new PurchaseServiceImpl();
		PurchaseVO vo = service.getPurchase(purchaseProd);
		
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
	               history +=","+vo.getPurchaseProd();
	               System.out.println(history);
	               
	               cookie = new Cookie("history",URLEncoder.encode(history,"euc-kr"));
	               
	            }else {
	            	
	               cookie = new Cookie("history", Integer.toString(purchaseProd));
	            
	            }//end of else	            
	         }//end of for
	      }//end of if
	    
	      cookie.setMaxAge(-1);
	      response.addCookie(cookie);
		

		
		
		return "forward:/purchase/getPurchase.jsp";
	}
}