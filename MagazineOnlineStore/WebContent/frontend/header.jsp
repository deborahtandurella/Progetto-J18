<%--
  Created by IntelliJ IDEA.
  User: alael
  Date: 25/04/2019
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="center">
    <div>
        <img src="./images/logo.png" />
    </div>
    <div>
        <input type="text" name="keyword" size="50" />
        <input type="button" value="Cerca" />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <!-- Per creare spazio-->
        <a href="login">Sign In</a> |
        <a href="login">Register</a> |
        <a href="login">Carta</a>
    </div>
    <div>&nbsp;</div>
    <div>
    	<c:forEach var="category" items="${listCategory}" varStatus = "status">
    	<a href="view_category?id=${category.categoriaId}">
    		<font size="+1"><b><c:out value ="${category.name}" /> </b></font>
    	</a>
    	<c:if test="${not status.last}">
    	&nbsp; | &nbsp;
    	</c:if>
    	</c:forEach>
    </div>
</div>