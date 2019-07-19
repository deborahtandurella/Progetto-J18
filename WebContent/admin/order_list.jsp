<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Manage Orders - Evergreen Magazinestore Administration</title>
	<link rel="stylesheet" href="../css/style.css" >
     <script type="text/javascript" src="../js/jquery-3.4.0.min.js"></script>
	
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">Gestione Abbonamenti</h2>		
	</div>
	
	<c:if test="${message != null}">
	<div align="center">
		<h4 class="message">${message}</h4>
	</div>
	</c:if>
	
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Indice</th>
				<th>N. Abbonamenti</th>
				<th>Effettuato da</th>
				<th>Prezzo Totale</th>
				<th>Data inizio</th>
				<th>Tipo abbonamneto</th>
				<th>Metodo di pagamento</th>
				<th>Stato</th>
				<th>Azione</th>
			</tr>
			<c:forEach var="order" items="${listOrder}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${order.ordineId}</td>
				<td>${order.cliente.fullname}</td>
				<td>${order.total} &euro;</td>
				<td>${order.orderDate}</td>
				<td>${order.subscriptionDuration}</td>
				<td>${order.paymentMethod}</td>
				<td>${order.status}</td>
				
				<td>
					<a href="view_order?id=${order.ordineId}">Dettagli</a> &nbsp;
					<a href="edit_order?id=${order.ordineId}">Modifica</a> &nbsp;
					<a href="javascript:void(0)" class="deleteLink" id="${order.ordineId}">Elimina</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	
	<jsp:directive.include file="footer.jsp" />
	
	<script>
		$(document).ready(function ()  {
			$(".deleteLink").each(function() {
				$(this).on("click", function() {
					ordineId = $(this).attr("id");
					if (confirm('Sei sicuro di vuol eliminare ordine con ID ' +  ordineId + '?')) {
						window.location = 'delete_order?id=' + ordineId;
					}					
				});
			});
		});	
	</script>
</body>
</html>