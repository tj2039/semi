<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menuResult.jsp</title>
</head>
<body>
<h1>오늘 뭐 먹지?</h1>
<%
	String result=(String)request.getAttribute("result");
%>
추천 메뉴 : <%=result %>
</body>
</html>