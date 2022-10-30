<%@page import="com.hebmall.common.utillity"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.herbmall.reboard.model.ReBoardVO"%>
<%@page import="com.herbmall.reboard.model.ReBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<title>답변형 게시판 글 수정 - 허브몰</title>
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
	//detail.jsp에서 [수정]클릭하면 get방식으로 이동
	//=> http://localhost:9090/herbmall/reBoard/edit.jsp?no=3
	//1
	String no=request.getParameter("no");
	if(no==null || no.isEmpty()){ %>
		<script type="text/javascript">
			alert('잘못된 url입니다.');
			location.href="list.jsp";
		</script>
	<%	return;
	}
	
	//2
	ReBoardDAO dao = new ReBoardDAO();
	ReBoardVO vo = null;
	
	try {
	   vo = dao.selectByNo(Integer.parseInt(no));
	} catch(SQLException e) {
	   e.printStackTrace();
	}
	
	//3
	String email=vo.getEmail();
	String content=vo.getContent();
	String oldFileName=vo.getFileName();
	if(email==null) email="";
	if(content==null) content="";
	if(oldFileName==null) oldFileName="";
	
%>
	<div class="divForm">
		<form name="frmEdit" method="post" action="edit_ok.jsp" enctype="multipart//form-data">
			<!-- 수정시 no가 필요하므로 hidden필드에 넣어준다 -->
			<input type="hidden" name="oldFileName" value="<%=oldFileName%>"/>
			<input type="hidden" name="no" value="<%=no%>"/>
			
			<fieldset>
				<legend>글수정</legend>
				<div class="firstDiv">
					<label for="title">제목</label> 
					<input type="text" id="title"
						name="title" value="<%=vo.getTitle()%>"/>
				</div>
				<div>
					<label for="name">작성자</label> 
					<input type="text" id="name"
						name="name" value="<%=vo.getName()%>"/>
				</div>
				<div>
					<label for="pwd">비밀번호</label> 
					<input type="password" id="pwd"
						name="pwd" />
				</div>
				<div>
					<label for="email">이메일</label> 
					<input type="text" id="email"
						name="email" value="<%=email%>"/>
				</div>
				<div>
					<label for="file">첨부파일</label> 
					<input type="file" id="upfile"
						name="upfile"/>
				</div>
				<div>
					<span class="sp1">첨부파일등록</span> 
					<span><%=utillity.getFileInfo(vo) %></span>
					<br>
					<span style="color:green; font-weight:bold; font-size:0.75em">첨부파일을 새로 지정할 경우 기존 파일은 삭제됩니다.</span>
				</div>
				<div>
					<label for="content">내용</label>
					<textarea id="content" name="content" rows="12" cols="40"><%=content %></textarea>
				</div>
				<div class="center">
					<input type="submit" value="수정" /> <input type="Button" value="글목록"
						onclick="location.href	='list.jsp'" />
				</div>
			</fieldset>
		</form>
	</div>

</body>
</html>