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
	font-size:20px;
}
body
{
background-repeat:no-repeat;
background-size:cover;
/*background-image:url("images/cash bank.jpg");*/
background-color:#d5f4e6;
}
a{
font-size:20px;}
.header-img {
	width: 100%;
	height: 250px;
	margin-top:-10px;
	background-repeat: no-repeat;
	background-image: url("images/complaint.jpg");
}
</style>
<head>
</head>
<body>
	<div class="header-img"></div>
	<header style="background-color: none; height: 50px; margin-top:-200px">
		<div>
			<span style="text-align: center; font-size:30px;"><h2>EASY BANK</h2></span>
		</div>

	</header>
	<h1 align="center">COMPLAINT LIST</h1>
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
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bank}" var="comp">
						<form:form method="POST" action="/ComplaintUpdate?id=${comp.cId}"
							modelAttribute="user">
							<tr>
								<td>${comp.cId}</td>
								<td>${comp.acctno}</td>
								<td>${comp.compType}</td>
								<td>${comp.name}</td>
								<td>${comp.description}</td>
								<td><input type="radio" id="status" name="status"
									value="Open">Open <input type="radio" id="status"
									name="status" value="Closed">Closed</td>
								<td><input type="radio" id="priority" name="priority"
									value="Low">Low <input type="radio" id="priority"
									name="priority" value="Medium">Medium <input
									type="radio" id="priority" name="priority" value="High">High</td>
								<td><input type="submit" class="button" value="Update" /></td>
							</tr>
						</form:form>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<br>
			<a href="/Logout" style="color:red">Logout</a>
		</div>

	</div>
</body>
</html>