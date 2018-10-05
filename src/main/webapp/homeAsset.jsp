<html>
<head>
<title>Menu Principale AMEBA</title>
</head>
<body>
     <h1>Benvenuto <%= request.getSession().getAttribute("utente")%></h1>
     <h2>------- MENU PRINCIPALE AMEBA -------</h2>
     <h2>    <h2>

     <h3>1. Assets</h3>
     <form action="AssetServlet" method="post">
     <input type="submit" value="assetsManagement" name="richiesta">
     </form>
     
     <h3>2. Badge Readers</h3>
     <form action="ProdottoServlet" method="post">
     <input type="submit" value="ViewListProduct" name="richiesta">
     </form>
     
     <h3>3. Indietro</h3>
     <form action="ProdottoServlet" method="post">
     <input type="submit" value="ViewListProduct" name="richiesta">
     </form>
     
       <h3>4.logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>

</body>
</html>