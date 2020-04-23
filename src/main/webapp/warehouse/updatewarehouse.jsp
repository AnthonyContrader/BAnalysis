<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.WarehouseDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Magazzini</title>
</head>
<body>

<%@ include file="../css/header.jsp" %>
<%@include file="../css/navbar.jsp"%>

<br>
<div class="main">

<%WarehouseDTO w = (WarehouseDTO) request.getAttribute("dto");%>

<form id="floatleft" action="WarehouseServlet?mode=update&id=<%=w.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="city">Citta'</label>
    </div>
    <div class="col-75">
      <input type="text" id="city" name="city" value=<%=w.getCity()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="capacity">Capacita'</label>
    </div>
    <div class="col-75">
      <input type="text" id="capacity" name="capacity" value=<%=w.getCapacity()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>
</div>

<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>