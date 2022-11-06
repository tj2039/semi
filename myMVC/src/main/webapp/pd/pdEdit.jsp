<%@page import="com.mymvc.pd.model.PdDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 뷰페이지
	PdDTO dto= (PdDTO)request.getAttribute("dto");
	String no=request.getParameter("no");
	
	//3. 결과처리
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품 수정</h2>
<form name="frmPd" method="post" action="<%=request.getContextPath()%>/pd/pdEdit_ok.do">
	<!-- 수정시 no가 필요하므로 hidden 필드에 넣어서 보낸다 -->
	<input type="hidden" name="no" value="<%=no%>">
		
	상품명:<input type="text" name="pdName" 
		value="<%=dto.getPdName()%>"><br>
	가 격:<input type="text" name="price" 
		value="<%=dto.getPrice()%>">원<br><br>
	<input type="submit" value="수정">
	<input type="reset" value="취소">	
</form>

<br><br>
<a href="<%=request.getContextPath()%>/pd/pdList.do">상품 목록</a>
</body>
</html>