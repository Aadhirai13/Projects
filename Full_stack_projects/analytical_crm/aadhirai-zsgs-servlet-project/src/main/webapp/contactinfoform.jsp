<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.zoho.zsgs.users.UsersViewModel"%>
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
        <div class="inner-container d-flex flex-column align-items-center justify-content-center" style="height: 60vh;">
        
        <form action="contactinfoform.jsp"> 
        	<h2 class="fs-4 text-wrap text-center">Contact Details</h2>
        	<div class="mb-4">
	  			<label for="exampleFormControlInput1" class="form-label">Enter your location</label>
	  			<input type="text" class="form-control" name="location" id="exampleFormControlInput1" placeholder="location">
			</div>
			<div class="mb-4">
				<label for="exampleFormControlInput2" class="form-label">Enter your account number</label>
				<input type="text" class="form-control" name="accountnumber" id="exampleFormControlInput2" placeholder="999">
			</div>
			<div class="mb-4">
				<label for="exampleFormControlInput2" class="form-label">Enter loan amount</label>
				<input type="text" class="form-control" name="loanamount" id="exampleFormControlInput2" placeholder="99999">
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-secondary">SUBMIT</button>
			</div>
		</form>
		
		<%
		
		String location = request.getParameter("location");
		String accountNumber = request.getParameter("accountnumber");
		String loanAmount = request.getParameter("loanamount");
		
		if(location != null){
		
		float monthlyInterestAmount = UsersViewModel.getInstance().storeContactDetails(location, accountNumber, Integer.parseInt(loanAmount));
		
		out.print("<div><br>");
		out.print("<h4 class=\"text-center text-success\">Deal Confirmed !</h4>");
		
		out.println("<p class=\"fs-4\">You have to pay " + monthlyInterestAmount + " as monthly interest</p>");
		}
    		%>
		</div>
		</div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>