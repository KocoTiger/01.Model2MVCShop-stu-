<%@ page contentType="text/html; charset=euc-kr" %>

<%@ page import="com.model2.mvc.service.user.vo.*" %>

<%
	UserVO vo=(UserVO)session.getAttribute("user");
%>

<html>
<head>
<title>Model2 MVC Shop</title>

<link href="/css/left.css" rel="stylesheet" type="text/css">

</head>

<body topmargin="0" leftmargin="0">
 
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="800" height="30"><h2>Model2 MVC Shop</h2></td>
    <td height="30" >&nbsp;</td>
  </tr>
  <tr>
    <td height="20" align="right" background="/images/img_bg.gif">
	    <table width="200" border="0" cellspacing="0" cellpadding="0">
	        <tr> 
	          <td width="115">
	          <%
	          	if(vo == null) {
	          %>
	          <!-- 세션에 유저 정보가 없을시 로그인(/user/loginView.jsp) 이동 -->
	              <a href="/user/loginView.jsp" target="rightFrame">login</a>   
	          <%
	          	}
	          %>        
	          </td>
	          <td width="14">&nbsp;</td>
	          <td width="56">
	          <%
	          	if(vo != null) {
	          %>
	          <!-- 세션에 유저 정보가 있다면 logout버튼("/logout.do") 활성화 -->
	            <a href="/logout.do" target="_parent">logout</a>  
	           <%
	          	}
	           %>
	          </td>
	        </tr>
	    </table>
    </td>
    <td height="20" background="/images/img_bg.gif">&nbsp;</td>
  </tr>
</table>

</body>
</html>
