<%@page import="java.sql.SQLException"%>
<%@page import="com.mybook.book.model.BookDTO"%>
<%@page import="com.mybook.book.model.BookDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookEdit.jsp</title>
<script type="text/javascript">
	
</script>
</head>
<body>
<%
	String no=request.getParameter("no");
	
	//2
	BookDAO2 bookDao=new BookDAO2();
	BookDTO dto=null;
	try{
		dto=bookDao.selectByNo(Integer.parseInt(no));
	}catch(SQLException e){
		e.printStackTrace();
	}
%>
<h2>도서 수정</h2>
	<form name="frmBook" method="post" action="bookEdit_ok.jsp">
		<input type="hidden" name="no" value="<%=no%>"><br> 
		도서명:<input type="text" name="title"value="<%=dto.getTitle()%>"><br>
		 가격:<input type="text" name="price" value="<%=dto.getPrice()%>"><br>
		 출판사:<input type="text" name="publisher" value="<%=dto.getPublisher()%>"><br>
		<br> <input type="submit" value="수정"> <input type="reset"
			value="취소">
	</form>
</body>
</html>