<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.OrderDTO"%>
<!-- import per l'if else e ottenere l'id utente-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Order Manager</title>
</head>
<body>


<%@ include file="../css/header.jsp" %>
<%@include file="../css/navbar.jsp"%>

<br>
<h1 class="table_title">ORDERS</h1>

<div class="main">
	<%
		List<OrderDTO> list = (List<OrderDTO>) request.getAttribute("list");
	%>

<br>
    <c:set var="String" value="${user.getUsertype()}"/> 
	<table>
		<tr>
			<th>Order Number</th>
			<th>Quantity</th>
			<th>Date</th>
				<c:if test="${fn:containsIgnoreCase(String, 'admin')}"> 
					<th></th>
					<th></th>
				</c:if>  
			
		</tr>
		<%
			for (OrderDTO o : list) {
		%>
		<tr>
			<td><a href=OrderServlet?mode=read&id=<%=o.getId()%>><%=o.getOrderNumber()%></a></td>
			<td><%=o.getQuantity()%></td>
			<td><%=o.getDate()%></td>
			 
			<c:if test="${fn:containsIgnoreCase(String, 'admin')}">   
				<td><a href=OrderServlet?mode=read&update=true&id=<%=o.getId()%>>Edit</a>
				</td>
				<td><a href=OrderServlet?mode=delete&id=<%=o.getId()%>>Delete</a>
				</td>  
			</c:if>  
 
		</tr>
		<%
			}
		%>
	</table>


<form id="floatright" action="OrderServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
     <label for="order_number">Order Number</label>
    </div>
    <div class="col-75">
      <input type="text" id="order_number" name="orderNumber" placeholder="inserisci numero ordine"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="order_quantity">Quantity</label>
    </div>
    <div class="col-75">
      <input type="text" id="order_quantity" name="quantity" placeholder="inserisci quantita'">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="order_date">Date</label>
    </div>
   		 <div class="col-75">
      <input type="text" id="order_date" name="date" placeholder="inserisci data"> 

    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>