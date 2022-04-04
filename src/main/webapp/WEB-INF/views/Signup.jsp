<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>User Registration</title>
<style>
th, td,table {
	padding: 10px;
}
body {
	background-repeat: no-repeat;
	background-size: cover;
	background-color: none;
	background-image: url("images/cash bank.jpg");
}
.header-img {
	width: 100%;
	height: 250px;
	margin-top:-10px;
	background-repeat: no-repeat;
	background-image: url("images/headerImage.jpg");
}
td, p {
	font-weight: bold;
	font-size: 20px;
}
input[type=text], input[type=password], input[type=email], input[type=contact]
	{
	border: 2px solid black;
	box-sizing: border-box;
}

input[type=text]:focus {
	background-color: lightblue;
}
</style>
</head>
<script type="text/javascript">
	function validate(form) {
		var a = document.getElementById("password");
		var valid = true;
		if (password.value.length<8 || password.value.length>15
				|| password.value == "/^[A-Za-z]\w{7,14}$/") {
			alert("Please enter a valid password!! Password should contain 8 characters with one lowercase, one uppercase and a number");
			valid = false;
		} else {

			valid = true;
		}
		return valid;
	}
</script>
<body>
	<div class="header-img"></div>
	<header style="height: 50px; margin-top:-250px;">
		<div align="center" style="font-size: 20px;">
			<span style="text-align: center"><h1>CUSTOMER REGISTRATION</h1></span>
			<p style=color:brown;>Please fill the details to create a account.You will be redirected to Login when you register<p>
		</div>
	</header>
	<br>
	<br>
	<br>
	<div>
		<table align="center">
			<form:form action="/addCustomer" modelAttribute="user" method="POST"
				onSubmit="return validate(this)">
				<tr>
					<td>Name</td>
					<td><sf:input path="name" type="text" placeholder="Enter your name" required="required" /></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><sf:input path="username" type="text" placeholder="Enter a unique username" required="required" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><sf:input type="password" path="password" placeholder="Enter your password"
							required="required" id="password" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><sf:input type="email" path="email" placeholder="Enter your Email-ID" required="required" /></td>
				</tr>
				<tr>
					<td>Contact</td>
					<td><sf:input type="tel" path="contact" required="required" placeholder="Enter your mobile number"
							pattern="[7-9]{1}[0-9]{9}" /></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="Register" style="font-weight:bold"/></td>
				</tr>
				<tr align="center">
				<td colspan="2"><input type="reset" value="Reset" style="font-weight:bold"></td>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>