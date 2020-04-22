<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.OrderDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Order</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="OrderServlet?mode=orderlist">Orders</a>
</div>
<br>

<div class="main">
<%OrderDTO o = (OrderDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Quantity</th>
		<th>Order Number</th>
		<th>Date</th>
	</tr>
	<tr>
 
		
		<td> <%=o.getQuantity()%></td>
		<td> <%=o.getOrderNumber()%></td>
		<td> <%=o.getDate()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>