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
<div class="d-flex justify-content-end mt-2 me-2 text-center">
		<form action="accountslogin.jsp">
			<button type="submit" class="btn btn-secondary">BACK</button></form>
	</div>
	<div class="outer-container d-flex align-items-center justify-content-around">
	<a href = "leadspage.jsp">
        <div class="hover-zoom inner-container d-flex flex-column align-items-center justify-content-center">
        	<div class = "icon mt-2 d-flex align-items-center justify-content-around">
        		<img src="images/person-exclamation.svg" alt="leads" width="100%">
			</div>
			<div class = "text mt-4">Show Leads</div>
		</div>
	</a>
	<a href = "contactspage.jsp">
        <div class="hover-zoom inner-container d-flex flex-column align-items-center justify-content-center">
        	<div class = "icon mt-2 d-flex align-items-center justify-content-around">
        		<img src="images/person-check-fill.svg" alt="contacts" width="100%">
			</div>
			<div class = "text mt-4">Show Contacts</div>
		</div>
	</a>
	<!-- <a href = "dashboard.jsp">
        <div class="hover-zoom inner-container d-flex flex-column align-items-center justify-content-center">
        	<div class = "icon mt-2 d-flex align-items-center justify-content-around">
        		<img src="images/dashboard.png" alt="dashboard" width="100%">
			</div>
			<div class = "text mt-4">Show Dashboard</div>
		</div>
	</a> -->
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>