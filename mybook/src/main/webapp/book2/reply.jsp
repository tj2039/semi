<%@page import="java.sql.SQLException"%>
<%@page import="com.mybook.book.model.BookDTO"%>
<%@page import="com.mybook.book.model.BookDAO2"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reply.jsp</title>
<script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('form[name=frmWrite]').submit(function(){
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
<%
String no=request.getParameter("no");
BookDTO dto=null;
BookDAO2 dao=new BookDAO2();
if(no==null||no.isEmpty()){
	%>
	<script type="text/javascript">
	alert('잘못된 URL입니다');
	location.href='list.jsp';
	</script>
	<%
}else{
	try{
		dto=dao.selectByNo(Integer.parseInt(no));
	}catch(SQLException e){
		e.printStackTrace();
	}
%>
	<fieldset>
		<legend>부록책 </legend>
		
		<form name="frmWrite" action="reply_ok.jsp">
			<input type="hidden"  name="groupNo"value="<%= dto.getGroupNo()%>">
			<input type="hidden" name="step"value="<%= dto.getStep()%>">
			<input type="hidden" name="sortNo"value="<%= dto.getSortNo()%>">
			제목<input type="text" class="infobox" name="title" value="부록:<%=dto.getTitle()%>"><br>
			가격<input type="text" class="infobox" name="price"><br>
			출판사<input type="text" class="infobox" name="publisher"><br>
		<div>
            <input type = "submit" value="추가"/>
            <input type = "Button" value="도서 목록" onclick="location.href='bookList.jsp'"/>         
        </div>
		</form>
	
	</fieldset>
<%}%>
</body>
</html>