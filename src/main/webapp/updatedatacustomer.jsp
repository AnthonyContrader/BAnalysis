<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DataCustomerDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="DataCustomer Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit DataCustomer</title>
</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a href="/user/getall">Users</a>
  <a class="active" href="/datacustomer/getall">Dati Clienti</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%DataCustomerDTO d = (DataCustomerDTO) request.getSession().getAttribute("dto");%>

<form id="floatleft" action="/datacustomer/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="datacustomer">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="data_name" name="name" value=<%=d.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="datacustomer">Cognome</label>
    </div>
    <div class="col-75">
      <input type="text" id="data_surname" name="surname" value=<%=d.getSurname()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="datacustomer">Et�</label>
    </div>
    <div class="col-75">
      <input type="text" id="data_age" name="age" value=<%=d.getAge()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="datacustomer">Email</label>
    </div>
    <div class="col-75">
      <input type="text" id="data_email" name="email" value=<%=d.getEmail()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="datacustomer">Numero di telefono</label>
    </div>
    <div class="col-75">
      <input type="text" id="data_phoneNumber" name="phoneNumber" value=<%=d.getPhoneNumber()%>>
    </div>
    <input type="hidden" name="id" value=<%=d.getId()%>>
  </div>
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>