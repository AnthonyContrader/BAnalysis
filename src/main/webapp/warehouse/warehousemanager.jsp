<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.util.List"
    import="it.contrader.dto.WarehouseDTO"%> 
<!-- import per l'if else e ottenere l'id utente-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Warehouse Manager</title>
</head>
<body>

<%@ include file="../css/header.jsp" %>
<%@include file="../css/navbar.jsp"%>

<div class = "main">

	<% List<WarehouseDTO> list = (List<WarehouseDTO>) request.getAttribute("list"); %>
	
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
			for(WarehouseDTO w : list){
		%>
		<tr>
			<td>
				<a href=WarehouseServlet?mode=read&id=<%=w.getId()%>>
					Magazzino <%=w.getId()%>
				</a>
			</td>
			<td><%=w.getCity()%></td>
			<td><%=w.getCapacity()%></td>
			
			<c:if test="${fn:containsIgnoreCase(String, 'ADMIN')}"> 
				<td><a href=WarehouseServlet?mode=read&update=true&id=<%=w.getId()%>>Edit</a>
				</td>
				<td><a href=WarehouseServlet?mode=delete&id=<%=w.getId()%>>Delete</a>
				</td>
			</c:if>	
		</tr>
		<%
			}
		%>
	</table>
	
	<form id="floatright" action="WarehouseServlet?mode=insert" method="post">
	  <div class="row">
	    <div class="col-25">
	      <label for="city">City</label>
	    </div>
	    <div class="col-75">
	      <input type="text" id="city" name="city" placeholder="inserisci citta'">
	    </div>
	  </div>
	  <div class="row">
	    <div class="col-25">
	     <label for="capacity">Capacity</label>
	    </div>
	    <div class="col-75">
	      <input type="text" id="capacity" name="capacity" placeholder="inserisci capacita'"> 
	    </div>
	  </div>
	      <button type="submit" >Insert</button>
	</form>
</div>

<br><%@ include file="../css/footer.jsp" %>
</body>
</html>