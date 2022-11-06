<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>messageView.jsp</title>
</head>
<body>
	<h1>뷰 페이지</h1>
	<%
		String result =(String)request.getAttribute("result");
	%>
	<h2>결과 : <%=result %></h2>
</body>
</html>