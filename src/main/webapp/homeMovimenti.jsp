<%@ page import="com.pCarpet.dto.MovimentoDTO" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
  <!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
     <% List<MovimentoDTO> allMovimenti = (List<MovimentoDTO>) request.getAttribute("visualizzaMovimenti");%>
 </head>
 <body>


 <table class="border rcorners">
     <tr><th><h4>Lista Movimenti</h4></th><td></td><td></td><td class="imgB"></td></tr>
     <tr>
     
         <th>
             ID Badge Reader
         </th>
         <th>
             ID Badge
         </th>
         <th>
             Data inizio
         </th>
         <th>
             Data fine
         </th>
		 </tr>
        <%for (MovimentoDTO movimento : allMovimenti) { %>
     <tr>
	<td>
             <%= movimento.getBadgereader().getIdBadgeReader()%>
         </td>
         <td>
             <%=  movimento.getBadge().getIdBadge()%>
         </td>

         <td>
              <input type="datetime-local" value="<%=  movimento.getOrainizio()%>" disabled class="rcorners">
         </td>

         <td>
              <input type="datetime-local" value="<%=  movimento.getOrafine()%>" disabled class="rcorners">
         </td>
     </tr>
     <% }%>
 </table>
 </br>
 <table>
 <form action="/Movimento/homeMovimento" method=post>
<tr><td>
<button type="submit" value="indietroHome" class="btn lg btn-primary" name="richiesta">Indietro</button>
</td>
<td><button type="submit" value="export" class="btn lg btn-primary" name="richiesta">Esporta</button>
</td></tr>

</table>

</br>
</br>

<table class="border rcorners">
	<tr></tr>
	<tr>
	<th>
    	ID BadgeReader
    </th>
    
    <th>
    	ID Badge
    </th>
		<td>
			<input type="text" id="badgereader" name="badgereader" class="rcorners">
		</td>
		<td>
			<input type="text" id="badge" name="badge" class="rcorners">
		</td>
	</tr>
</table>

</br>

<table>
	<tr>
	<button type="submit" value="insServer" class="btn lg btn-primary" name="richiesta">Effettua inserimento</button>
	</tr>
</table>

</form>
 <!-- <h3><a href="insertProdotto.jsp">1. - Inserisci nuovo Asset</a></h3> -->
 <!-- <input type="text" value="Scelta" name="richiesta">
 <button type = "submit" value = "Vai" name = "pulsante">GO</button> -->
 <h3></h3>