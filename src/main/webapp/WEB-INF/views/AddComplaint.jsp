<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Complaint</title>
<style>
td {
	padding: 10px;
	font-weight: bold;
	font-size: 20px;
}

input, select {
	font-size: 18px;
	width: 70%;
	border:black;
}
body
{
background-repeat:no-repeat;
background-size:cover;
background-image:url("images/cash bank.jpg");
}
.header-img {
	width: 100%;
	height: 250px;
	margin-top:-10px;
	background-repeat: no-repeat;
	background-image: url("images/headerImage.jpg");
}
</style>
</head>
<body>
<div class="header-img"></div>
	<header style="background-color: none; height: 50px; margin-top:-250px">
		<div>
			<span style="text-align: center"><h1>Complaint Registration</h1></span>
		</div>

	</header>
	<br>
	<br>
	<br>
	<div>
		<table align="center">
			<form:form action="/regComplaint" modelAttribute="complaint"
				method="POST">
				<tr>
					<td>Account Number</td>
					<td><sf:input type="tel" path="acctno" pattern="[4]{1}[5]{2}[0]{3}[0-9]{6}"
							required="required" /></td>
				</tr>
				<tr>
					<td>Complaint Type</td>
					<td><sf:select path="compType" items="${compType}"
							required="required" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><sf:input type="text" path="description"
							required="required" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" style="color:black"/></td>
				</tr>
			</form:form>
		</table>

	</div>
</body>
</html>