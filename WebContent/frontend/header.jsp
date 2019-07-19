

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="center">
	<div>
	    <a href="${pageContext.request.contextPath}/">
		   <img src="./images/logo.png" />
		</a>
	</div>
	<div>
		<form action="search" method="get">
			<input type="text" name="keyword" size="50" /> 
			<input type="submit" value="Cerca" /> 
			
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				<c:if test="${loggedCustomer == null }">
			<a href="login">Login</a> |
			 <a href="register">Registrati</a> 
			  </c:if>
			  
			  <c:if test="${loggedCustomer != null }">
			  <a href="view_profile">Benvenuto <b>${loggedCustomer.fullname}</b></a> |
			  <a href="view_orders">Abbonamenti</a> |
			  <a href="view_cart">Carrello</a> |
		      <a href="logout">Esci</a> 
			  </c:if>
		</form>
	</div>
	<div>&nbsp;</div>
	<div>
		<c:forEach var="category" items="${listCategory}" varStatus="status">
			<a href="view_category?id=${category.categoriaId}"> <font
				size="+1"><b><c:out value="${category.name}" /> </b></font>
			</a>
			<c:if test="${not status.last}">
    	&nbsp; | &nbsp;
    	</c:if>
		</c:forEach>
	</div>
</div>