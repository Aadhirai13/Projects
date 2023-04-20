<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Hello Aadhirai!</h1>
		<form action="index.jsp" method="POST">
			<label>Enter your name</label>
			<input type = "text" name="myName"/><br>
			<label>Enter password</label>
			<input type = "password" name="password"/><br>
			<label>Enter your mobile number</label>
			<input type = "text" name="mobile"/>
			<input type = "submit"/>
		</form>
		
		<%
		String name = request.getParameter("myName");
		out.print(name);
		 %>
	</body>
</html>