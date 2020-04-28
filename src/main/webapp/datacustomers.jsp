<%@ page import="it.contrader.dto.DataCustomerDTO" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="DataCustomer Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>DataCustomer Manager</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	
	

	<div class="navbar">
	<c:set var="String" value="${user.getUsertype()}"/> 
		<a href="/homeadmin.jsp">Home</a> 
       <c:if test="${fn:containsIgnoreCase(String, 'admin')}"> 
		<a href=/user/getall>Users</a>
			</c:if>  
			<a class = "active" href="/datacustomer/getall">Dati Clienti</a>  
			<a href="/user/logout" id="logout">Logout</a>
	</div>

	<div class="main">
		<%
			List<DataCustomerDTO> list = (List<DataCustomerDTO>) request.getSession().getAttribute("list");
		%>

		<br>
		
		<table>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Età</th>
				<th>Email</th>
				<th>Numero di telefono</th>
				<c:if test="${fn:containsIgnoreCase(String, 'admin')}">
				<th></th>
				<th></th>
				</c:if>  
			</tr>
			<%
				for (DataCustomerDTO d : list) {
			%>
			<tr>
				<td><a href="/datacustomer/read?id=<%=d.getId()%>"> <%=d.getName()%>
				</a></td>
				<td><a href="/datacustomer/read?id=<%=d.getId()%>"> <%=d.getSurname()%>
				</a></td>
				<td><%=d.getAge()%></td>
				<td><%=d.getEmail()%></td>
				<td><%=d.getPhoneNumber()%></td>
				
				
				<c:if test="${fn:containsIgnoreCase(String, 'admin')}"> 
					<td><a href="/datacustomer/preupdate?id=<%=d.getId()%>">Edit</a></td>

					<td><a href="/datacustomer/delete?id=<%=d.getId()%>">Delete</a></td>
				</c:if>
			</tr><%
				}
			%>
		</table>
		
		<form id="floatright" action="/datacustomer/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="name">Nome</label>
				</div>
				<div class="col-75">
					<input type="text" id="data_name" name="name"
						placeholder="inserisci nome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="surname">Cognome</label>
				</div>
				<div class="col-75">
					<input type="text" id="data_surname" name="surname"
						placeholder="inserisci cognome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="datacustomer">Età</label>
				</div>
				<div class="col-75">
					<input type="text" id="data_age" name="age"
						placeholder="inserisci età">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="datacustomer">Email</label>
				</div>
				<div class="col-75">
					<input type="text" id="data_email" name="email"
						placeholder="inserisci email">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="datacustomer">Numero di telefono</label>
				</div>
				<div class="col-75">
					<input type="text" id="data_phoneNumber" name="phoneNumber"
						placeholder="inserisci numero di telefono">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
			
</body>
</html>