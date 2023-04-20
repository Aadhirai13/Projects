<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.zoho.zsgs.accounts.AccountsViewModel"
    import="com.zoho.zsgs.model.ContactDetails" import="java.util.*" %>
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
<div class="d-flex justify-content-end mt-2 me-2 text-center">
		<form action="accountspage.jsp">
			<button type="submit" class="btn btn-secondary">BACK</button></form>
	</div>
<div class="outer-container d-flex align-items-center justify-content-around">

	<%List<ContactDetails> contacts = AccountsViewModel.getInstance().getContacts();
	if (contacts == null) {
	out.print("<p class=\"text-center h6 text-danger\"> No Contacts Available </p>");
	} else {
		out.print("<table class=\"container table table-striped table-hover table-bordered \">");
		out.print("<thead>");
		out.print("<tr class = \"table-secondary\">");
		out.print("<th scope=\"col\">Contact's Name</th>");
		out.print("<th scope=\"col\">Mobile Number</th>");
		out.print("<th scope=\"col\">Location</th>");
		out.print("<th scope=\"col\">Account Number</th>");
		out.print("<th scope=\"col\">Loan Amount (in Rs)</th>");
		out.print("<th scope=\"col\">Monthly Interest Percent (in %)</th>");
		out.print("<th scope=\"col\">Monthly Interest Amount (in Rs)</th>");
		out.print("</tr>");
		out.print("</thead>");
		out.print("<tbody>");
		for(ContactDetails contact : contacts) {
			out.print("<tr>");
			out.print("<td>" + contact.userName +"</td>");
			out.print("<td>" + contact.mobileNumber +"</td>");
			out.print("<td>" + contact.location +"</td>");
			out.print("<td>" + contact.accountNumber +"</td>");
			out.print("<td>" + contact.loanAmount +"</td>");
			out.print("<td>" + contact.monthlyInterestPercent +"</td>");
			out.print("<td>" + contact.monthlyInterestAmount +"</td>");
			out.print("<tr>");
		}
	}
	%>
  </tbody>
  </div>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>