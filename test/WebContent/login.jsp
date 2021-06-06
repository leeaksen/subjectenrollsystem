<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Yongin LMS</h3>
	<p>
	<form action = "login.do" method = "put">
	I      D : <input type = "text" name = "id" /> <br>
	PASSWORD : <input type = "password" name = "pwd" /> <br>
	<input type = "radio" name = "professor"  /> professor
	<input type = "radio" name = "student" /> student
	<input type = "submit" value = "LOGIN" />
	</form>
</body>
</html>