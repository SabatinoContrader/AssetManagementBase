<%@ page import="com.virtualpairprogrammers.model.Asset" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Asset> allAssets = (List<Asset>) request.getAttribute("allAssets");%>
 </head>
 <body>
<h1>Benvenuto <%= request.getSession().getAttribute("utente")%></h1>
<form action="ProdottoServlet" method="post">
    <input type="text" name="colonna">
    <input type="text" name="campoRiga">
    <input type="submit" value="SearchCategory" name="richiesta">
</form>

<form action="ProdottoServlet" method="post">
 <table border="2">
 <tr>
   <td>
      Categoria:
   </td>
   <td>
   </td>
   </td>
   </tr>
     <tr>
        <th></th>
         <th>
             ID
         </th>

         <th>
             TIPO
         </th>
         <th>
             PREZZO
         </th>
         <th>
             DESCRIZIONE
         </th>
         <th>
          </th>
         <th>
          </th>

     </tr>
        <%for (Asset asset : allAssets) { %>
     <tr>
         <td>
             <input type="checkbox" name="products" value="<%= asset.getId()%>"/>
         </td>

         <td>
             <%= asset.getId()%>
         </td>

         <td>
             <%=  asset.getTipo()%>
         </td>

         <td>
             <%=  asset.getPrezzo()%>
         </td>

         <td>
             <%=  asset.getDescrizione()%>
         </td>

          <td>
             <a href="ProdottoServlet?richiesta=ModificaProdotto&id=<%=  asset.getId()%>">Modifica</a>
         </td>
         <td>
             <a href="ProdottoServlet?richiesta=EliminaProdotto&id=<%= asset.getId()%>">Elimina</a>
         </td>

     </tr>
     <% }%>
 </table>
<input type="submit" value="SellProducts" name="richiesta"> <a href="home.jsp">Home <h3><a href="insertProdotto.jsp">Inserisci Prodotto</a></h3>
</form>
 <h2></h2>
 <h2></h2>
 <form action="" method="post">
 <!-- <h3><a href="insertProdotto.jsp">1. - Inserisci un nuovo Prodotto</a></h3> -->
 <!-- <input type="text" value="Scelta" name="richiesta">
 <button type = "submit" value = "Vai" name = "pulsante">GO</button> -->
 <h3></h3>

 </form>
 </body>
</html>