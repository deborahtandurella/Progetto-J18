<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Riviste Online</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div class="center">
		<div>
			<h2>Riviste</h2>
			<c:forEach items="${listNewRiviste}" var="rivista">
				<div class="rivista">
					<div>
						<a  href="view_rivista?id=${rivista.rivistaId}">
						 <img class="rivista-small"
							src="data:image/jpg;base64,${rivista.base64Image}"/>
						</a>
					</div>
					<div>
						<a href="view_rivista?id=${rivista.rivistaId}"> <b>${rivista.title }</b>
						</a>
					</div>
					
					<div>
						<b>&euro; ${rivista.price}</b>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
</html>

