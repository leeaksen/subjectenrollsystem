<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.dev.vo.TestVO" %>
    <%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<TestVO> list = (ArrayList<TestVO>) request.getAttribute("list");
	if (!list.isEmpty()) { %>
	<table border="1">
			<tr><th>과목 번호</th><th>학생 아이디</th></tr>
			<% for (int i= 0; i<list.size(); i++) {
				TestVO test = list.get(i);	%>
				
			<tr><td><%=test.getId()%></td>
				<td><%=test.getStudnet()%></td>
				</tr>
			
				
				<% }
		}else{
			out.print("<h3>신청된 강의가 없습니다.</h3>");
		}
	%>
	</table>
		<%@ include file = "profHomeMenu.jsp" %>
</body>
</html>