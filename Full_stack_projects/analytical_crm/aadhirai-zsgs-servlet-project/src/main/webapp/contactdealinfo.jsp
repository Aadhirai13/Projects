<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.zoho.zsgs.users.UsersViewModel" import="com.zoho.zsgs.model.ContactDetails"
    import="java.util.*"%>
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
	<div class="outer-container d-flex align-items-center justify-content-center align-items-center">
        <div class="inner-container d-flex flex-column align-items-center justify-content-center">
		<h2>Your deal details !!</h2>
		<div class = "container">		
		<table class="table">
		
		<% List<ContactDetails> contactDetails = UsersViewModel.getInstance().getContactDetails(); 
		  out.print("<tbody>");
		  out.print("<tr>");
		  out.print("<th scope=\"row\">Name</th>");
		  out.print("<td>" + contactDetails.get(0).userName + "</td>");
		  out.print("</tr>");
		  out.print("<tr>");
		  out.print("<th scope=\"row\">Location</th>");
		  out.print("<td>" + contactDetails.get(0).location + "</td>");
		  out.print("</tr>");
		  out.print("<tr>");
		  out.print("<th scope=\"row\">Account Number</th>");
		  out.print("<td>" + contactDetails.get(0).accountNumber + "</td>");
		  out.print("</tr>");
		  out.print("<tr>");
		  out.print("<th scope=\"row\">Loan Amount (in Rs)</th>");
		  out.print("<td>" + contactDetails.get(0).loanAmount + "</td>");
		  out.print("</tr>");
		  out.print("<tr>");
		  out.print("<th scope=\"row\">Monthly Interest Percent (in %)</th>");
		  out.print("<td>" + contactDetails.get(0).monthlyInterestPercent + "</td>");
		  out.print("</tr>");
		  out.print("<tr>");
		  out.print("<th scope=\"row\">Monthly Interest Amount (in Rs)</th>");
		  out.print("<td>" + contactDetails.get(0).monthlyInterestAmount + "</td>");
		  out.print("</tr>");
		  %>
		  </tbody>
		</table>
		
		<div class="d-flex justify-content-around  text-center">
		<form action="userspage.jsp">
			<button type="submit" class="btn btn-secondary">EXIT</button></form>
		</div>
</div>
		</div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>