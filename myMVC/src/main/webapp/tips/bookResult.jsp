<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travelResult.jsp</title>
</head>
<body>
<h1>책 추천 결과</h1>
<%
	String result=(String)request.getAttribute("result");
%>

좋은 책 : <%=result %>
</body>
</html>