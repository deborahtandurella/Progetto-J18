<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Order Details - Evergreen Magazinestore Administration</title>
	<link rel="stylesheet" href="../css/style.css" >
	<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>	
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">Dettagli dell'ordine ID: ${order.ordineId}</h2>		
	</div>
	
	<c:if test="${message != null}">
	<div align="center">
		<h4 class="message">${message}</h4>
	</div>
	</c:if>
	
	<div align="center">
		<h2>Info Ordine:</h2>	
		<table>
			<tr>
				<td><b>Ordinato da: </b></td>
				<td>${order.cliente.fullname}</td>
			</tr>
			<tr>
				<td><b>Prezzo Totale: </b></td>
				<td>${order.total} &euro;</td>
			</tr>			
			<tr>
				<td><b>Nome Destinatario: </b></td>
				<td>${order.recipientName}</td>
			</tr>
			<tr>
				<td><b>Telofono: </b></td>
				<td>${order.recipientPhone}</td>
			</tr>
			<tr>
				<td><b>Metodo di pagamento: </b></td>
				<td>${order.paymentMethod}</td>
			</tr>
			<tr>
				<td><b>Indirizzo di spedizione: </b></td>
				<td>${order.shippingAddress}</td>
			</tr>
			<tr>
				<td><b>Stato dell'ordine: </b></td>
				<td>${order.status}</td>
			</tr>
			<tr>
				<td><b>Data ordine: </b></td>
				<td>${order.orderDate}</td>
			</tr>												
		</table>
	</div>
	<div align="center">
		<h2>Riviste Ordinate</h2>
		<table border="1">
			<tr>
				<th>Indice</th>
				<th>Titolo Rivista</th>
				<th>Prezzo</th>

			</tr>
			<c:forEach items="${order.dettagliOrdines}" var="dettagliOrdine" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>
				<img src="data:image/jpg;base64,${dettagliOrdine.rivista.base64Image}" width="48" height="64" /> 
					${dettagliOrdine.rivista.title}
				</td>
				<td>${dettagliOrdine.rivista.price} &euro;</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="4" align="right">
					<b><i>Totale:</i></b>
				</td>
				<td>
					<b>${order.total} &euro;</b>
				</td>
			</tr>
		</table>
	</div>	
	<jsp:directive.include file="footer.jsp" />
	
	
</body>
</html>