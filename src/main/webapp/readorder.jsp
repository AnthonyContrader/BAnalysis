<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html lang="en"><%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="it.contrader.dto.OrderDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a>
		<a class="active" href="/order/getall">Orders</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>
	<c:set var="String" value="${user.getUsertype()}" />


	<div class="main">
		<%
			OrderDTO o = (OrderDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>

				<th>Order Number</th>
				<th>Quantity</th>
				<th>Date</th>
			</tr>
			<tr>
				<td><%=o.getOrderNumber()%></td>
				<td><%=o.getQuantity()%></td>
				<td><%=o.getDate()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>