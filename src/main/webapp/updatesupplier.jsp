<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SupplierDTO"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Supplier Edit page">
	<link href="/css/vittoriostyle.css" rel="stylesheet">
	<title>Edit Supplier</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a>
		<a class="active" href="/supplier/getall">Suppliers</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>
	<div class="main">
		<%SupplierDTO u = (SupplierDTO) request.getSession().getAttribute("dto");%>
		<form id="floatleft" action="/supplier/update" method="post">
			<div class="row">
				<div class="col-25">
					<label for="supplier_name">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="supplier_name" name="name" value=<%=u.getName()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="supplier_country">Country</label>
				</div>
				<div class="col-75">
					<input type="text" id="supplier_country" name="country" value=<%=u.getCountry()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="supplier_email">Email</label>
				</div>
    			<div class="col-75">
					<input type="text" id="supplier_email" name="email" value=<%=u.getEmail()%>>
				</div>
			</div>
			<input type="hidden" name="id" value =<%=u.getId() %>>
			<button type="submit" >Edit</button>
		</form>
	</div>
	<br>
	<%@ include file="./css/footer.jsp" %>	
</body>
</html>