<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope1.jsp</title>
</head>
<body>
	<jsp:useBean id="counterVO" class="com.herbmall.test.CounterVO"
		scope="page"></jsp:useBean>
	<jsp:setProperty property="count" name="counterVO" />
	<h1>scope1.jsp</h1>
	<p>count : <jsp:getProperty property="count" name="counterVO" /></p>
	<a href="result1.jsp">result1.jsp</a>
</body>
</html>