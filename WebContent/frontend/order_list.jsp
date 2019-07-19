<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cronologia Ordini</title>
	<link rel="stylesheet" href="css/style.css" >	
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">Cronologia Ordini</h2>		
	</div>
	
	<c:if test="${fn:length(listOrders) == 0}">
		<div align="center">
			<h3>Non hai effettuato nessun ordine</h3>
		</div>
	</c:if>
	
	<c:if test="${fn:length(listOrders) > 0}">
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Indice</th>
				<th>N. Ordine</th>
				<th>Prezzo Totale</th>
				<th>Data ordine</th>
				<th>Tipo Abbonamento</th>
				<th>Stato</th>
				<th>Azione</th>
			</tr>
			<c:forEach var="order" items="${listOrders}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${order.ordineId}</td>				
				<td>${order.total} &euro;</td>				
				<td>${order.orderDate}</td>
				<td>${order.subscriptionDuration}</td>
				<td>${order.status}</td>
				<td>
					<a href="show_order_detail?id=${order.ordineId}">Visualizza dettagli</a> &nbsp;
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	</c:if>
	
	<jsp:directive.include file="footer.jsp" />
</body>
</html>