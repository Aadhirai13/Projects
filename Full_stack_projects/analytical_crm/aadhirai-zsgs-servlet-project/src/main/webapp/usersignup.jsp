<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRM</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
    <link rel="stylesheet" type="text/css" media="screen" href="styles/accountslogin.css" />
</head>
<body>
<div class="d-flex justify-content-end mt-2 me-2 text-center">
		<form action="userspage.jsp">
			<button type="submit" class="btn btn-secondary">BACK</button></form>
	</div>
	<div class="outer-container d-flex align-items-center justify-content-center align-items-center">
        <div class="inner-container d-flex flex-column align-items-center justify-content-center">
        <form action="usersignup">
        	<h2 class="fs-5 text-wrap text-center">User Sign Up</h2>
        	<div class="mb-4">
	  			<label for="exampleFormControlInput1" class="form-label">Enter User Name</label>
	  			<input type="text" name="username" class="form-control" id="exampleFormControlInput1" placeholder="name">
			</div>
			<div class="mb-4">
				<label for="exampleFormControlInput2" class="form-label">Enter Mobile Number</label>
				<input type="text" name="mobilenumber" class="form-control" id="exampleFormControlInput2" placeholder="9999999999">
			</div>
			<div class="text-center">
				<button type="submit" class="fs-6 btn btn-secondary">CREATE ACCOUNT</button>
			</div>
			
			<div class="text-center">
			<br>	
			<p class="text-center h5 text-danger">			
				<%
    			try{
				    String message = (String)request.getSession().getAttribute("fail");
				    if(message != null)
				    	out.println(message);
				    
				    session.removeAttribute("fail");
				}catch(Exception e){
				}
    		%>
    		</p>
			</div>
		</form>
		</div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>