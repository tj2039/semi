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

<jsp:useBean id="memberVO" class="com.herbmall.member.model.MemberVO" 
	scope="page"></jsp:useBean>
<jsp:useBean id="memberDAO" class="com.herbmall.member.model.MemberDAO" 
	scope="page"></jsp:useBean>
	
<jsp:setProperty property="*" name="memberVO"/>
	<%
		try{
			int cnt = memberDAO.insertMem(memberVO);
			if(cnt>0){ %>
				<script type="text/javascript">
					alert("회원가입 성공");
					location.href="../index.jsp";				
				</script>
	<%		}else{ %>
				<script type="text/javascript">
					alert("회원가입 실패!");
					history.back();
				</script>
	<%		}
		}catch(SQLException e){
			e.printStackTrace();
		}
	%>
</body>
</html>