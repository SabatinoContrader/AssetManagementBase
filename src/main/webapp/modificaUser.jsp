<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.virtualpairprogrammers.model.User"%>
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
<% List<User> allUsers = (List<User>) request.getAttribute("allUsers");%>
</head>
<body>


<h2><center>------- UPDATE USER -------</center></h2>
<form action="CustomersServlet?richiesta=home" method="post">
	<input type="submit" value="HOME" name="richiesta">
</form>


<form action="CustomersServlet?richiesta=updateUser" method="post">
 <table>	
	<tr>
        
         <th>
             ID UTENTE
         </th>

         <th>
             USERNAME
         </th>
         <th>
             NOME
         </th>
         <th>
             COGNOME
         </th>
         <th>
             TELEFONO
         </th>
         <th>
            EMAIL
         </th>
         <th>
             PARTITA IVA
         </th>
         <th>
            RUOLO
          </th>
         <th>
          </th>
         <th>
          </th>

     </tr>
        <%for (User user : allUsers) { %>
     <tr>
         <td>
             <input type="checkbox" name="users" value="<%= user.getIdutente()%>"/>
         </td>

         <td>
             
             	<%= user.getIdutente()%>
             
         </td>

		<td>
             <%=  user.getUsername()%>
         </td>

         <td>
             <%=  user.getNome()%>
         </td>

         <td>
             <%=  user.getCognome()%>
         </td>

         <td>
             <%=  user.getTelefono()%>
         </td>
         <td>
             <%=  user.getMail()%>
         </td>.
         <td>
             <%=  user.getPartitaiva()%>
         </td>
         <td>
             <%=  user.getRuolo()%>
         </td>
         
     </tr>
     <% }%>
     
</table>


<table>

	<tr>
		<td>
			<h4>Inserisci il campo che vuoi modificare: <input type = "text" id = "user" name ="cam..............................................................................................................................................................................................................................................................................................................................................33333333333333333333333333333333333333333333333333333333333333333333333333333po" placeholder = "inserisci campo"></h4>
		</td>
		
		<td>
			<h4>Inserisci l'id dell'utente da modificare: <input type = "text" id = "user" name ="id" placeholder = "inserisci id"></h4>
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