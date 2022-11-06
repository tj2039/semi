<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>여행지 추천 결과</h1>
<%
 String result =(String)request.getAttribute("result");
%>
좋은 여행지 : <%=result %>
</body>
</html>