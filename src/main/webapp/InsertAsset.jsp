<html>
<head>
<link rel="stylesheet" type="text/css" href="pcarpet.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
	<div class="col-md-4 mb-3">
		<h1>Aggiungi asset</h1>

		<form action="AssetServlet" method="post">
			<p>
				Tipo:<input type="text" name="Tipo"
					class="form-control form-control-lg" />
			</p>
			<p>
				Prezzo:<input type="text" name="prezzo"
					class="form-control form-control-lg" />
			</p>
			<p>
				Descrizione: <select name="descrizione" class="form-control form-control-lg">

				</select>
			</p>


			<button name="richiesta" value="addedCar"
				class="btn btn-lg btn-primary btn-block submit-button" />
			Aggiungi
			</button>
		</form>

		</br> </br>

		<form action="AssetServlet" method="post">

			<input type="submit" name="richiesta" value="Indietro"
				class="btn btn-lg btn-primary btn-block back-button" />

		</form>
		</form>
	</div>
</body>
</html>/html>