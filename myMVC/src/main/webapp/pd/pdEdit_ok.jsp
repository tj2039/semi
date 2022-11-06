<%@page import="com.mymvc.pd.model.PdDTO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.mymvc.pd.model.PdDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdEdit_ok.jsp</title>
</head>
<body>
<%
	//pdEdit.jsp에서 post방식으로 서브밋됨
	request.setCharacterEncoding("UTF-8");

	//1. 요청 파라미터 읽어오기
	String pdName =request.getParameter("pdName");
	String price =request.getParameter("price");
	String no =request.getParameter("no");
	
	//2. db작업
	PdDAO pdDao = new PdDAO();
	PdDTO dto = new PdDTO();
	dto.setNo(Integer.parseInt(no));
	dto.setPrice(Integer.parseInt(price));
	dto.setPdName(pdName);
	
	try{
		int cnt=pdDao.updatePd(dto);
		
		//3. 결과 처리
		if(cnt>0){
			response.sendRedirect("pdDetail.jsp?no="+no);
		}else{
			System.out.println("상품 수정실패");
			response.sendRedirect("pdEdit.jsp?no="+no);			
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	
%>
</body>
</html>




