 <%@ page import="com.virtualpairprogrammers.model.Asset" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     
</head>
<body>
<form action="AssetServlet" method="post">
    <table>
    <tr><td>
    <h2>Tipo</h2></td><td><input type="text" name="tipo"></td></tr><tr><td>
    <h2>Prezzo</h2></td><td><input type="text" name="prezzo"></td></tr><tr><td>
    <h2>Descrizione</h2></td><td><input type="text" name="descrizione"> </td></tr><tr><td>
   	
    <input type="submit" value="insertAsset" name="richiesta"></td><td>
         <form action="MenuServlet" method="post">
     <button type="submit" value="IndietroHome" name="richiesta">Indietro</button>
     </form></td></tr>
</table>
</form>
</body>
</html>