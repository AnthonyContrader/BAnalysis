<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SupplierDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Supplier</title>
</head>
<body>

<%@ include file="../css/header.jsp" %>
<%@include file="../css/navbar.jsp"%>

<br>
<h1 class="table_title">UPDATE SUPPLIER</h1>

<br>
<div class="main">

<%SupplierDTO u = (SupplierDTO) request.getAttribute("dto");%>


<form id="floatleft" action="SupplierServlet?mode=update&id=<%=u.getId()%>" method="post">
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
      <button type="submit" >Edit</button>
</form>


</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>