<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Complaint Page</title>
<style>
td {
	padding: 10px;
	font-weight: bold;
	font-size: 20px;
}
p{
font-family:Times New Roman;
}
input, select {
	font-size: 15px;
	width: 100%;
	border: 1px solid black;
	border-bottom: 1px solid;
}
body
{
background-repeat:no-repeat;
background-size:cover;
background-color:#d5f4e6;
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
	<header style="background-color: light red; height: 50px; margin-top:-250px;">
		<div>
			<span style="text-align: center"><h1>USER HOME</h1></span>
		</div>

	</header>
	<br>
	<br>
	<br>
	<div>
		<form:form action="/AddComplaint" modelAttribute="user" method="POST">
			<table align="center">
				<tr>
					<td><sf:button>Add Complaint</sf:button></td>
					<td><input type="submit"  value="View Complaint" formaction='/ViewCustComp'></td>
				</tr>
			</table>

		</form:form>

	</div>
	<div style="text-align:center">
		<h2 style="background-color: #b3b3b3; height: 45px;">ABOUT</h2>
	</div>
	<div>
		<p style="font-size: 25px; font-weight:bold; color:black;">Easy Bank is a German multinational investment bank and financial services company headquartered in Frankfurt, Germany, and dual-listed in New York Stock Exchange and Frankfurt Stock Exchange.The bank's network spans 58 countries with a large presence in Europe, the Americas and Asia. As of 2017 to 2018, Deutsche Bank was the 17th largest bank in the world by total assets. As the largest German banking institution, it is a component of the DAX stock market index.
The company is a universal bank with three major divisions such as the Private and Commercial Bank, the Corporate and Investment Bank (CIB), and Asset Management (DWS). Its investment banking operations often command substantial deal flow.</p> 
	</div>
</body>
</html>