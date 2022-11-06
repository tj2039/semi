<%@page import="java.sql.SQLException"%>
<%@page import="com.mymvc.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete_ok.jsp</title>
</head>
<body>
<%
	//Detail.jsp 에서 [삭제] 클릭하면 post방식으로 이동
	//1
	request.setCharacterEncoding("utf-8");
	//1.요청 파라미터 읽어오기
	String no=request.getParameter("no");
	String pwd=request.getParameter("pwd");
	
	//2.db작업
	BoardDAO dao=new BoardDAO();
	try{
		int cnt =dao.delete(Integer.parseInt(no),pwd);
		
		//3. 결과 처리
		if(cnt>0){%>
			<script type="text/javascript">
				alert('글삭제되었습니다.');
				location.href="list.jsp"
			</script>
		<%}else{%>
			<script type="text/javascript">
				alert('글삭제 실패!');
				history.back();
			</script>
		<%}
	}catch(SQLException e){
		e.printStackTrace();
	}

	/* //Detail.jsp 에서 [삭제] 클릭하면 get방식으로 이동
	//1.요청 파라미터 읽어오기
	String no=request.getParameter("no");
	
	//2.db작업
	BoardDAO dao=new BoardDAO();
	try{
		int cnt =dao.delete(Integer.parseInt(no));
		
		//3. 결과 처리
		if(cnt>0){
			response.sendRedirect("list.jsp");
		}else{
			System.out.println("글 삭제 실패");
			response.sendRedirect("Detail.jsp?no="+no);
			
		}
	}catch(SQLException e){
		e.printStackTrace();
	} */
%>
</body>
</html>