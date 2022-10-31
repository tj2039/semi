<%@page import="java.sql.SQLException"%>
<%@page import="com.herbmall.member.model.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="memberService" class="com.herbmall.member.model.MemberService" 
    	scope="session"></jsp:useBean>
<%
	//[1] register.jsp에서 get방식으로 이동(새창 열기)
	//[2] checkUserid.jsp에서 post방식으로 서브밋
	request.setCharacterEncoding("utf-8");	
	//1
	String userid=request.getParameter("userid");
	
	//2
	int result=0;
	if(userid!=null && !userid.isEmpty()){
		try{
			result=memberService.duplicateUserid(userid);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkUserid.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mainstyle.css"/>
<script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#btUse').click(function(){
			<%-- 
			opener.document.frm1.userid.value = "<%=userid%>"; 
			--%>
			$(opener.document).find('#userid').val("<%=userid%>");
			$(opener.document).find('#chkId').val("Y");
			self.close();
		});
	});
</script>
</head>
<body>
    <h2>아이디 중복 검사</h2>
 	<form name="frmUserid" method="post" action="checkUserid.jsp">
 		<label for="userid">아이디 : </label>
        <input type="text" name="userid" id="userid" value="<%=userid%>">
        <input type="submit" value="아이디 확인" >
        <%if(result==MemberService.EXIST_ID) {%>
	        <p>이미 등록된 아이디입니다. 다른 아이디를 입력하세요</p>
        <%}else if(result==MemberService.NOT_EXIST_ID){ %>
	        <input type="button" value="사용하기"  id="btUse">
        	<p>사용가능한 아이디입니다. [사용하기] 버튼을 클릭 하세요</p>
        <%} %>
</form>
</body>
</html>