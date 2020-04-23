<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DataCustomerDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Modifica Dati Clienti</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="DataCustomerServlet?mode=datacustomerlist">Dati Clienti</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%DataCustomerDTO d = (DataCustomerDTO) request.getAttribute("dto");%>


<form id="floatleft" action="DataCustomerServlet?mode=update&id=<%=d.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="data_name">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="data_name" name="name" value=<%=d.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="data_surname">Cognome</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="data_surname" name="surname" value=<%=d.getSurname()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="data_age">Età</label>
    </div>
   		 <div class="col-75">
 		 
 			<input
			type="text" id="data_age" name="age" value=<%=d.getAge()%>> 
		
    	</div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="data_email">Email</label>
    </div>
   		 <div class="col-75">
 		 
 			<input
			type="text" id="data_email" name="email" value=<%=d.getEmail()%>> 
		
    	</div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="data_phoneNumber">Numero di telefono</label>
    </div>
   		 <div class="col-75">
 		 
 			<input
			type="text" id="data_phoneNumber" name="phoneNumber" value=<%=d.getPhoneNumber()%>> 
		
    	</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>