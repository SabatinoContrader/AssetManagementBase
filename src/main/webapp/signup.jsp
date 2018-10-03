<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <title>Registration </title>

</head>

  <body>
    
      
      <div class="col-md-4 mb-3">
      <form class="form-signup" action="SignupServlet" method="post">
      <h1>Registration</h1>
      </br>
      
	  <input type="text" name = "username" class="form-control form-control-lg" id="username" class="form-control" placeholder="Username" required autofocus></br>
      
	  <input type="password" name = "password" class="form-control form-control-lg" id="inputPassword" class="form-control" placeholder="Password" required></br>
     
	  <input type="text" name = "nome" class="form-control form-control-lg" id="nome" class="form-control" placeholder="Nome" required autofocus></br>
      
	  <input type="text" name = "cogname" class="form-control form-control-lg" id="cognome" class="form-control" placeholder="Cogname" required autofocus></br>
      
	  <input type="date" name = "teleofno" id="telefono" class="form-control form-control-lg" class="form-control" placeholder="Telefono" required autofocus></br>
      
	  <input type="text" name = "mail" class="form-control form-control-lg" id="mail" class="form-control" placeholder="Mail" required autofocus></br>
	  
	  <input type="text" name = "partitaiva" class="form-control form-control-lg" id="partitaiva" class="form-control" placeholder="Partitaiva" required autofocus></br>
	  
	  <input type="text" name = "ruolo" class="form-control form-control-lg" id="ruolo" class="form-control" placeholder="Ruolo" required autofocus></br>
	  
	  
	  <input type="text" name="richiesta" value="registed" hidden></p>
	  
	  
	  
      <div align="right" style="position:relative">
      <label for="handicapped" class="signup-label-position signup-label">Disabile</label>
      <input type="radio" id="handicappedChoice1"
     name="handicapped" value="true">
    <label for="handicappedChoice1" style="font-size: 20px;">Si</label>

    <input type="radio" id="handicappedChoice2"
     name="handicapped" value="false">
    <label for="handicappedChoice2" class="signup-label">No</label></br>
	  </div>
	  
       </br>
      <button class="btn btn-lg btn-primary btn-block submit-button" type="submit">Sign up</button></br>
      </div>
      </form>
  </body>
</html>