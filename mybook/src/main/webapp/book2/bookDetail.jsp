<%@page import="com.mybook.common.Utility"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.mybook.book.model.BookDTO"%>
<%@page import="com.mybook.book.model.BookDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//list.jsp에서 [제목] 클릭하면 get방식으로 이동
	//=> http://localhost:9090/herbmall/reBoard/detail.jsp?no=3
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
	BookDAO2 bookDao = new BookDAO2();
	BookDTO dto= null;
	try{
		dto=bookDao.selectByNo(Integer.parseInt(no));
	}catch(SQLException e){
		e.printStackTrace();
	}
	//3
	DecimalFormat df=new DecimalFormat("#,###");
	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	String fileName=dto.getFileName();
	if(fileName==null){
		fileName="";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookDetail.jsp</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#bookDel").click(function(){
			if(confirm('삭제하시겠습니까?')){
				location.href="bookDelete.jsp?no=<%=no%>";
			}
		});
	})
</script>
</head>
<body>
	<h1>도서 상세보기</h1>
	<p>번호 : <%=no%></p>
	<p>도서명 : <%=dto.getTitle() %></p>
	<p>가격 : <%=df.format(dto.getPrice()) %></p>
	<p>출판사 : <%=dto.getPublisher() %></p>
	<p>등록일 : <%=sdf.format(dto.getJoindate()) %></p>
	<div>
			<span class="sp1">첨부파일</span> 
			<%if(dto.getFileName()!=null && !dto.getFileName().isEmpty()){ %>
				<a href="download.jsp?no=<%=no%>&fileName=<%= dto.getFileName()%>">
					<span>
						<%=Utility.getFileInfo(dto) %></span>
					<span>다운 : <%=dto.getDownCount() %></span>
				</a>
			<%} %>
		</div>
	<a href="bookList.jsp?no=<%=no%>">목록보기</a> |
	<a href="reply.jsp?no=<%=no%>">부록추가</a> |
	<a href="bookEdit.jsp?no=<%=no%>">수정</a> |
	<a href="bookDelete.jsp?no=<%=no%>&fileName=<%=fileName%>" >삭제</a> |
	 
</body>
</html>