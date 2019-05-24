<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http- charset="ISO-8859-1">
	<title>Nuova Rivista</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/jquery-ui.min.css">
    <script type="text/javascript" src="../js/jquery-3.4.0.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
 	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>


</head>
<body>
	<jsp:directive.include file="header.jsp" />
    <div align="center">
        <h2 class="pageheading">
        	<c:if test="${rivista != null}">
        		Modifica Rivista
        	</c:if>
        	<c:if test="${rivista == null}">
        		Crea Nuova Rivista
        	</c:if>
        	
        </h2>
    </div>

    <div align="center">
    	<c:if test="${rivista != null}">
    		<form action="update_user" method="post" id="userForm">
    		<input type="hidden" name="userId" value="${rivista.userId}">
    	</c:if>
    	
    	<c:if test="${rivista == null}">
    		<form action="create_rivista" method="post" id="rivistaForm" enctype="multipart/form-data">
    	</c:if>
    	
			<table class="form">
			  	<tr>
			  		<td>Categoria:</td>
			  	<td>
			  	
			  	 <select name="category">
			  		 <c:forEach items="${listCategory}" var="category">
			  			 <option value="${category.categoriaId}">
			  	 			${category.name}
			  	 		</option>
			  	 	</c:forEach>
			  	 </select>
			  	 </td>
			    </tr>
      			<tr>
      				<td align="right">Titolo:</td>
      				<td align="left"><input type="text" id="title" name="title" size="20" value="${rivista.email}"/></td>
      			</tr>
      			<tr>
      				<td align="right">Data di publicazione:</td>
      				<td align="left"><input type="text" id="publishDate" name="publishDate" size="20" value="${rivista.publishDate}"/></td>
      			</tr>
      			<tr>
      				<td align="right">Immaggine:</td>
      				<td align="left">
      					<input type="file" id="RivistaImage" name="RivistaImage" size="20"/><br/>
      				<img id="thumbnail" alt="Image Preview" style="width:15%; margin-top:0px"/>
      				</td>
      			</tr>
      				<tr>
      				<td align="right">Prezzo:</td>
      				<td align="left"><input type="text" id="price" name="price" size="20" value="${rivista.price}"/></td>
      			</tr>
      			<tr>
      				<td align="right">Descrizione:</td>
      				<td align="left">
      				<textarea rows="5" cols="50"name="description" id="description"></textarea>
      				</td>
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

	$(document).ready(function () {
		$('#publishDate').datepicker();
		$('#RivistaImage').change(function(){
			showImageThumbnail(this);
		});
		$("#rivistaForm").validate({
			rules: {
				category: "required",
				title: "required",
				publishDate: "required",
				RivistaImage: "required",
				price: "required",
				description: "required",
			},
			
			messages: {		
				category: " Selezione la Categoria",
				title: " Inserisci il titolo",
				publishDate: " Inserisci la data di pubblicazione",
				RivistaImage: " Inserisci Immagine",
				price: " Inserisci Prezzo",
				description: " Inserisci Descrizione"
			}
		});
		$("#buttonCancel").click(function () {
			history.go(-1);
		});
	});
	function showImageThumbnail(fileInput){
		var file = fileInput.files[0];
		var reader= new FileReader();
		reader.onload=function(e){
			$('#thumbnail').attr('src',e.target.result);
		};
		reader.readAsDataURL(file);
	}
</script>


</html>













