<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.contrader.dto.WarehouseDTO" import="java.util.*"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
    
<html>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Warehouse Management">
<meta name="author" content="Gigi Giannoni">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Warehouse Manager</title>

</head>
<body>
<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a> 
		<a class="active" href=/warehouse/getall>Warehouses</a> 
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<WarehouseDTO> list = (List<WarehouseDTO>) request.getSession().getAttribute("list");
		%>
		
		<c:set var="String" value="${user.getUsertype()}"/>
		
	<br>
		<table>
			<tr>
				<th>Warehouse ID</th>
				<th>City</th>
				<th>Capacity</th>
				<c:if test="${fn:containsIgnoreCase(String, 'ADMIN')}"> 
					<th></th>
					<th></th>
				</c:if>
			</tr>
			<%
				for (WarehouseDTO w : list) {
			%>
			<tr>
				<td><a href="/warehouse/read?id=<%=w.getId()%>"> 
					Magazzino <%=w.getId()%>
				</a></td>
				<td><%=w.getCity()%></td>
				<td><%=w.getCapacity()%></td>
				
				<c:if test="${fn:containsIgnoreCase(String, 'ADMIN')}"> 
					<td><a href="/warehouse/preupdate?id=<%=w.getId()%>">Edit</a></td>
					<td><a href="/warehouse/delete?id=<%=w.getId()%>">Delete</a></td>
				</c:if>	
			</tr>
			<%
				}
			%>
		</table>

		<form id="floatright" action="/warehouse/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="city">City</label>
				</div>
				<div class="col-75">
					<input type="text" id="city" name="city"
						placeholder="inserisci citta'">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="capacity">Capacity</label>
				</div>
				<div class="col-75">
					<input type="text" id="capacity" name="capacity"
						placeholder="inserisci capacita'">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>
	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>

</body>
</html>