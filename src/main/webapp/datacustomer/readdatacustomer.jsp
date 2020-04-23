<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DataCustomerDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Leggi Dati Clienti</title>
</head>
<body>

<%@ include file="../css/header.jsp" %>
<%@include file="../css/navbar.jsp"%>

<br>
<h1 class="table_title">CUSTOMER DETAILS</h1>

<br>

<div class="main">
<%DataCustomerDTO d = (DataCustomerDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Surname</th>
		<th>Age</th>
		<th>Email</th>
		<th>Phone Number</th>
	</tr>
	<tr>
 
		
		<td> <%=d.getName()%></td>
		<td> <%=d.getSurname()%></td>
		<td> <%=d.getAge()%></td>
		<td> <%=d.getEmail()%></td>
		<td> <%=d.getPhoneNumber()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>