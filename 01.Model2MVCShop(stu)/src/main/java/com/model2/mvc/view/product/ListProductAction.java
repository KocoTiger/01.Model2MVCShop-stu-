package com.model2.mvc.view.product;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

public class ListProductAction extends Action {
	
	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		SearchVO searchVO = new SearchVO();
		
		//현재 페이지 default값이 1페이지
		int page = 1;
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		
		searchVO.setPage(page);
		searchVO.setSearchCondition(request.getParameter("searchCondition"));
		searchVO.setSearchKeyword(request.getParameter("searchKeyword"));
		
		//getInitParameter 는 Web.xml에 현재 3으로 되어있어서 우리가 한 페이지를 볼때 3개 항목 씩 뜬다
		//웹 애플리케이션 단위로 정보를 서버 쪽에 유지할 수 있는 방법은 ServletContext 객체를 사용하는 것입니다
		//ServletContext 객체는 웹 애플리케이션과 생명주기(life cycle)가 같습니다
		String pageUnit = getServletContext().getInitParameter("pageSize");
		searchVO.setPageUnit(Integer.parseInt(pageUnit));
		
		ProductService service = new ProductServiceImpl();
		HashMap<String,Object> map = service.getProductList(searchVO);

		request.setAttribute("map", map);
		request.setAttribute("searchVO", searchVO);
		
		return "forward:/product/listProduct.jsp";
	}
}