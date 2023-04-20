<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.zoho.zsgs.users.UsersViewModel"
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
<div class="d-flex justify-content-end mt-2 me-2 text-center">
		<form action="userspage.jsp">
			<button type="submit" class="btn btn-secondary">BACK</button></form>
	</div>
	<div class="outer-container d-flex align-items-center justify-content-center align-items-center">
        <div class="inner-container d-flex flex-column align-items-center justify-content-center">
        <h1>You are currently a lead</h1><br>
	<%
		boolean isCallRecieved = UsersViewModel.getInstance().isCallRecieved();
		if(isCallRecieved) {
			ArrayList<Integer> callDetails = UsersViewModel.getInstance().getCallDetails();
			out.print("<p>Your call details !!</p>");%>
			<div class = "container">
		<table class="table">
		  <tbody>
		    <tr>
		      <th scope="row">Minimum Loan Amount (in Rs)</th>
		      <%
		      out.print("<td>"+callDetails.get(0)+"</td>");
		      %>
		       </tr>
		    <tr>
		      <th scope="row">Monthly Interest Percent (in %)</th>
		      <%
		      out.print("<td>"+callDetails.get(1)+"</td>");
		      %>
		      </tr>
		  </tbody>
		</table>
		<div class="d-flex justify-content-around  text-center">
		<form action="userspage.jsp">
			<button type="submit" class="btn btn-danger">REJECT</button></form>
		<form action="contactinfoform.jsp">
			<button type="submit" class="btn btn-success">ACCEPT</button></form>
		</div>
		</div>
		<%
		}
		else {
			out.print("<p>You didn't received any calls yet !!</p>");
		}
	 %>
		</div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>