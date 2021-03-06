<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
<!DOCTYPE html>
<html>
<head>
	<meta http- charset="ISO-8859-1">
	<title>Nuovo Cliente</title> 
	
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/jquery-ui.min.css">    
    
    <script type="text/javascript" src="../js/jquery-3.4.0.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
	

</head>
<body>
	<jsp:directive.include file="header.jsp" />
    <div align="center">
        <h2 class="pageheading">
        	<c:if test="${customer != null}">
        		Modifica Cliente
        	</c:if>
        	<c:if test="${customer == null}">
        		Crea Nuovo Cliente
        	</c:if>
        	
        </h2>
    </div>

    <div align="center">
    	<c:if test="${customer != null}">
    		<form action="update_customer" method="post" id="customerForm">
    		<input type="hidden" name="rivistaId" value="${rivista.rivistaId}">
    		
    	</c:if>
    	
    	<c:if test="${customer == null}">
    		<form action="create_customer" method="post" id="customerForm">
    	</c:if>
    	
			<table class="form">
      				<td align="right">E-mail:</td>
      				<td align="left"><input type="text" id="email" name="email" size="45" value="${customer.email}"/></td>
      			</tr>
      			<tr>
      				<td align="right">Nome Completo:</td>
      				<td align="left"><input type="text" id="fullname" name="fullname" size="45" value="${customer.fullname }"/></td>
      			</tr>
      			<tr>
      				<td align="right">Password</td>
      				<td align="left">
      					<input type="password" id="password" name="password" size="45" value="${customer.password }"/><br/>
      				</td>
      			</tr>
      				<tr>
      				<td align="right">Conferma Password:</td>
      				<td align="left">
      					<input type="password" id="confirmPassword" name="confirmPassword" size="45" value="${customer.password }"/><br/>
      				</td>
      			</tr>
      			<tr>
      				<td align="right">Numero di telefono:</td>
      				<td align="left"><input type="text" id="phone" name="phone" size="45" value="${customer.phone }"/> </td>
      			</tr>
      			
      			<tr>
      				<td align="right">Indirizzo:</td>
      				<td align="left"><input type="text" id="address" name="address" size="45" value="${customer.address }"/> </td>
      			</tr>
      			<tr>
      				<td align="right">Citt�:</td>
      				<td align="left"><input type="text" id="city" name="city" size="45" value="${customer.city }"/> </td>
      			</tr>
      			<tr>
      				<td align="right">Codice Postale</td>
      				<td align="left"><input type="text" id="zipcode" name="zipcode" size="10" value="${customer.zipcode }"/> </td>
      			</tr>
      			<tr>
      				<td align="right">Paese:</td>
      				<td align="left"><input type="text" id="country" name="country" size="45" value="${customer.country }"/> </td>
      			</tr>
      			<tr><td>&nbsp;</td></tr>
      			<tr>
      				<td colspan="2" align="center">
      					<button type="submit">Salva</button>&nbsp;&nbsp;&nbsp;
      					<button id="buttonCancel">Cancella</button>
      				</td>
      			</tr>
      		</table>
		</form>
    </div>
    
    <jsp:directive.include file="footer.jsp" />
</body>

<script type="text/javascript">

	$(document).ready(function () {
	
		$("#customerForm").validate({
			rules: {
				email:{
					required: true,
					email: true
				},
				fullname: "required",
				password: "required",
				confirmPassword: {
					required: true,
					equalTo: "#password"
				},
				phone: "required",
				address: "required",
				city: "required",
				zipcode: "required",
				country: "required",
			},
			
			messages: {		
				email: {
					required: "Inserisci l'email",
					email: "Inserisci un email valido"
				},
				fullname: "Inserisci nome completo",
				password: "Inserisci password",
				confirmPassword: {
					required: "Conferma password",
					equalTo: "Password non corrisponde"
				},
				phone: "Inserisci numero di telefono",
				address: "Inserisci indirizzo",
				city: "Inserisci citt�",
				zipcode: "Inserisci codice postale",
				country: "Inserisci paese",
			}
		});
		$("#buttonCancel").click(function () {
			history.go(-1);
		});
	});
	
</script>


</html>













