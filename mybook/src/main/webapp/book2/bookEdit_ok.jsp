<%@page import="java.sql.SQLException"%>
<%@page import="com.mybook.book.model.BookDTO"%>
<%@page import="com.mybook.book.model.BookDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookEdit_ok.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	String no=request.getParameter("no");
	String title=request.getParameter("title");
	String price=request.getParameter("price");
	String publisher=request.getParameter("publisher");
	
	//2
	BookDAO2 bookDao= new BookDAO2();
	BookDTO dto= new BookDTO();
	dto.setNo(Integer.parseInt(no));
	dto.setTitle(title);
	dto.setPrice(Integer.parseInt(price));
	dto.setPublisher(publisher);
	try{		
		int cnt=bookDao.updateBook(dto);
		
		if(cnt>0){
			response.sendRedirect("bookList.jsp");
		}else{
			System.out.println("도서 수정 실패");
			response.sendRedirect("bookList.jsp");
			
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	//3
	
%>
</body>
</html>