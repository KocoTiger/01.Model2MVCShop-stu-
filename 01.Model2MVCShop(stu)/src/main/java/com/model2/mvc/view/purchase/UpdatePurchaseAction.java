package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class UpdatePurchaseAction extends Action {
	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		System.out.println("======시작");
		PurchaseVO purchaseProd = request.getParameter("purchaseProd");
		System.out.println("======시작"+purchaseProd);

		PurchaseVO purchaseVO = new PurchaseVO();
		purchaseVO.setPurchaseProd(purchaseProd);
		purchaseVO.setProdName(request.getParameter("prodName"));
		purchaseVO.setProdDetail(request.getParameter("prodDetail"));
		purchaseVO.setManuDate(request.getParameter("manuDate"));
		purchaseVO.setPrice(Integer.parseInt(request.getParameter("price")));
		
		PurchaseService service = new PurchaseServiceImpl();
		service.updatePurchase(purchaseVO);
		
//		HttpSession session = request.getSession();
//		int sessionId = ((ProductVO)session.getAttribute("product")).getProdNo();
//	
//		if(sessionId == prodNo){
//			session.setAttribute("prod", productVO);
//		}
		
		return "redirect:/getPurchase.do?purchaseProd="+purchaseProd;
		///////////////////////////////////////////
		
//		int prodNo=0;
//		if(FileUpload.isMultipartContent(request)) {
//			
//			String temDir = 
//			"C:\\workspace\\01.Model2MVCShop(stu)\\src\\main\\webapp\\images\\uploadFiles\\";
//			//String temDir2 = "/uploadFiles/";
//			
//			DiskFileUpload fileUpload = new DiskFileUpload();
//			fileUpload.setRepositoryPath(temDir);
//			//setSizeThreshold의 크기를 벗어나게 되면 지정한 위치에 임시로 저장한다.
//			fileUpload.setSizeMax(1024*1024*100);
//			//최대 1메가까지 업로드 가능 (1024*1024*100) <- 100MB
//			fileUpload.setSizeThreshold(1024*100); //한번에 100k까지는 메모리에 저장
//			
//			if(request.getContentLength() < fileUpload.getSizeMax()) {
//				ProductVO productVO = new ProductVO();
//				StringTokenizer token = null;
//				
//				ProductServiceImpl service = new ProductServiceImpl();
//				
//				//parseRequest()는 FileItem을 포함하고 있는 List타입을 리턴한다
//				List fileItemList = fileUpload.parseRequest(request);
//				int Size = fileItemList.size(); //html page에서 받은 값들의 개수를 구한다.
//				for(int i=0; i<Size; i++) {
//					FileItem fileItem = (FileItem)fileItemList.get(i);
//					//isFormFiel()를 통해서 파일형식인지 파라미터인지 구분한다. 파라미터하면 true
//					if(fileItem.isFormField()) {
//						if(fileItem.getFieldName().equals("manuDate")) {
//							token = new StringTokenizer(fileItem.getString("eux-kr"), "-");
//							String manuDate = token.nextToken();
//							while(token.hasMoreTokens())
//									manuDate +=token.nextToken();
//							productVO.setManuDate(manuDate);
//						}else if (fileItem.getFieldName().equals("prodName"))
//							productVO.setProdName(fileItem.getString("euc-kr"));
//						else if (fileItem.getFieldName().equals("prodDetail"))
//							productVO.setProdDetail(fileItem.getString("euc-kr"));
//						else if (fileItem.getFieldName().equals("price"))
//							productVO.setPrice(Integer.parseInt(fileItem.getString("euc-kr")));
//						else if (fileItem.getFieldName().equals("prodNo")) {
//							prodNo=Integer.parseInt(fileItem.getString("euc-kr"));
//							productVO.setProdNo(prodNo);
//						}
//					}else {	//파일형식이면...
//						
//						if(fileItem.getSize() > 0) { //파일을 저장하는 if
//							int idx = fileItem.getName().lastIndexOf("\\");
//							//getName()은 경로를 다 가져오기 때문에 lastIndexOf로 잘라낸다
//							if(idx==-1) {
//								idx=fileItem.getName().lastIndexOf("/");
//							}
//							String fileName = fileItem.getName().substring(idx+1);
//							productVO.setFileName(fileName);
//							try {
//								File uploadedFile = new File(temDir, fileName);
//								fileItem.write(uploadedFile);
//							}catch(IOException e) {
//								System.out.println(e);
//							}
//						}else {
//							productVO.setFileName("../../images/empty.GIF");
//						}	
//					}//else
//				}//for
//				service.updateProduct(productVO);
//				
//				request.setAttribute("prodvo", productVO);
//			}else { // 업로드하는 파일이 setSizeMax보다 큰 경우
//				int overSize = (request.getContentLength() / 1000000);
//				System.out.
//						println("<script>alert('파일의 크기는 1MB까지 입니다. 올리신 파일 용량은"+overSize+"MB입니다')");
//				System.out.println("history.back(); </script>");
//			}
//		}else {
//			System.out.println("인코딩 타입이 multipart/form-data가 아닙니다..");
//		}
//		return "redirect:/getProduct.do?prodNo="+ prodNo+"&menu=ok";

	}
}