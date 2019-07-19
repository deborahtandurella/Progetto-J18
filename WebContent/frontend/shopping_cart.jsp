<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Abbonamenti in Attesa</title>
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery-3.4.0.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		
		
	<c:if test="${message != null}">
    	<div align="center">
    		<h4 class="message">${message}</h4>
    	</div>
	</c:if>

	<c:set var="cart" value="${sessionScope['cart']}" />

		<c:if test="${cart.totalItems == 0}">
			<h2>Carrello Vuoto</h2>
		</c:if>

		<c:if test="${cart.totalItems > 0}">
			<h2>Abbonamenti non completati</h2> 
			<form action="update_cart" method="post" id="cartForm">
				<div>
					<table border="1">
						<tr>
							<th>No</th>
							<th colspan="2">Rivista</th>
							<th>Prezzo</th>
							<th>Azione</th>
						</tr>
						<c:forEach items="${cart.items}" var="item" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>   	 
								<img class="rivista-small" src="data:image/jpg;base64,${item.key.base64Image}" />
								</td>
								<td><span id="rivista-title">${item.key.title}</span></td>
									<input type="hidden" name="rivistaId" value="${item.key.rivistaId}" />
								<td>${item.key.price}</td>
								<td><a href="remove_from_cart?id=${item.key.rivistaId}">Rimuovi</a></td>
							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td><b>${cart.totalQuantity} rivista(e)</b></td>
							<td>Totale:</td>
							<td colspan="2"><b>${cart.totalAmount} &euro;</b></td>
						</tr>
					</table>
				</div>
				<div>
				<table class="normal">
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td></td>
							<td><input type="button" id="clearCart" value="Annulla"/></td>
							<td><a href="checkout">Checkout</a>
						</tr>
				</table>
				</div>
			</form>
		</c:if>
	</div>

	<jsp:directive.include file="footer.jsp" />

<script type="text/javascript">
	

$(document).ready(function() {
	$("#clearCart").click(function() {
		window.location = 'clear_cart';
	});

});
	</script>
</body>
</html>