<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travelForm.jsp</title>
</head>
<body>
<h3>프로그래밍언어를 선택하시면 좋은 책을 추천해드립니다</h3>
<form name="frm1" method="post" 
	action="<%=request.getContextPath() %>/book.do">
	<select name="lang">
		<option value="java">java</option>
		<option value="jsp">jsp</option>
		<option value="ajax">ajax</option>
		<option value="oracle">oracle</option>		
	</select>
	<br><br>
	<input type="submit" value="확인">
</form>

</body>
</html>