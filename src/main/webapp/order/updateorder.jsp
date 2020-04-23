<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.OrderDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>

<%@ include file="../css/header.jsp" %>
<%@include file="../css/navbar.jsp"%>

<br>
<div class="main">

<%OrderDTO o = (OrderDTO) request.getAttribute("dto");%>


<form id="floatleft" action="OrderServlet?mode=update&id=<%=o.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="order_quantity">Quantity</label>
    </div>
    <div class="col-75">
      <input type="text" id="order_quantity" name="quantity" value=<%=o.getQuantity()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="order">Order Number</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="order" name="orderNumber" value=<%=o.getOrderNumber()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="order_date">Date</label>
    </div>
   		 <div class="col-75">
 		 
 			<input
			type="text" id="order_date" name="date" value=<%=o.getDate()%>> 
		
    	</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>