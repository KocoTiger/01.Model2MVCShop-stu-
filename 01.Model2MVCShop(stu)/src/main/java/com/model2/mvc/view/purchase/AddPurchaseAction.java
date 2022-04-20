package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.vo.Product;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.user.vo.UserVO;

public class AddPurchaseAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		PurchaseVO purchaseVO = new PurchaseVO();
		
		//HTTP세션을 가져오게 세팅
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("user");
		
		purchaseVO.setBuyer(userVO);
		
		
		
		
		
		
		//포장지 완성
		Product product = new Product();
		
		product.setProdNo(request.getParameter(""));
		
		
		
		
		
		////////////////////화면단에서 가져오기 위해 아래의 방법을 이용/////////////////////
		purchaseVO.setProdName(request.getParameter("prodName"));
		purchaseVO.setProdDetail(request.getParameter("prodDetail"));
		purchaseVO.setManuDate(request.getParameter("manuDate"));
		purchaseVO.setPrice(Integer.parseInt(request.getParameter("price")));
		purchaseVO.setFileName(request.getParameter("fileName"));

		
		System.out.println(purchaseVO);
		
		PurchaseService service = new PurchaseServiceImpl();
		service.addPurchase(purchaseVO);
		
		
		return "forward:/purchase/addPurchaseView.jsp";
	
	
//		/////////////파일 업로드 추가 2022.04.16///////////////////////////////
//		///예전 방법 (최신 방법은 인터넷을 찾아서 해보라고 하심)
		///근데 다 쳤는데 무슨 에러가 너무 많이 뜸
		
//		if(FileUpload.isMultipartContent(request)) {
//			
//			String temDir =
//			"C:\\workspace\\01.Model2MVCShop(stu)\\src\\main\\webapp\\images\\uploadFiles\\";
//			//String temDir2="/uploadFiles/";
//			
//			DiskFileUpload fileUpload=new DiskFileUpload();
//			fileUpload.setRepositoryPath(temDir);
//			//setSizeThreshold의 크기를 벗어나게 되면 지정한 위치에 임시로 저장한다.
//			fileUpload.setSizeMax(1024*1024*10);
//			//최대 1메가 까지 업로드 가능 (1024*1024*100) <= 100MB
//			fileUpload.setSizeThreshold(1024*100); //한번에 100k 까지는 메모리에 저장
//			
//			if(request.getContentLength() < fileUpload.getSizeMax()) {
//				ProductVO productVO = new ProductVO();
//				
//				StringTokenizer token = null;
//				
//				//parseRequest()는 FileItem을 포함하고 있는 List 타입을 Return한다
//				List fileItemList = fileUpload.parseRequest(request);
//				int Size = fileItemList.size(); //html page에서 받은 값들의 개수를 구한다.
//				for (int i = 0; i < Size; i++) {
//					FileItem fileItem = (FileItem)fileItemList.get(i);
//					//isFormField()를 통해서 파일형식인지 파라미터인지 구분한다. 파라미터라면 true
//					if (fileItem.isFormField()) {
//						if (fileItem.getFieldName().equals("manuDate")) {
//							token = new StringTokenizer(fileItem.getString("euc-kr"), "-");
//							String manuDate = token.nextToken()+token.nextToken()+token.nextToken();
//						}
//						
//						else if(fileItem.getFieldName().equals("prodName"))
//							productVO.setProdName(fileItem.getString("euc-kr"));
//						else if(fileItem.getFieldName().equals("prodDetail"))
//							productVO.setProdDetail(fileItem.getString("euc-kr"));
//						else if(fileItem.getFieldName().equals("price"))
//							productVO.setPrice(Integer.parseInt(fileItem.getString("euc-kr")));
//					}else {//파일형식이면...
//						
//						if (fileItem.getSize() > 0) { //파일을 저장하는 if
//							int idx = fileItem.getName().lastIndexOf("\\");
//							//getName()은 경로를 다 가져오기 때문에 lastIndexOf로 잘라낸다
//							if(idx == -1) {
//								idx = fileItem.getName().lastIndexOf("/");
//							}
//							String fileName=fileItem.getName().substring(idx+1);
//							productVO.setFileName(fileName);
//							try {
//								File uploadedFile = new File(temDir, fileName);
//								fileItem.write(uploadedFile);
//							}catch(IOException e){
//								System.out.println(e);
//							}
//						}else {
//							productVO.setFileName("../../images/empty.GIF");
//						}
//					}//else
//				}//for
//				
//				ProductServiceImpl service = new ProductServiceImpl();
//				service.addProduct(productVO);
//				
//				request.setAttribute("prodvo", productVO);
//			}else {
//				//업로드하는 파일이 setSizeMax보다 큰 경우
//				int overSize = (request.getContentLength()/1000000);
//				System.out.
//						println("<script>alert(파일의 크기는 1MB까지 입니다. 올리신 파일 용량은"+overSize+"MB입니다');");
//				System.out.println("history.back();</script>");
//			}
//		}else {
//			System.out.println("인코딩 타입이 multipart/form-data가 아닙니다.");
//		}
//		
//		return "forward:/product/getProduct.jsp";
	}
}