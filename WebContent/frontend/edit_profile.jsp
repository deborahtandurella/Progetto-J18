<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Modifica profilo</title>
	
	<link rel="stylesheet" href="css/style.css" >
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">
			Modifica Profilo
		</h2>
	</div>
	
	<div align="center">
		<form action="update_profile" method="post" id="customerForm">
		
		<table class="form">
			<tr>
				<td align="right">Indirizzo email:</td>
				<td align="left" id="email" name="email" value="${loggedCustomer.email}"><b>${loggedCustomer.email}</b> (Non può essere modificata)</td>
			</tr>
			<tr>
				<td align="right">Nome completo:</td>
				<td align="left"><input type="text" id="fullName" name="fullName" size="45" value="${loggedCustomer.fullname}" /></td>
			</tr>			
			<tr>
				<td align="right">Numero di telefono:</td>
				<td align="left"><input type="text" id="phone" name="phone" size="45" value="${loggedCustomer.phone}" /></td>
			</tr>
			<tr>
				<td align="right">Indirizzo:</td>
				<td align="left"><input type="text" id="address" name="address" size="45" value="${loggedCustomer.address}" /></td>
			</tr>
			<tr>
				<td align="right">Citta:</td>
				<td align="left"><input type="text" id="city" name="city" size="45" value="${loggedCustomer.city}" /></td>
			</tr>
			<tr>
				<td align="right">Codice postale:</td>
				<td align="left"><input type="text" id="zipCode" name="zipCode" size="45" value="${loggedCustomer.zipcode}" /></td>
			</tr>
			<tr>
				<td align="right">Paese:</td>
				<td align="left"><input type="text" id="country" name="country" size="45" value="${loggedCustomer.country}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<i>(Lascia il campo password vuoti se non deisderi cambiarla)</i>
				</td>
			</tr>
			<tr>
				<td align="right">Nuova Password:</td>
				<td align="left"><input type="password" id="password" name="password" size="45" /></td>
			</tr>
			<tr>
				<td align="right">Conferma Password:</td>
				<td align="left"><input type="password" id="confirmPassword" name="confirmPassword" size="45" /></td>
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

	$(document).ready(function() {
		$("#customerForm").validate({
			rules: {
				email: {
					required: true,
					email: true
				},
				fullName: "required",
				
				confirmPassword: {
					equalTo: "#password"
				},
				
				phone: "required",								
				address: "required",
				city: "required",
				zipCode: "required",
				country: "required",
			},
			
			messages: {
				email: {
					required: "Inserisci l'email",
					email: "Inserisci un'eamil valida"
				},
				
				fullName: "Inserisci nome completo",
				
				confirmPassword: {
					equalTo: "Passoword non coincidono"
				},
				
				phone: "Inserisci numero di telefono",								
				address: "Inserisci la via",
				city: "Inserisci la città",
				zipCode: "Inserisci il dodice postale",
				country: "Inserisci il paese",
			}
		});
		
		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});	
</script>
</html>








