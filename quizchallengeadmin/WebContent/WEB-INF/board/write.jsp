<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 이 작업을 Controller에서 해야한다!
	// Object mid = session.getAttribute("mid");
	
	// if(null == mid){
	//	response.sendRedirect("login.jsp");
	//	return;
	//}
	
%>
   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>USER NAME : ${mid}</h1>
</body>
</html>