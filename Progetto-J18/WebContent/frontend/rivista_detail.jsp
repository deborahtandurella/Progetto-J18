<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Typer" content="text/html; charset=ISO-8859-1">
<title>${rivista.title}- Riviste Online</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div class="center">
		<table class="rivista">
			<tr>
				<td colspan="3" align="left" >
					<p id="rivista-title">${rivista.title}</p>
				</td>
			</tr>
			<tr>
				<td rowspan="2">
				<img class="rivista-large" src="data:image/jpg;base64,${rivista.base64Image}"
					/></td>
				<td valign ="top" align="left">Rating ***** </td>
				<td valign="top" rowspan="2" width="20%"><h2>$ ${rivista.price}</h2> <br/><br/>
					<button type="submit">Add to Cart</button>
				</td>
			</tr>
			<tr>
				<td id="description">
				${rivista.description}
				</td>
			</tr>
			<tr><td> &nbsp; </td></tr>
			<tr>
				<td><h2> Customer Reviews</h2></td>
				<td colspan="2" align="center"> 
				<button> Write a Customer Review</button>
				</td>
			</tr>
			
			
		</table>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
</html>

