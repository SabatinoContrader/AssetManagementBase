<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.virtualpairprogrammers.model.Badge"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% List<Badge> allBadges = (List<Badge>) request.getAttribute("allBadges");%>
</head>
<body>

<h2><center>------- UPDATE BADGE -------</center></h2>
<form action="BadgeServlet?richiesta=home" method="post">
	<input type="submit" value="HOME" name="richiesta">
</form>

	
<form action="BadgeServlet?richiesta=updateBadge" method="post">
 <table>	
	
	<tr>
        
         <th>
             ID BADGE
         </th>

         <th>
             TIPOLOGIA
         </th>
         <th>
             DESCRIZIONE
         </th>
         
         <th>
          </th>
         <th>
          </th>

     </tr>
	
     <%for (Badge badge : allBadges) { %>
     <tr>
        <td>
        	<%= badge.getIdBadge()%>
        </td>

		<td>
        	<%=  badge.getDescrizione()%>
        </td>

        <td>
        	<%=  badge.getTipologia()%>
        </td>
     </tr>
     <% }%>
     
</table>


<table>

	<tr>
		<td>
			<h4>Inserisci il campo che vuoi modificare: <input type = "text" id = "user" name ="campo" placeholder = "inserisci campo"></h4>
		</td>
		
		<td>
			<h4>Inserisci l'id del badge da modificare: <input type = "text" id = "user" name ="id" placeholder = "inserisci id"></h4>
		</td>
		
		<td>
			<h4>Inserisci il valore del nuovo campo: <input type = "text" id = "nuovoCampo" name ="nuovoCampo" placeholder = "inserisci nuovo campo"></h4>
		</td>
	</tr>

</table>

<input type="submit" value="Effettua modifica" name="richiesta">

</form>
	
</body>
</html>