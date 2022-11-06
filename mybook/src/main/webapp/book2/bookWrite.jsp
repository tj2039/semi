<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookWrite.jsp</title>
</head>
<body>
<h2>도서 등록</h2>
	<form name="frmBook" method="post" action="bookWrite_ok.jsp" enctype="multipart/form-data">
		도서명:<input type="text" name="title"><br>
		 가격:<input type="text" name="price"><br>
		 출판사:<input type="text" name="publisher"><br>
		 <div>
            <label for="email">첨부파일</label>
            <input type="file" if="upfile" name="upfile" />
        </div> <br>
		<br> <input type="submit" value="등록"> <input type="reset"
			value="취소">
	</form>

	<br>
	<br>
	<a href="bookList.jsp">도서 목록</a>
</body>
</html>