<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 교수 과목 등록 </h2>
	<h3> Subject</h3>
	<form action = "enroll.do" method = "post">
	I D : <input type = "text" name = "id"/>
	TITLE : <input type = "text" name = "name" />
	# of Student : <input type = "text" name = "count"/>
	교수 아이디 : <input type = "text" name = "prof"/>
	<input type = "submit" value = "Enroll" />
	</form>
</body>
</html>