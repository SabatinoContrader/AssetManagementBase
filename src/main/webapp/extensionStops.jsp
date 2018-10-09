<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pCarpet.model.Stop"%>

<%@ page import="com.pCarpet.dto.ManagementExtensionStopDTO"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h1>Prolunga la tua sosta</h1>
		</br>
		<table class="table table-striped">
			<thead>

				<tr>
					<th>INDIRIZZO</th>
					<th>AUTO</th>
					<th>INIZIO</th>
					<th>FINE</th>
					<th></th>
					<th>DA PAGARE</th>
					<th></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${stops}" var="stop">
					<tr>
						<form action="/ExtensionStop/extendStop" method="post">
							<td>${stop.address}</td>
							<td>${stop.name}</td>
							<td>${stop.start}</td>
							<td>${stop.finish}</td>
						

							<td><select class="select" name="minute">
									<option value="15">15 min</option>
									<option value="30">30 min</option>
									<option value="45">45 min</option>
									<option value="60">1 h</option>
									<option value="75">1 h 15 min</option>
									<option value="90">1 h 30 min</option>
									<option value="105">1 h 45 min</option>
									<option value="120">2 h</option>
							</select></td> 
							<td><p class="newprice">${(stop.price / 60) * 15} &euro;</p></td>
							<input type="text" name="id" value="${stop.id_stop}" hidden></input>
							<input type="text" name="address" value="${stop.address}" hidden></input>
							<input type="text" name="name" value="${stop.name}" hidden></input>
							<input type="text" name="start" value="${stop.start}" hidden></input>
							<input type="text" name="finish" value="${stop.finish}" hidden></input>
							<input type="text" class="price" name="price" value="${stop.price}" hidden></input>


							<td align="center"><button type="submit"
									class="table-button">Prolunga</button></td>

							<td>
						</form>
					</tr>
				</c:forEach>
		</table>

		<a class="btn btn-lg btn-primary btn-block back-button"
			href="/Home/dispatchHome">Indietro</a></br>
		</form>
		</p>
	</div>

<script>
	var select = document.getElementsByClassName("select");
	var newprice = document.getElementsByClassName("newprice");
	var price = document.getElementsByClassName("price");
	

  	for(var i=0; i<select.length; i++){
  	
  		select[i].addEventListener('change', 
			(function(i) {
				return function() {		
					var min = select[i].options[select[i].selectedIndex].value;
					var pay = (price[i].value / 60) * min;
					newprice[i].innerHTML = pay + "\u20AC";
				}
			})(i));

  	}
</script>


</body>
</html>