<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SupplierDTO"%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Supplier Read">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Supplier</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a>
		<a class="active" href="/supplier/getall">Suppliers</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>
	<div class="main">
		<%
			SupplierDTO u = (SupplierDTO) request.getSession().getAttribute("dto");
		%>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Country</th>
				<th>Email</th>
			</tr>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getName()%></td>
				<td><%=u.getCountry()%></td>
				<td><%=u.getEmail()%></td>
			</tr>
		</table>
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>
	</div>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>