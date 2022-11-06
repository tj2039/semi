<%@page import="java.sql.SQLException"%>
<%@page import="com.mymvc.board.model.BoardCommentService"%>
<%@page import="java.util.List"%>
<%@page import="com.mymvc.board.model.BoardCommentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>comment_ok.jsp</title>
</head>
<body>
<%
	//detail.jsp에서 post방식으로 서브밋 됨
	request.setCharacterEncoding("utf-8");
	//1. 입력 파라미터 읽어오기
	String name=request.getParameter("re_name");
	String pwd=request.getParameter("re_pwd");
	String content=request.getParameter("re_content");
	String bdNo=request.getParameter("bdNo");
	
	
	BoardCommentService bcs= new BoardCommentService();
	BoardCommentVo vo=new BoardCommentVo();
	vo.setName(name);
	vo.setPwd(pwd);
	vo.setContent(content);
	vo.setBdNo(Integer.parseInt(bdNo));
	//2. db작업\
	String msg="댓글 등록 실패", url="detail.jsp?no="+Integer.parseInt(bdNo);
	try{
		int cnt=bcs.insertCommnent(vo);
		
		//3.
		if(cnt>0){
			msg="댓글등록 성공";
		}
	}catch(SQLException e){
		e.printStackTrace()	;
	}
	request.setAttribute("msg", msg);
	request.setAttribute("url", url);
%>
<jsp:forward page="../common/message.jsp"></jsp:forward>
</body>
</html>
	