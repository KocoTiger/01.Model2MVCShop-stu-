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
		
		//HTTP������ �������� ����
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("user");
		
		purchaseVO.setBuyer(userVO);
		
		
		
		
		
		
		//������ �ϼ�
		Product product = new Product();
		
		product.setProdNo(request.getParameter(""));
		
		
		
		
		
		////////////////////ȭ��ܿ��� �������� ���� �Ʒ��� ����� �̿�/////////////////////
		purchaseVO.setProdName(request.getParameter("prodName"));
		purchaseVO.setProdDetail(request.getParameter("prodDetail"));
		purchaseVO.setManuDate(request.getParameter("manuDate"));
		purchaseVO.setPrice(Integer.parseInt(request.getParameter("price")));
		purchaseVO.setFileName(request.getParameter("fileName"));

		
		System.out.println(purchaseVO);
		
		PurchaseService service = new PurchaseServiceImpl();
		service.addPurchase(purchaseVO);
		
		
		return "forward:/purchase/addPurchaseView.jsp";
	
	
//		/////////////���� ���ε� �߰� 2022.04.16///////////////////////////////
//		///���� ��� (�ֽ� ����� ���ͳ��� ã�Ƽ� �غ���� �Ͻ�)
		///�ٵ� �� �ƴµ� ���� ������ �ʹ� ���� ��
		
//		if(FileUpload.isMultipartContent(request)) {
//			
//			String temDir =
//			"C:\\workspace\\01.Model2MVCShop(stu)\\src\\main\\webapp\\images\\uploadFiles\\";
//			//String temDir2="/uploadFiles/";
//			
//			DiskFileUpload fileUpload=new DiskFileUpload();
//			fileUpload.setRepositoryPath(temDir);
//			//setSizeThreshold�� ũ�⸦ ����� �Ǹ� ������ ��ġ�� �ӽ÷� �����Ѵ�.
//			fileUpload.setSizeMax(1024*1024*10);
//			//�ִ� 1�ް� ���� ���ε� ���� (1024*1024*100) <= 100MB
//			fileUpload.setSizeThreshold(1024*100); //�ѹ��� 100k ������ �޸𸮿� ����
//			
//			if(request.getContentLength() < fileUpload.getSizeMax()) {
//				ProductVO productVO = new ProductVO();
//				
//				StringTokenizer token = null;
//				
//				//parseRequest()�� FileItem�� �����ϰ� �ִ� List Ÿ���� Return�Ѵ�
//				List fileItemList = fileUpload.parseRequest(request);
//				int Size = fileItemList.size(); //html page���� ���� ������ ������ ���Ѵ�.
//				for (int i = 0; i < Size; i++) {
//					FileItem fileItem = (FileItem)fileItemList.get(i);
//					//isFormField()�� ���ؼ� ������������ �Ķ�������� �����Ѵ�. �Ķ���Ͷ�� true
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
//					}else {//���������̸�...
//						
//						if (fileItem.getSize() > 0) { //������ �����ϴ� if
//							int idx = fileItem.getName().lastIndexOf("\\");
//							//getName()�� ��θ� �� �������� ������ lastIndexOf�� �߶󳽴�
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
//				//���ε��ϴ� ������ setSizeMax���� ū ���
//				int overSize = (request.getContentLength()/1000000);
//				System.out.
//						println("<script>alert(������ ũ��� 1MB���� �Դϴ�. �ø��� ���� �뷮��"+overSize+"MB�Դϴ�');");
//				System.out.println("history.back();</script>");
//			}
//		}else {
//			System.out.println("���ڵ� Ÿ���� multipart/form-data�� �ƴմϴ�.");
//		}
//		
//		return "forward:/product/getProduct.jsp";
	}
}