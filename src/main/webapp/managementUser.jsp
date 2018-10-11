<%@ page import="java.util.List"%>
<%@ page import="com.pCarpet.model.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- Javascript -->
<script src="/css/googleApiManagerDriver.js"></script>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">
</head>
<body>


<form class="form-signin" action="/HomeUser/showUsers" method="post">

	<h1 class="element-margin-left">Ecco tutti gli utenti</h1>

		
		
		

		<table border="2" class="table-medium">	
	
	<tr>
        
         <th>
             ID UTENTE
         </th>

         <th>
             USERNAME
         </th>
         
         <th>
             PASSWORD
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
	
        <c:forEach items="${users}" var="user">
     	
         <td>
             
             	<c:out value="${user.iduser}"></c:out>
             
         </td>
		
		<td>
            <c:out value="${user.username}"></c:out>
         </td>
         
         <td>
            <c:out value="${user.password}"></c:out>
         </td>

         <td>
             <c:out value="${user.nome}"></c:out>
         </td>

         <td>
             <c:out value="${user.cognome}"></c:out>
         </td>

         <td>
             <c:out value="${user.telefono}"></c:out>
         </td>
         <td>
             <c:out value="${user.mail}"></c:out>
         </td>
         <td>
            <c:out value="${user.partitaiva}"></c:out>
         </td>
         <td>
             <c:out value="${user.ruolo}"></c:out>
             
         </td>
         
         <td>
          
          <a class="btn btn-lg btn-primary btn-block"
			href="/HomeUser/showUsers?choice=update&id=${user.iduser}">Modifica</a>
         </td>
         <td>
             <a class="btn btn-lg btn-primary btn-block"
			href="/HomeUser/showUsers?choice=delete&id=${user.iduser}">Elimina</a>
         </td>
		
		
     </tr>
     </c:forEach>	
     
     
</table>

 <a class="btn btn-lg btn-primary btn-block" href="/HomeUser/showUsers?choice=insert">
 	Inserisci
 </a>



</body>
</html>