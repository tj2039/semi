<%@page import="com.herbmall.test.SimpleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usebeanTest_ok.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="SimpleVO" class="com.herbmall.test.SimpleVO"
	scope="page"></jsp:useBean>
	<%-- 
	<jsp:setProperty property="userid" name="SimpleVO"/>
	<jsp:setProperty property="name" name="SimpleVO"/>
	<jsp:setProperty property="no" name="SimpleVO"/> --%>
	
	<jsp:setProperty property="*" name="SimpleVO"/>
<%
	//기존방식
	/* String userid=request.getParameter("userid");
	String name=request.getParameter("name");
	String no=request.getParameter("no");
	
	SimpleVO vo=new SimpleVO();
	vo.setUserid(userid);
	vo.setName(name);
	vo.setNo(Integer.parseInt(no)); */
%>
<h1>요청 파라미터 값</h1>
<%-- 
<p>아이디 : <%=vo.getUserid() %></p>
<p>이름 : <%=vo.getName() %></p>
<p>번호 : <%=vo.getNo() %></p> --%>

id : <jsp:getProperty property="userid" name="SimpleVO"/> <br>
name : <jsp:getProperty property="name" name="SimpleVO"/> <br>
no : <jsp:getProperty property="no" name="SimpleVO"/>
</body>
</html>