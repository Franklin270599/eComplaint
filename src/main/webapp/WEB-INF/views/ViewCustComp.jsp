<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<style>
table, td, th {
	border: 3px solid black;
}
th, td {
	padding: 5px;
}
body
{
background-repeat:no-repeat;
background-size:cover;
/*background-image:url("images/cash bank.jpg");*/
background-color:#d5f4e6;
}
.header-img {
	width: 100%;
	height: 250px;
	margin-top:-10px;
	background-repeat: no-repeat;
	background-image:url("images/complaint.jpg");
}
</style>
<head>
</head>
<body>
<div class="header-img"></div>
	<header style="background-color: none; height: 50px; margin-top:-250px">
		<div>
			<span style="text-align: center"><h2>EASY BANK</h2></span>
		</div>
	</header>
	<h1 align="center">EXISTING COMPLAINTS</h1>
	<div class="content">
		<div align="center">
			<table style="border-spacing: 30px 50px; border-collapse: collapse;">
				<thead>
					<tr>
						<th>Complaint ID</th>
						<th>Account Number</th>
						<th>Complaint Type</th>
						<th>Customer Name</th>
						<th>Description</th>
						<th>Status</th>
						<th>Priority</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${viewcomp}" var="vcomp">
						<form:form action="/Logout" method="POST" modelAttribute="complaint" >
							<tr>
								<td>${vcomp.cId}</td>
								<td>${vcomp.acctno}</td>
								<td>${vcomp.compType}</td>
								<td>${vcomp.name}</td>
								<td>${vcomp.description}</td>
								<td>${vcomp.status}</td>
								<td>${vcomp.priority}</td>
							</tr>
						</form:form>
					</c:forEach>
				</tbody>
			</table>
			<p style="font-weight:bold"> Note: Once the complaint is solved email will be sent to your registered mail</p>
			<br>
			<a href="/Logout">Logout</a>
		</div>

	</div>
</body>
</html>