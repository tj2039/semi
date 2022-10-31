<%@page import="java.sql.SQLException"%>
<%@page import="com.herbmall.member.model.MemberVO"%>
<%@page import="com.herbmall.member.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register2_ok.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="memberVo" class="com.herbmall.member.model.MemberVO" 
	scope="page"></jsp:useBean>
<jsp:useBean id="memberDao" class="com.herbmall.member.model.MemberDAO" 
	scope="page"></jsp:useBean>
	
<jsp:setProperty property="*" name="memberVo"/>
	<%
		String msg="회원가입 실패", url="register2.jsp";
		try{
			int cnt = memberDao.insertMem(memberVo);
			if(cnt>0){
				msg="회원가입되었습니다.";
				url="../index.jsp";
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
	%>
<jsp:forward page="../common/message.jsp"></jsp:forward>
<!-- forward, include 액션 태그=> request 공유 
	현재 페이지와 message.jsp 페이지는 request를 공유함(동일한 request를 갖는다)
-->
</body>
</html>