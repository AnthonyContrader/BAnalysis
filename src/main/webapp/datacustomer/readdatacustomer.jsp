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
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="DataCustomerServlet?mode=datacustomerlist">Dati Clienti</a>
</div>
<br>

<div class="main">
<%DataCustomerDTO d = (DataCustomerDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Nome</th>
		<th>Cognome</th>
		<th>Età</th>
		<th>Email</th>
		<th>Numero di telefono</th>
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