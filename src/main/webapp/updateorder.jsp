<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html lang="en"><%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="it.contrader.dto.OrderDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Order Edit page">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Order</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/order/getall">Orders</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>
	<div class="main">
		<c:set var="String" value="${user.getUsertype()}" />


		<%
			OrderDTO o = (OrderDTO) request.getSession().getAttribute("dto");
		%>


		<form id="floatleft" action="/order/update" method="post">
			<div class="row">
				<div class="col-25">
					<label for="order">Order Number</label>
				</div>
				<div class="col-75">
					<input type="text" id="order" name="orderNumber"
						value=<%=o.getOrderNumber()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Quantity</label>
				</div>
				<div class="col-75">
					<input type="text" id="pass" name="quantity"
						value=<%=o.getQuantity()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="da">Date</label>
				</div>
				<div class="col-75">


					<input type="text" id="da" name="date" value=<%=o.getDate()%>>
				</div>
				<input type="hidden" name="id" value=<%=o.getId()%>>
			</div>
			<c:if test="${fn:containsIgnoreCase(String, 'admin')}">

				<button type="submit">Edit</button>
			</c:if>

		</form>


	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>