<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DataCustomerDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="DataCustomer Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read DataCustomer</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/user/getall">Users</a> 
			<a class="active"
			href="/datacustomer/getall">Dati Clienti</a>
			<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>
	
	<div class="main">
		<%
			DataCustomerDTO d = (DataCustomerDTO) request.getSession().getAttribute("dto");
		%>
		<table>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Et�</th>
				<th>Email</th>
				<th>Numero di telefono</th>
			</tr>
			<tr>
				<td><%=d.getName()%></td>
				<td><%=d.getSurname()%></td>
				<td><%=d.getAge()%></td>
				<td><%=d.getEmail()%></td>
				<td><%=d.getPhoneNumber()%></td>
			</tr>
			</table>
			
			<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>