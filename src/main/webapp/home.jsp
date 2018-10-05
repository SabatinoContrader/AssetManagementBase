<html>
<head>
<title>Menu Principale AMEBA</title>
</head>
<body>
     <h1>Benvenuto <%= request.getSession().getAttribute("utente")%></h1>
     <h2>------- MENU PRINCIPALE AMEBA -------</h2>
     <h2>    <h2>

     <h3>1. My Assets</h3>
     <form action="MenuServlet" method="post">
     <input type="submit" id="go" value="AssetMenu" name="richiesta">
     </form>
     
     <h3>2. Customers</h3>
     <form action="MenuServlet" method="post">
     <input type="submit" value="CustomersMenu" name="richiesta">
     </form>
     
     <h3>3. Bookings</h3>
     <form action="MenuServlet" method="post">
     <input type="submit" value="LogsMenu" name="richiesta">
     </form>
     
     <h3>4. Logs</h3>
     <form action="MenuServlet" method="post">
     <input type="submit" value="LogsMenu" name="richiesta">
     </form>
     
     <h3>4.logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>

</body>
</html>