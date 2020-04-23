<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.DataCustomerDTO"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Data Customer Manager</title>
</head>
<body>

<%@ include file="../css/header.jsp" %>
<%@include file="../css/navbar.jsp"%>

<div class="main">
	<%
		List<DataCustomerDTO> list = (List<DataCustomerDTO>) request.getAttribute("list");
	%>

<br>
    <c:set var="String" value="${user.getUsertype()}"/> 
	<table>
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>Age</th>
			<th>Email</th>
			<th>Phone Number</th>
				<c:if test="${fn:containsIgnoreCase(String, 'admin')}"> 
			
			<th></th>
			<th></th>
						</c:if>  
			
		</tr>
		<%
			for (DataCustomerDTO d : list) {
		%>
		<tr>
			<td>
			
			<a href=DataCustomerServlet?mode=read&id=<%=d.getId()%>><%=d.getName()%>
			
			</a></td>
			<td><a href=DataCustomerServlet?mode=read&id=<%=d.getId()%>><%=d.getSurname()%></a></td>
			<td><%=d.getAge()%></td>
			<td><%=d.getEmail()%></td>
			<td><%=d.getPhoneNumber()%></td>
			
			 
			<c:if test="${fn:containsIgnoreCase(String, 'admin')}">   
			<td><a href=DataCustomerServlet?mode=read&update=true&id=<%=d.getId()%>>Edit</a>
			</td>
			<td><a href=DataCustomerServlet?mode=delete&id=<%=d.getId()%>>Delete</a>
			</td>  
			</c:if>  
 
		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="DataCustomerServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="data_name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="data_name" name="name" placeholder="inserisci nome">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="data_surname">Surname</label>
    </div>
    <div class="col-75">
      <input type="text" id="data_surname" name="surname" placeholder="inserisci cognome"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="data_age">Età</label>
    </div>
   		 <div class="col-75">
      <input type="text" id="data_age" name="age" placeholder="inserisci età"> 

    	</div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="data_email">Email</label>
    </div>
   		 <div class="col-75">
      <input type="text" id="data_email" name="email" placeholder="inserisci email"> 

    	</div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="data_phoneNumber">Phone Number</label>
    </div>
   		 <div class="col-75">
      <input type="text" id="data_phoneNumber" name="phoneNumber" placeholder="inserisci numero di telefono"> 

    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>