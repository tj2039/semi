<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope4.jsp</title>
</head>
<body>
	<jsp:useBean id="counterVO" class="com.herbmall.test.CounterVO"
		scope="application"></jsp:useBean>
	<jsp:setProperty property="count" name="counterVO" />
	<h1>scope4.jsp</h1>
	<p>count : <jsp:getProperty property="count" name="counterVO" /></p>
	<a href="result4.jsp">result4.jsp</a>
	<br> <br>
	<p>세션 아이디 : <%=session.getId() %></p>
</body>
</html>