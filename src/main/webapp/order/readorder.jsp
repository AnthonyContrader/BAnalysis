<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.OrderDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Order</title>
</head>
<body>

<%@ include file="../css/header.jsp" %>
<%@include file="../css/navbar.jsp"%>


<br>

<div class="main">
<%OrderDTO o = (OrderDTO) request.getAttribute("dto");%>

<table>
	<tr>
		<th>Order Number</th>
		<th>Quantity</th>
		<th>Date</th>
	</tr>
	<tr>
		<td> <%=o.getOrderNumber()%></td>
		<td> <%=o.getQuantity()%></td>
		<td> <%=o.getDate()%></td>
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