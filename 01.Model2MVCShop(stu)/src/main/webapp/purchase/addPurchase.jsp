<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%@ page import="com.model2.mvc.service.purchase.vo.*" %>


<%
Purchase vo=(Purchase)request.getAttribute("purchaseVO");
%>










<html>
<head>
<title>Insert title here</title>
</head>

<body>

<form name="updatePurchase" action="/updatePurchaseView.do?tranNo=0" method="post">

������ ���� ���Ű� �Ǿ����ϴ�.

<table border=1>
	<tr>
		<td>��ǰ��ȣ</td>
		<td>10000</td>
		<td></td>
	</tr>
	<tr>
		<td>�����ھ��̵�</td>
		<td>admin</td>
		<td></td>
	</tr>
	<tr>
		<td>���Ź��</td>
		<td>
		
			�ſ뱸��
		
		</td>
		<td></td>
	</tr>
	<tr>
		<td>�������̸�</td>
		<td>admin</td>
		<td></td>
	</tr>
	<tr>
		<td>�����ڿ���ó</td>
		<td>010-1234-5678</td>
		<td></td>
	</tr>
	<tr>
		<td>�������ּ�</td>
		<td>����� ���ʱ�</td>
		<td></td>
	</tr>
		<tr>
		<td>���ſ�û����</td>
		<td>����</td>
		<td></td>
	</tr>
	<tr>
		<td>����������</td>
		<td>2022-04-22</td>
		<td></td>
	</tr>
</table>
</form>

</body>
</html>