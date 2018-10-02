<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<%
        String feedback = (String)request.getAttribute("feedback");
    %>


<title>PCARPET</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">
</head>

<body class="text-center">
	<form class="form-signin" action="LoginServlet" method="post">
		<h1 class="h3 mb-3 font-weight-normal">PCARPET</h1>
		<h2 class="h3 mb-3 font-weight-normal">Login</h2>
		<label for="inputUser" class="sr-only">Username</label> <input
			type="text" name="username" id="inputUser" class="form-control"
			placeholder="Username" required autofocus> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" name="password" id="inputPassword"
			class="form-control" placeholder="Password" required> <input
			type="text" name="richiesta" value="login" hidden>
		</p>
		<p>
			<% if(feedback != null) 
    	  			out.println(feedback); %>
		</p>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
		</br> <a href="SignupServlet?richiesta=register">Prima volta su
			PCARPET? Iscriviti </a>
	</form>
</body>
</html>