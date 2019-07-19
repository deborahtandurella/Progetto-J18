<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Profile</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
    <div align="center">
     <br/>
        <h2>Benvenuto ${loggedCustomer.fullname}</h2>
        <br/>

    <table class="normal">
       <tr>
       
           <td><b>Indirizzo email:</b></td>
           <td>${loggedCustomer.email}</td>
       </tr>
        <tr>
       
           <td><b>Nome Completo:</b></td>
           <td>${loggedCustomer.fullname}</td>
       </tr>
              <tr>
       
           <td><b>Numero di telefono:</b></td>
           <td>${loggedCustomer.phone}</td>
       </tr>
       
        <tr>
       
           <td><b>Indirizzo:</b></td>
           <td>${loggedCustomer.address}</td>
       </tr>
       
        <tr>
       
           <td><b>Città:</b></td>
           <td>${loggedCustomer.city}</td>
       </tr>
       
       <tr>
       
           <td><b>Codice Postale:</b></td>
           <td>${loggedCustomer.zipcode}</td>
       </tr>
       
       <tr>
       
           <td><b>Paese:</b></td>
           <td>${loggedCustomer.country}</td>
       </tr>
       <tr><td>&nbsp;</td></tr>
       
       <tr>
       
           <td colspan="2"align="center"><b><a href="edit_profile">Modifica Profilo</a></b></td>
       </tr>
       
       </table>
    </div>

    <jsp:directive.include file="footer.jsp" />
</body>
</html>
</html>