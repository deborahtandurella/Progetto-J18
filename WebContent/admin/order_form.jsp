<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Edit Order - Evergreen Magazinestore Administration</title>
	<link rel="stylesheet" href="../css/style.css" >
	<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>	
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">Modifica ordine numero: ${order.ordineId}</h2>		
	</div>
	
	<c:if test="${message != null}">
	<div align="center">
		<h4 class="message">${message}</h4>
	</div>
	</c:if>
	
	<form action="update_order" method="post" id="orderForm">
	<div align="center">
	
		<table>
			<tr>
				<td><b>Ordinato da: </b></td>
				<td>${order.cliente.fullname}</td>
			</tr>
			<tr>
				<td><b>Data ordine: </b></td>
				<td>${order.orderDate}</td>
			</tr>			
			<tr>
				<td><b>Nome Destinatario: </b></td>
				<td><input type="text" name="recipientName" value="${order.recipientName}" size="45" /></td>
			</tr>
			<tr>
				<td><b>Telefono: </b></td>
				<td><input type="text" name="recipientPhone" value="${order.recipientPhone}" size="45" /></td>
			</tr>		
			<tr>
				<td><b>Spedito a: </b></td>
				<td><input type="text" name="shippingAddress" value="${order.shippingAddress}" size="45" /></td>
			</tr>			
			<tr>
				<td><b>Metodo di pagamento: </b></td>
				<td>
					<select name="paymentMethod">
						<option value="Cash On Delivery">Cash On Delivery</option>
					</select>
				</td>
			</tr>

			<tr>
				<td><b>Order Status: </b></td>
				<td>
					<select name="orderStatus">
						<option value="Processing" <c:if test="${order.status eq 'Processing' }">selected='selected'</c:if> >Processing</option>
						<option value="Shipping" <c:if test="${order.status eq 'Shipping' }">selected='selected'</c:if>>Shipping</option>
						<option value="Delivered" <c:if test="${order.status eq 'Delivered' }">selected='selected'</c:if>>Delivered</option>
						<option value="Completed" <c:if test="${order.status eq 'Completed' }">selected='selected'</c:if>>Completed</option>
						<option value="Cancelled" <c:if test="${order.status eq 'Cancelled' }">selected='selected'</c:if>>Cancelled</option>
					</select>
				</td>
			</tr>	
		</table>
	</div>
	<div align="center">
		<h2>Riviste ordinate</h2>
		<table border="1">
			<tr>
				<th>Indice</th>
				<th>Titolo Rivista</th>
				<th>Prezzo</th>
			</tr>
			<c:forEach items="${order.dettagliOrdines}" var="orderDetail" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${orderDetail.rivista.title}</td>
				<td>
					<input type="hidden" name="price" value="${orderDetail.rivista.price}" />
					${orderDetail.rivista.price} &euro;
				</td>
				
					<input type="hidden" name="rivistaId" value="${orderDetail.rivista.rivistaId}" />
	
			</tr>
			</c:forEach>
		</table>
	</div>
	<div align="center">
		<br/>		
		<input type="submit" value="Salva" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="Annulla" onclick="javascript:window.location.href='list_order';" /> 		
	</div>
	</form>
	
	<jsp:directive.include file="footer.jsp" />
	
</body>
</html>