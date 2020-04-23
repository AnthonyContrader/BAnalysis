<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.SupplierDTO"%>
<!-- import per l'if else e ottenere l'id utente-->	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Supplier Manager</title>
</head>
<body>

<%@ include file="../css/header.jsp" %>
<%@include file="../css/navbar.jsp"%>

<div class="main">
	<%
		List<SupplierDTO> list = (List<SupplierDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Country</th>
			<th>Email</th>
			<c:set var="usertype" value="${user.getUsertype()}"/>
			<c:if test="${fn:containsIgnoreCase(usertype, 'admin')}">
			  <th></th>
			  <th></th>
			</c:if>
		</tr>
		<%
			for (SupplierDTO u : list) {
		%>
		<tr>
			<td><a href=SupplierServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getName()%>
			</a></td>
			<td><%=u.getCountry()%></td>
			<td><%=u.getEmail()%></td>
			<c:set var="usertype" value="${user.getUsertype()}"/>
			<c:if test="${fn:containsIgnoreCase(usertype, 'admin')}">
			  <td><a href=SupplierServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			  </td>
			  <td><a href=SupplierServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			  </td>
			</c:if>

		</tr>
		<%
			}
		%>
	</table>

	<form id="floatright" action="SupplierServlet?mode=insert" method="post">
	  <div class="row">
	    <div class="col-25">
	      <label for="supplier_name">Name</label>
	    </div>
	    <div class="col-75">
	      <input type="text" id="supplier_name" name="name" placeholder="inserisci il nome">
	    </div>
	  </div>
	  <div class="row">
	    <div class="col-25">
	     <label for="supplier_country">Country</label>
	    </div>
	    <div class="col-75">
	      <input type="text" id="supplier_country" name="country" placeholder="inserisci il paese"> 
	    </div>
	  </div>
	  <div class="row">
	    <div class="col-25">
	      <label for="supplier_email">Email</label>
	    </div>
	   	<div class="col-75">
	      <input type="text" id="supplier_email" name="email" placeholder="inserisci l'email"> 
	    </div>
	  </div>
	      <button type="submit" >Insert</button>
	</form>
</div>

<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>