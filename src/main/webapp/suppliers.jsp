<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ page import="it.contrader.dto.SupplierDTO" import="java.util.*"%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="User Management">
	<link href="/css/vittoriostyle.css" rel="stylesheet">
	<title>Supplier Manager</title>
</head>
<body>
<body>
	<%@ include file="./css/header.jsp"%>
    <c:set var="String" value="${user.getUsertype()}"/> 
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<c:if test="${fn:containsIgnoreCase(String, 'admin')}"> 
			<a href=/user/getall>Users</a>
		</c:if>  
		<a href="/datacustomer/getall" id="datacustomer">Customers</a>
		<a href="/order/getall" id="order">Orders</a>
		<a class="active" href="/supplier/getall" id="supplier">Suppliers</a>
		<a href="/warehouse/getall" id="warehouse">Warehouses</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<SupplierDTO> list = (List<SupplierDTO>) request.getSession().getAttribute("list");
		%>
		<br>
		<table>
			<tr>
				<th>Name</th>
				<th>Country</th>
				<th>Email</th>
				<c:if test="${fn:containsIgnoreCase(String, 'admin')}">
					<th></th>
					<th></th>
				</c:if>
			</tr>
			<%
				for (SupplierDTO u : list) {
			%>
			<tr>
				<td><a href="/supplier/read?id=<%=u.getId()%>">
					<%=u.getName()%></a>
				</td>
				<td><%=u.getCountry()%></td>
				<td><%=u.getEmail()%></td>
				<c:if test="${fn:containsIgnoreCase(String, 'admin')}">
					<td><a href="/supplier/preupdate?id=<%=u.getId()%>">Edit</a></td>
					<td><a href="/supplier/delete?id=<%=u.getId()%>">Delete</a></td>
				</c:if>
			</tr>
			<%
				}
			%>
		</table>
		<form id="floatright" action="/supplier/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="supplier_name">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="supplier_name" name="name"
						placeholder="inserisci il nome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="supplier_country">Country</label>
				</div>
				<div class="col-75">
					<input type="text" id="supplier_country" name="country"
						placeholder="inserisci il paese">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="supplier_email">Email</label>
				</div>
				<div class="col-75">
					<input type="text" id="supplier_email" name="email"
						placeholder="inserisci la casella email">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>
	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>