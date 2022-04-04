<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Bank Login</title>
<style>

th, td {
padding: 10px;
font-weight:bold;
font-size:18px;
}
body{
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
	<header style="height: 50px; margin-top:-250px;">
		<div>
			<span style="text-align: center"><h1>ADMIN LOGIN</h1></span>
		</div>

	</header>
	<br>
	<br>
	<br>
	<div>
		<table align="center">
			<form:form action="/ComplaintList" modelAttribute="admin"
				method="POST">

				<tr>
					<td>Username</td>
					<td><sf:input type="text" align="center" path="username" value="EasyAdmin"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><sf:input type="password" align="center" path="password" value="Easy*123" required="required" /></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="Sign In" style="font-weight:bold" /></td>
				</tr>
			</form:form>
		</table>
	</div>
	</body>
</html>