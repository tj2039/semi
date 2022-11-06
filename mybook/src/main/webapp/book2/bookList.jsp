<%@page import="com.mybook.common.Utility"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="com.mybook.book.model.BookDTO"%>
<%@page import="com.mybook.book.model.BookDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookList.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String condition=request.getParameter("searchCondition");
	String keyword=request.getParameter("searchKeyword");
	
	if(keyword==null){
		keyword="";
	}
	
	BookDAO2 bookDao=new BookDAO2();
	List<BookDTO> list=null;
	try{
		list=bookDao.selectAll(condition,keyword);
	}catch(SQLException e){
		e.printStackTrace();	
	}
	
	//페이징 처리
	int currentPage=1;
	if(request.getParameter("currentPage")!=null){
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
	}
	//현재페이지와 무관한 변수들
	int totalRecord=0;
	if(list!=null && !list.isEmpty()){
		totalRecord=list.size();
	}
	
	int pageSize=5;
	int totalPage=(int)Math.ceil((float)totalRecord/pageSize);
	int blockSize=10;
	
	//현재 페이지를 이용해 계산하는 변수들
	int firstPage=currentPage-((currentPage-1)%blockSize);
	int lastPage=firstPage+(blockSize-1);
	
	int curPos=(currentPage-1)*pageSize;
	int num = totalRecord-curPos; //페이지당 글 리스트 시작 번호
	
%>
<h1>도서 목록</h1>
	<%if(keyword!=null && !keyword.isEmpty()){ %>
		<p>검색어 : <%=keyword%>, <%=list.size() %>건이 검색되었습니다.</p>
	<%} %>
	<table border="1" style="width:500px">
	<tr>
		<th>번호</th>
		<th>도서명</th>
		<th>가격</th>
		<th>출판사</th>
		<th>등록일</th>
	</tr>
	<!-- 반복시작 -->
	<%if(list==null||list.isEmpty()){ %>
			<tr> <td colspan="5">데이터가 없습니다.</td> </tr>
	<%}else{ %>
		<%
			for(int i=0;i<pageSize;i++){
				if(num<1){
					break;
				}
				BookDTO dto=list.get(curPos++);
				num--;
		%>
				<tr>
					<td><%=dto.getNo()%></td>
					<td>
						<!-- 파일이 첨부된 경우 파일 이미지 보여주기 -->
						<%=Utility.displayFile(dto.getFileName()) %>				
						
						<!-- 답변글인 경우 화살표 이미지 보여주기 -->
						<%=Utility.displayRe(dto.getStep()) %>				
					
						<a href="bookDetail.jsp?no=<%=dto.getNo()%>" >
							<!-- 제목이 긴 경우 일부만 보여주기 -->						
						<%=Utility.cutTitle(dto.getTitle(), 30) %>
						</a>
					</td>
					<td><%=dto.getPrice()%></td>
					<td><%=dto.getPublisher()%></td>
					<td><%=dto.getJoindate()%></td>
				</tr>
				
		<%
			}
		%>
	<%
		}
	%>
	<!-- 이전블럭으로 이동 -->
	<!-- 반복끝 -->
	</table>
	<%if(firstPage>1){%>
		<a href="bookList.jsp?currentPage=<%=firstPage-1%>&searchCondition=<%=condition%>&searchKeyword=<%=keyword%>"><img src="../images/first.JPG"> </a>
	<% }%>
	<!-- 페이지 번호 추가 -->	
	<!-- [1][2][3][4][5][6][7][8][9][10] -->
	<%
		for(int i=firstPage;i<=lastPage;i++){
			if(i>totalPage) break;
			
			if(i==currentPage){ %>
				<a href="bookList.jsp?currentPage=<%=i%>" style="font-weight:bold; font-size:1.1em"><%=i%></a>
			<% }else{%>
				<a href="bookList.jsp?currentPage=<%=i%>&searchCondition=<%=condition%>&searchKeyword=<%=keyword%>">[<%=i%>]</a>
			<%}
	}%>
	<!--  페이지 번호 끝 -->
	<!-- 다음 블럭으로 이동 -->
	<%if(lastPage<totalPage){%>
		<a href="bookList.jsp?currentPage=<%=lastPage+1%>&searchCondition=<%=condition%>&searchKeyword=<%=keyword%>">
		<img src="../images/last.JPG"> </a>
	<% }%>
	<br>
	<div class="divSearch">
   	<form name="frmSearch" method="post" action='bookList.jsp'>
        <select name="searchCondition">
            <option value="title" 
            	<%if("title".equals(condition)){%>
            		selected="selected"
            	<% }%>            	
            >도서명</option>
            <option value="publisher"
            	<%if("publisher".equals(condition)){%>
            		selected="selected"
            	<% }%>
            >출판사</option>
            
        </select>   
        <input type="text" name="searchKeyword" title="검색어 입력"
        value="<%=keyword%>">   
		<input type="submit" value="검색">
    </form>
</div>
	<br>
	<a href="bookWrite.jsp">상품등록</a>
</body>
</html>