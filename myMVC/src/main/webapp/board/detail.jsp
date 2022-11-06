<%@page import="java.util.List"%>
<%@page import="com.mymvc.board.model.BoardCommentVo"%>
<%@page import="com.mymvc.board.model.BoardCommentService"%>
<%@page import="com.mymvc.board.model.BoardVO"%>
<%@page import="com.mymvc.board.model.BoardDAO"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	//list.jsp에서 [제목] 클릭하면 get방식으로 이동
	//=> http://localhost:9090/herbmall/board/detail.jsp?no=3
	//1
	String no=request.getParameter("no");
	if(no==null || no.isEmpty()){%>
		<script type="text/javascript">
			alert('잘못된 url입니다');
			location.href="list.jsp";
		</script>
		
	<%	return;	
	}
	
	//2
	BoardDAO dao = new BoardDAO();
	BoardVO vo = null;
	try{
		vo=dao.selectByNo(Integer.parseInt(no));
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	//3
	String content=vo.getContent();
	if(content!=null && !content.isEmpty()){
		content=content.replace("\r\n", "<br>");
	}else{
		content="";
	}
	
	BoardCommentService bcs=new BoardCommentService();
	List<BoardCommentVo>list=null;
	try{
		list=bcs.selectCommnent(Integer.parseInt(no));
	}catch(SQLException e){
		e.printStackTrace();
	}
%>    
<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>자유게시판 상세보기 - 허브몰</title>
<link rel="stylesheet" type="text/css" href="../css/mainstyle.css" />
<link rel="stylesheet" type="text/css" href="../css/clear.css" />
<link rel="stylesheet" type="text/css" href="../css/formLayout.css" />
<link rel="stylesheet" type="text/css" href="../css/mystyle.css" />
<style type="text/css">
	body{
		padding:5px;
		margin:5px;
	 }
	.divForm {
		width: 500px;
		}
</style>
<script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('form[name=frmComment]').submit(function(){
			$('.infobox').each(function(index, item){
				if($(this).val().length<1){
					alert($(this).prev().text() + '을(를) 입력하세요');
					$(this).focus();
					event.preventDefault();
					return false;
				}
			});
		});
	});
</script> 
</head>
<body>

	<h2>글 상세보기</h2>
	<div class="divForm">
		<div class="firstDiv">
			<span class="sp1">제목</span> <span><%=vo.getTitle() %></span>
		</div>
		<div>
			<span class="sp1">작성자</span> <span><%=vo.getName() %></span>
		</div>
		<div>
			<span class="sp1">등록일</span> <span><%=vo.getRegdate() %></span>
		</div>
		<div>
			<span class="sp1">조회수</span> <span><%=vo.getReadcount() %></span>
		</div>
		<div class="lastDiv">			
			<p class="content"><%=content %></p>
		</div>
		<div class="center">
			<a href='edit.jsp?no=<%=no%>'>수정</a> |
        	<a href='delete.jsp?no=<%=no%>'>삭제</a> |
        	<a href='list.jsp'>목록</a>			
		</div>
	</div>
	<%if(list!=null&& !list.isEmpty()){ %>
		<div>
			<table>
				<thead>
				  <tr>
				    <th >이름</th>
				    <th >내용</th>
				    <th >작성일</th>
				  </tr>
				</thead> 
				<tbody>
				<%for(int i=0; i<list.size();i++){ 
					BoardCommentVo commentVo=list.get(i);
				%>
					<tr>
						<td><%=commentVo.getName() %></td>
						<td><%=commentVo.getContent() %></td>
						<td><%=commentVo.getRegdate() %></td>
					</tr>
				<%} %>
				</tbody>
			</table>
		</div>
	<%} %>
	<div>
		<form name="frmComment" method="post" action="comment_ok.jsp" >
			<fieldset>
				<input type="" id="bdno" name="bdNo"  class="infobox" value="<%=no%>"/>
			<legend>댓글</legend>
				<div>
					<label for="title">이름</label> 
					<input type="text" id="re_name" name="re_name"  class="infobox"/>
				</div>
				<div>
					<label for="title">비밀번호</label> 
					<input type="password" id="re_pwd" name="re_pwd" class="infobox"/>
				</div>
				<div>
					<textarea rows="5" cols="80" id="re_content" class="infobox"></textarea>
				</div>
				<div >
					<input type="submit" value="댓글 달기" />
				</div>
			</fieldset>
		</form>
	</div>
	
</body>
</html>