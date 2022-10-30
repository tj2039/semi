<%@page import="com.herbmall.board.model.BoardVO"%>
<%@page import="com.herbmall.board.model.BoardDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.SQLClientInfoException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit_ok.jsp</title>
</head>
<body>
<%
	//edit.jsp에서 post방식으로 서브밋됨
	//1.
	request.setCharacterEncoding("utf-8");
	String no=request.getParameter("no");
	String title =request.getParameter("title");
	String name =request.getParameter("name");
	String pwd =request.getParameter("pwd");
	String email =request.getParameter("email");
	String content =request.getParameter("content");
	//2.
	BoardDAO dao=new BoardDAO();
	BoardVO vo= new BoardVO();
	vo.setNo(Integer.parseInt(no));
	vo.setTitle(title);
	vo.setName(name);
	vo.setPwd(pwd);
	vo.setEmail(email);
	vo.setContent(content);
	try{
		int cnt=dao.updateBoard(vo);
		//3.
		if(cnt>0){%>
			<script type="text/javascript">
				alert('글 수정되었습니다.');
				location.href="list.jsp";
			</script>
		<% }else{%>
			<script type="text/javascript">
				alert("글수정 실패!");
				history.go(-1);
			</script>
		
		<%}
	}catch(SQLException e){
		e.printStackTrace();
	}
	
%>
</body>
</html>