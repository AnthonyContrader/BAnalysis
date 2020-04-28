<%@ page import="it.contrader.dto.OrderDTO" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html lang="en">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Order Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/order/getall">Orders</a><a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<OrderDTO> list = (List<OrderDTO>) request.getSession().getAttribute("list");
		%>

		<br>
		<c:set var="String" value="${user.getUsertype()}" />

		<table>
			<tr>
				<th>Order Number</th>
				<th>Quantity</th>
				<th>Date</th>
				<c:if test="${fn:containsIgnoreCase(String, 'admin')}">

					<th></th>
					<th></th>
				</c:if>

			</tr>
			<%
				for (OrderDTO o : list) {
			%>
			<tr>
				<td><a href="/order/read?id=<%=o.getId()%>"> <%=o.getOrderNumber()%>
				</a></td>
				<td><%=o.getQuantity()%></td>
				<td><%=o.getDate()%></td>

				<c:if test="${fn:containsIgnoreCase(String, 'admin')}">

					<td><a href="/order/preupdate?id=<%=o.getId()%>">Edit</a></td>


					<td><a href="/order/delete?id=<%=o.getId()%>">Delete</a></td>
				</c:if>


			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/order/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Order Number</label>
				</div>
				<div class="col-75">
					<input type="text" id="order" name="orderNumber"
						placeholder="inserisci numero ordine">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="quant">Quantity</label>
				</div>
				<div class="col-75">
					<input type="text" id="quant" name="quantity"
						placeholder="inserisci quantita'">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="da">Date</label>
				</div>
				<div class="col-75">
					<input type="text" id="da" name="date"
						placeholder="inserisci data'">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>