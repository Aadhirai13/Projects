<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRM</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
    <link rel="stylesheet" type="text/css" media="screen" href="styles/style.css" />
</head>
<body>
	<div class="outer-container d-flex align-items-center justify-content-around">
	<a href = "accountslogin.jsp">
        <div class="hover-zoom inner-container d-flex flex-column align-items-center justify-content-center">
        	<div class = "icon mt-2 d-flex align-items-center justify-content-around">
        		<img src="images/person-fill.svg" alt="Admin" width="100%">
			</div>
			<div class = "text mt-4">Account</div>
		</div>
	</a>
	<a href = "userspage.jsp">
        <div class="hover-zoom inner-container d-flex flex-column align-items-center justify-content-center">
        	<div class = "icon mt-2 d-flex align-items-center justify-content-around">
        		<img src="images/people-fill.svg" alt="User" width="100%">
			</div>
			<div class = "text mt-4">User</div>
		</div>
	</a>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>