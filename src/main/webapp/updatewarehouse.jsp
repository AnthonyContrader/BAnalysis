<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.contrader.dto.WarehouseDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Warehouse Edit page">
<meta name="author" content="Gigi Giannoni">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Warehouse</title>
</head>
<body>
	<%@ include file="./css/header.jsp" %>
	<div class="navbar">
	  <a href="/homeadmin.jsp">Home</a>
	  <a href="/user/getall">Users</a>
	  <a class="active" href=/warehouse/getall>Warehouses</a> 
	  <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>
	<div class="main">
	
	<% WarehouseDTO w = (WarehouseDTO) request.getSession().getAttribute("dto"); %>
	
	<form id="floatleft" action="/warehouse/update" method="post">
	  <div class="row">
	    <div class="col-25">
	      <label for="city">City</label>
	    </div>
	    <div class="col-75">
	      <input type="text" id="city" name="city" value=<%=w.getCity()%>>
	    </div>
	  </div>
	  <div class="row">
	    <div class="col-25">
	     <label for="capacity">Capacity</label>
	    </div>
	    <div class="col-75">
	      <input
				type="text" id="capacity" name="capacity" value=<%=w.getCapacity()%>> 
	    </div>
	  </div>
   		<input type="hidden" name="id" value =<%=w.getId()%>>
        <button type="submit" >Edit</button>
	</form>
	</div>
<br>
<%@ include file="../css/footer.jsp" %>	

</body>
</html>