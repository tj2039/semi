<%@page import="java.sql.SQLException"%>
<%@page import="com.herbmall.board.model.BoardVO"%>
<%@page import="com.herbmall.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>자유게시판 글 수정 - 허브몰</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="../css/mainstyle.css" />
<link rel="stylesheet" type="text/css" href="../css/clear.css" />
<link rel="stylesheet" type="text/css" href="../css/formLayout.css" />
<link rel="stylesheet" type="text/css" href="../css/mystyle.css" />

<script type="text/javascript">

</script>

</head>
<body>
<%
	//detail.jsp 에서 [수정]클릭하면 get방식으로 이동
	//->http://localhost:9090/herbmall/board/edit.jsp?no=7
	//1.
	String no=request.getParameter("no");
	if(no==null||no.isEmpty()){%>
		<script type="text/javascript">
			alert("잘못된 URL입니다.");
			location.href="detail.jsp";
		</script>
	<% return;
	}
	//2.
	BoardDAO dao= new BoardDAO();
	BoardVO vo= null;
	try{
		vo=dao.selectByNo(Integer.parseInt(no));
	}catch(SQLException e){
		e.printStackTrace()	;
	}
	//3.
	String email=vo.getEmail();
	String content=vo.getContent();
	if(email==null){
		email="";
	}
	if(content==null){
		content="";
	}
%>
<div class="divForm">
<form name="frmEdit" method="post" action="edit_ok.jsp"> 
	<!-- 수정시 no가 필요하므로 hidden필드에 넣어준다 -->
    <input type="hidden" id="no" name="no"  value="<%=no%>"/>
    <fieldset>
	<legend>글수정</legend>
        <div class="firstDiv">
            <label for="title">제목</label>
            <input type="text" id="title" name="title"  value="<%=vo.getTitle()%>"/>
        </div>
        <div>
            <label for="name">작성자</label>
            <input type="text" id="name" name="name" value="<%=vo.getName()%>"/>
        </div>
        <div>
            <label for="pwd">비밀번호</label>
            <input type="password" id="pwd" name="pwd" />
        </div>
        <div>
            <label for="email">이메일</label>
            <input type="text" id="email" name="email" value="<%=email%>"/>
        </div>
        <div>  
        	<label for="content">내용</label>        
 			<textarea id="content" name="content" rows="12" cols="40"><%=content%></textarea>
        </div>
        <div class="center">
            <input type = "submit" value="수정"/>
            <input type = "Button" value="글목록" onclick="location.href='list.jsp'" />         
        </div>
	</fieldset>
</form>    
</div>

</body>
</html>