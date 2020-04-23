<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"
	import="it.contrader.dto.WarehouseDTO"%>
    
<!-- import per l'if else e ottenere l'id utente-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<div class="navbar">		
		<c:set var="String" value="${user.getUsertype()}"/><!-- setto la stringa con usertype -->
	
		<a href="homeadmin.jsp">Home</a>
		<c:if test="${fn:containsIgnoreCase(String, 'ADMIN')}">
			<a href="UserServlet?mode=userlist">Users</a>
		</c:if>
		<a href="DataCustomerServlet?mode=datacustomerlist">Customers</a> <!-- collegamento a fornitori -->
		<a href="SupplierServlet?mode=supplierlist">Suppliers</a> <!-- collegamento a fornitori -->
		<a href="OrderServlet?mode=orderlist">Orders</a> <!-- collegamento a ordini -->
		<a href="WarehouseServlet?mode=warehouselist">Warehouses</a> <!-- collegamento a magazzini -->
		<a href="LogoutServlet" id="logout">Logout</a>
	</div>
</body>
</html>