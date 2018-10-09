<%@ page import="java.util.List"%>
<%@ page import="com.pCarpet.model.Car"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- Javascript -->
<script src="/css/googleApiManagerOwner.js"></script>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">
</head>
<body>


	<h1 class="element-margin-left">Gestione Parcheggi</h1>

	<button id="refresh" class="btn btn-lg btn-primary btn-block back-button element-margin-left">Aggiorna</button>
	
	<div class="col-md-6 mb-3">
		</br> </br>
		<div id="map" class="map-place"></div>
		</br>
		
		<form style="display: inline-block;" action="/Home/dispatchHome"
			method="post">
			<button class="btn btn-lg btn-primary btn-block back-button"
				type="submit">Indietro</button>
		</form>
	</div>


	<div class="container">
		<h1>Auto in sosta</h1>
		</br>
		<table class="table table-striped">
			<thead>


				<tr>
					<th>ID STOP</th>
					<!--  <th>TIPO DISABILE</th>  -->
					<th>TARGA</th>
					<th>START</th>
					<th>FINISH</th>
					<th>PAGATO</th>
				</tr>
			</thead>
			<tbody id="stopList"></tbody>
<%-- 				<c:forEach items="${managementCarPlaceDTO}" var="carplacedto"> --%>
<!-- 					<tr> -->
<%-- 						<td>${carplacedto.id_slot}</td> --%>
<%-- 						<td>${carplacedto.type}</td> --%>
<%-- 						<td>${carplacedto.license_plate}</td> --%>
<%-- 						<td>${carplacedto.start}</td> --%>
<%-- 						<td>${carplacedto.finish}</td> --%>
<!-- 						<td>""</td> -->
<!-- 						manca pagato -->
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
		</table>
		<p id="abusiveError"></p>

	</div>
	



	<script>
	function myMap() {
		var googleApiManagerOwner = new GoogleApiManagerOwner('map',41.9, 12.48,'/updateSlots');
			googleApiManagerOwner.selectStopList('stopList','abusiveError');
			googleApiManagerOwner.selectRefresh('refresh');
		};
	</script>

	<script
		src="https://maps.googleapis.com/maps/api/js?sensor=false&libraries=places&language=en&key=AIzaSyAsEE6wc-sX5HniWTVBPTSZgHOwN_cf5F0&callback=myMap"></script>


</body>
</html>