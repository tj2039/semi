<%@page import="java.sql.SQLDataException"%>
<%@page import="com.herbmall.board.model.BoardVO"%>
<%@page import="com.herbmall.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	//detail.jsp에서 [삭제] 클릭하면 get방식으로 이동
	//->http://localhost:9090/herbmall/board/delete.jsp?no=7
	//1
	String no=request.getParameter("no");
	//2
	BoardDAO dao= new BoardDAO();
	BoardVO vo= null;
	try{
		vo=dao.selectByNo(Integer.parseInt(no));		
	}catch(SQLDataException e){
		e.printStackTrace();
	}
	//3
	
%>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>자유게시판 글 삭제 - 허브몰</title>
<link rel="stylesheet" type="text/css" href="../css/mainstyle.css" />
<link rel="stylesheet" type="text/css" href="../css/clear.css" />
<link rel="stylesheet" type="text/css" href="../css/formLayout.css" />
<link rel="stylesheet" type="text/css" href="../css/mystyle.css" />
<style type="text/css">
	body{
		padding:5px;
		margin:5px;
	 }
	.divForm{
		width:650px;
		border:1px solid #ddd;		
	}
	/* .divForm form{
		width:650px;
	} */
	.divForm div	{
		/* clear: both; */
		border:none;
		padding: 7px 0;
		margin: 0;
		overflow: auto;
	}	
	.sp{
		font-size:0.9em;
		color:#0056AC;			
	}
	.divForm fieldset	{
		border:0;
	}
</style>
<script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('form[name=frmDelete]').submit(function(){
			if($('#pwd').val().length<1){
				alert('비밀번호를 입력하세요');
				$('#pwd').focus();
				//event.preventDefault();
				return false;
			}
			
			if(!confirm('삭제하시겠습니까?')){
				event.preventDefault();	
			}
		});
		<%-- $('form[name=frmDelete]').submit(function(){
			if($('#pwd').val().length<1){
				alert('비밀번호를 입력하세요');
				$('#pwd').focus();
				return false;
			}else if($("#pwd").val()==<%=vo.getPwd()%>){
				if(!confirm('정말 삭제하시겠습니까?')){
					event.preventDefault();
				};
			}else{
				alert("비밀번호가 틀렸습니다.\r\n비밀번호를 확인하세요.");
				$('#pwd').focus();
				//event.preventDefault();
				return false;
			}
		});	 --%>
		
	});
</script>
</head>
<body>
<div class="divForm">
<form name="frmDelete" method="post" action="delete_ok.jsp<%-- ?no=<%=no%> --%>" >
		<input type="hidden" name="no" value="<%=no%>">
		<fieldset>
		<legend>글 삭제</legend>
	        <div>           
	        	<span class="sp"> <%=no%>번 글을 삭제하시겠습니까?</span>                        
	        </div>
	        <div>           
	            <label for="pwd">비밀번호</label>
	            <input type="password" id="pwd" name="pwd" />   
	        </div>
	        <div class="center">
	            <input type ="submit"  value="삭제" />
	            <input type = "Button" value="글목록" 
                	OnClick="location.href='list.jsp'" />
	        </div>
	    </fieldset>
    </form>
</div>

</body>
</html>