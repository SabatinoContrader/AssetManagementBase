<%@ page import="java.util.List"%>
<%@ page import="com.virtualpairprogrammers.domain.Asset"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="pcarpet.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h1>Lista asset</h1>
     </br>     
  <table class="table table-striped table-medium">
    <thead>
	
	<%
		List<Asset> assets = (List<Asset>) request.getAttribute("assets");
	%>
	
      <tr>
        <th>Asset</th>
			<th>Id</th>
			<th>Tipo</th>
			<th>Prezzo</th>
			<th>Descrizione</th>
      </tr>
    </thead>
    <tbody>
	<%
			for (Asset asset : assets) {
		%>
		<tr>
			<td><%=asset.getId()%></td>
			<td><%=asset.getTipo()%></td>
			<td><%=asset.getPrezzo()%></td>
			<td><%=asset.getDescrizione()%></td>
			<td><a
				href="AssetServlet?richiesta=removeAsset&id=<%=asset.getId()%>">Elimina</a></td>
		</tr>
		<%
			}
		%>
    </form>
    </tr>
    
	</table>
	
	

	
	<a class="btn btn-lg btn-primary btn-block submit-button" href="AssetServlet?richiesta=addCar">Aggiungi asset</a></br>
	<a class="btn btn-lg btn-primary btn-block back-button" href="HomeServlet">Indietro</a></br>
	
	</p>
</div>

</body>
</html>