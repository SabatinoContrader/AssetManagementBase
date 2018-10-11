<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.pCarpet.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">
</head>
<body>
 <h2>Inserisci i dati dell'utente</h2>
 
 </br>
 
     <form action="/HomeUser/showUsers?choice=insert" method="post">
     
     	
     
     <table>
     
     	<h4>Username: <input type = "text" id = "user" name ="username" placeholder = "inserisci username"></h4>
     	
     	<h4>Password: <input type = "password" id = "user" name ="password" placeholder = "inserisci la password"></h4>
     	
     	<h4>Nome: <input type = "text" id = "user" name ="nome" placeholder = "inserisci nome"></h4>
     	
     	<h4>Cognome: <input type = "text" id = "user" name ="cognome" placeholder = "inserisci cognome"></h4>
     	
     	<h4>Telefono: <input type = "text" id = "user" name ="telefono" placeholder = "inserisci telefono"></h4>
     	
     	<h4>Mail: <input type = "text" id = "user" name ="mail" placeholder = "inserisci mail"></h4>
     	
     	<h4>Partita iva: <input type = "text" id = "user" name ="partitaiva" placeholder = "inserisci partita iva"></h4>
     	
     	<h4>Ruolo: <input type = "text" id = "user" name ="ruolo" placeholder = "inserisci ruolo"></h4>


		<%-- ${User u= new User(0,username,password,nome,congome,telefono,mail,partitaiva,ruolo)}
         <input type="hidden" name="User" value="${u}"/> --%>
		
     	<%-- <a class="btn btn-lg btn-primary btn-block"
			href="/HomeUser/showUsers?choice=insertUser&User=${u}">Inserisci</a> --%>
			
		<button class="btn btn-lg btn-primary btn-block" type="submit">Inserisci</button>
		
     </table>
     </form>
</body>
</html>