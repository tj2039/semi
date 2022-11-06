<%@page import="com.mybook.common.Utility"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.io.File"%>
<%@page import="com.mybook.book.model.BookDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String no = request.getParameter("no");
	String fileName = request.getParameter("fileName");

	BookDAO2 bookDao=new BookDAO2();
	try{
		int cnt =bookDao.deleteByNo(Integer.parseInt(no));
		if(fileName!=null&& !fileName.isEmpty()){
			String saveDir=application.getRealPath(Utility.UPLOAD_DIR);
			saveDir=config.getServletContext().getRealPath(Utility.UPLOAD_DIR);
			saveDir=Utility.TEST_DIR;
			File myfile=new File(saveDir,fileName);
			if(myfile.exists()){
				boolean bool=myfile.delete();
				System.out.println("파일삭제 여부 : "+bool);
			}
			
		}
		if(cnt>0){
			response.sendRedirect("bookList.jsp");
		}else{
			System.out.println("도서 삭제 실패");
			response.sendRedirect("bookDetail.jsp?no="+no);			
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookDelete.jsp</title>
</head>
<body>

</body>
</html>