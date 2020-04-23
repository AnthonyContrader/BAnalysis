<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SupplierDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Supplier</title>
</head>
<body>

<%@ include file="../css/header.jsp" %>
<%@include file="../css/navbar.jsp"%>

<br>
<h1 class="table_title">SUPPLIER  DETAILS</h1>

<br>

<div class="main">
<%SupplierDTO u = (SupplierDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Country</th>
		<th>Email</th>
	</tr>
	<tr>
		<td><%=u.getName()%></td>
		<td> <%=u.getCountry()%></td>
		<td> <%=u.getEmail()%></td>
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