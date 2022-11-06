<%@page import="java.io.IOException"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.mybook.common.Utility"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.mybook.book.model.BookDTO"%>
<%@page import="com.mybook.book.model.BookDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookWrite_ok.jsp</title>
</head>
<body>
	<%
		
	//write.jsp에서 post방식으로 서브밋됨
	
		//업로드할 경로
		String saveDir=application.getRealPath(Utility.UPLOAD_DIR);
		saveDir=config.getServletContext().getRealPath(Utility.UPLOAD_DIR);
		System.out.println("saveDir="+saveDir);
		
		saveDir=Utility.TEST_DIR;
		System.out.println("testDir="+saveDir);
				
		int maxSize=2*1024*1024; //업로드할 최대 용량, 2M
		
		try{
			DefaultFileRenamePolicy policy=new DefaultFileRenamePolicy();
			MultipartRequest mr
				=new MultipartRequest(request, saveDir, maxSize, "UTF-8", policy);
			System.out.println("업로드 완료!");
			
			//업로드 파일 정보 구하기
			String fileName=mr.getFilesystemName("upfile");
			long fileSize=0;
			String originalFName="";
			if(fileName!=null){  //파일이 첨부된 경우만
				File file = mr.getFile("upfile");
				fileSize=file.length();
				
				originalFName=mr.getOriginalFileName("upfile");
			}
			//1.입력 파라미터 읽어오기
			
			String title=mr.getParameter("title");
			String price=mr.getParameter("price");
			String publisher=mr.getParameter("publisher");
			
			//ip 읽어오기
			String ip = request.getRemoteAddr();
			System.out.println("ip="+ip);
			
			ip=request.getRemoteHost();
			System.out.println("ip="+ip);
			
			//2. db작업
			BookDAO2 bookDao=new BookDAO2();
			BookDTO dto= new BookDTO();
			
			dto.setTitle(title);
			dto.setPrice(Integer.parseInt(price));
			dto.setPublisher(publisher);
			dto.setFileName(fileName);
			dto.setFileSize(fileSize);
			dto.setOriginalFileName(originalFName);
		
			int cnt=bookDao.insertBook(dto);
			
			//3. 결과처리
			if(cnt>0){
				response.sendRedirect("bookList.jsp");
			}else{
				System.out.println("도서 등록 실패");
				response.sendRedirect("bookWrite.jsp");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(IOException e){%>
			<script type="text/javascript">
				alert('2M 이상의 파일은 업로드할 수 없습니다!');
				history.back();
			</script>
		<%	e.printStackTrace();
		}
	%>
</body>
</html>