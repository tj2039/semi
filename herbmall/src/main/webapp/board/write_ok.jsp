<%@page import="java.sql.SQLException"%>
<%@page import="com.herbmall.board.model.BoardVO"%>
<%@page import="com.herbmall.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write_ok.jsp</title>
</head>
<body>
<%
	//write.jsp에서 post방식으로 서브밋됨
	request.setCharacterEncoding("utf-8");

	//1.
	String title =request.getParameter("title");
	String name =request.getParameter("name");
	String pwd =request.getParameter("pwd");
	String email =request.getParameter("email");
	String content =request.getParameter("content");
	
	String ip=request.getRemoteAddr();
	System.out.println("ip="+ip);
	
	ip=request.getRemoteHost();
	System.out.println("ip="+ip);
	
	//2.
	BoardDAO boardDao=new BoardDAO();
	BoardVO vo=new BoardVO();
	vo.setName(name);
	vo.setPwd(pwd);
	vo.setTitle(title);
	vo.setEmail(email);
	vo.setContent(content);
	try{
		int cnt=boardDao.insert(vo);
		
		//3.
		if(cnt>0){
		%>
		<script type="text/javascript">
			alert('글 등록되었습니다.');
			location.href="list.jsp";
		</script>
	  <%}else{%>
		<script type="text/javascript">
			alert('글 등록 실패!');
			history.back();
		</script>
	 <%	}
	}catch(SQLException e){
		e.printStackTrace()	;
	}
	
%>
</body>
</html>