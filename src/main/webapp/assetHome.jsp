<%@ page import="com.pCarpet.model.Asset" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Asset> allAssets = (List<Asset>) request.getAttribute("allAssets");%>
 </head>
 <body>
<h1>Benvenuto <%= request.getSession().getAttribute("utente")%></h1>
<form action="AssetServlet" method="post">
    <input type="submit" value="insert" name="scelta">
</form>

 <table border="2">

     <tr>
       
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
         

     </tr>
        <%for (Asset asset : allAssets) { %>
     <tr>
        
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
             <a href="/Asset/assetDirectory?scelta=update&id=<%=  asset.assetId()%>">Modifica</a>
         </td>
         <td>
             <a href="/Asset/assetDirectory?scelta=eliminaAsset&id=<%= asset.assetId()%>">Elimina</a>
         </td>

     </tr>
     <% }%>
 </table>
 </br>
 <form action="/Asset/assetDirectory" method="get"></form>
<input type="submit" value="indietro" name="scelta">
</form>
 <h2></h2>
 <h2></h2>
 <form action="" method="post">

 <h3></h3>

 </form>
 </body>
</html>