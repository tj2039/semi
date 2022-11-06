	<%@page import="java.sql.SQLException"%>
<%@page import="com.mymvc.pd.model.PdDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>pdDelete.jsp</title>
	</head>
	<body>
<%
	//pdDetail.jsp에서 [삭제]클릭하면 get 방식으로 이동	 
	//1. 요청 파라미터 읽어오기
	String no = request.getParameter("no");

	//2. db 작업
	PdDAO pdDao = new PdDAO();
	
	try{
	   int cnt = pdDao.deletePd(Integer.parseInt(no));
	   
	   //3. 결과처리
	   if(cnt > 0){
	      	response.sendRedirect("pdList.jsp");
	   }else{
		   	System.out.println("상품 삭제 실패!");
	      	response.sendRedirect("pdDetail.jsp?no="+no);
	   }
	}catch(SQLException e){
	   e.printStackTrace();
	}
		
	%>
	</body>
	</html>