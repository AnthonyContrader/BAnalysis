<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.WarehouseDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Magazzini</title>
</head>
<body>

<%@ include file="../css/header.jsp" %>
<%@include file="../css/navbar.jsp"%>


<br>
<div class="main">
<%WarehouseDTO w = (WarehouseDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Warehouse N</th>
		<th>City</th>
		<th>Capacity'</th>
	</tr>
	<tr>
		<td><%=w.getId()%></td>
		<td> <%=w.getCity()%></td>
		<td> <%=w.getCapacity()%></td>
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