<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.contrader.dto.WarehouseDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Warehouse Read">
<meta name="author" content="Gigi Giannoni">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Warehouse</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a> 
		<a class="active" href=/warehouse/getall>Warehouses</a> 
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	
	<br>

	<div class="main">
		<%
			WarehouseDTO w = (WarehouseDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>Warehouse N</th>
				<th>City</th>
				<th>Capacity</th>
			</tr>
			<tr>
				<td><%=w.getId()%></td>
				<td><%=w.getCity()%></td>
				<td><%=w.getCapacity()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>

	</div>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>