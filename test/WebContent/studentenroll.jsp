<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 과목 번호 조회 </h2>
<form action = "search.do" method = "post">
	I D : <input type = "text" name = "과목 번호" /> <br>
	<input type = "submit" value = "조회" />
	</form>
	
	<% 
	String result = (String)request.getAttribute("msg");
	if(result != null && result.equals("true")) 
	{
		%>
		<h2> 수강 신청 </h2>
		<form action = "enroll.do" method = "post">
		I D : <input type = "text" name = "교과목 번호"/>
		<input type = "hidden" name = "job" value = "search">
		<input type = "submit" value = "enroll" />
		</form>
	<% } else if(result != null && result.equals("false")){
		out.print("No enrolled subject");
	}
	%>
	
</body>
