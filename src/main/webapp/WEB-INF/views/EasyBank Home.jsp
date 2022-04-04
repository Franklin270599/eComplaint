<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<style>
a {
	text-decoration: none;
	border-style:solid;
	border-color: black;
	font-size: 40px;
	padding: 10px;
	position: relative;
	margin: 20px;
}
body {
text-align: center;
background-repeat:no-repeat;
background-size:cover;
background-color: none;
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
	<header style="background-color: none; height: 50px; margin-top:-250px;">
		<div>
			<span style="text-align: center"><h1>EASY BANK LTD</h1>
			</span>
		</div>
	</header>
	<br>
	<br>
	<br>
	<br>	
	<a href="/AdminLogin" style="color:red">Admin</a>
	<a href="/UserLogin" style="color:red">Customer</a>
	</body>
</html>