<%@page import="java.sql.SQLException"%>
<%@page import="com.mybook.book.model.BookDTO"%>
<%@page import="com.mybook.book.model.BookDAO2"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reply_ok.jsp</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");

	String title = request.getParameter("title");
	String price = request.getParameter("price");
	String publisher = request.getParameter("publisher");
	String groupNo = request.getParameter("groupNo");
	String step = request.getParameter("step");
	String sortNo = request.getParameter("sortNo");

	BookDTO dto = new BookDTO();

	dto.setTitle(title);
	dto.setPrice(Integer.parseInt(price));
	dto.setPublisher(publisher);
	dto.setGroupNo(Integer.parseInt(groupNo));
	dto.setStep(Integer.parseInt(step));
	dto.setSortNo(Integer.parseInt(sortNo));
	BookDAO2 dao = new BookDAO2();
	try {
		int cnt = dao.reply(dto);
		if (cnt > 0) {
	%>
	<script type="text/javascript">
		alert('책 부록 등록되었습니다');
		location.href = 'bookList.jsp';
	</script>
	<%
	} else {
	%>
	<script type="text/javascript">
		alert('책 부록 등록 실패');
		history.back();
	</script>
	<%
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	%>
</body>
</html>