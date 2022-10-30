<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope2.jsp</title>
</head>
<body>
	<jsp:useBean id="counterVO" class="com.herbmall.test.CounterVO"
		scope="request"></jsp:useBean>
	<jsp:setProperty property="count" name="counterVO" />
	<h1>scope2.jsp</h1>
	<p>count : <jsp:getProperty property="count" name="counterVO" /></p>
	<jsp:forward page="result2.jsp"></jsp:forward>
</body>
</html>