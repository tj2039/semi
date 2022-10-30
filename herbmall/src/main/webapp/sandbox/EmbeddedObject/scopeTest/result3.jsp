<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result3.jsp</title>
</head>
<body>
	<jsp:useBean id="counterVO" class="com.herbmall.test.CounterVO" 
		scope="session"></jsp:useBean>
	<h1>result3.jsp</h1>
	<hr>
	<p>count : <jsp:getProperty property="count" name="counterVO"/></p> 
	<a href="scope3.jsp">scope3.jsp로 이동</a>
	<br> <br>
	<p>세션 아이디 : <%=session.getId() %></p>
</body>
</html>