package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.domain.User;
import com.virtualpairprogrammers.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignupServlet extends HttpServlet {

    private UserService userService;

    public SignupServlet() {
        userService = new UserService();
    }
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);

		String result = request.getParameter("richiesta");

		if (result.equals("register"))
			getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
		else if (result.equals("registed")){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String telefono = request.getParameter("telefono");
			String mail = request.getParameter("mail");
			String partitaiva = request.getParameter("partitaiva");
			String ruolo = request.getParameter("ruolo");
			//String type = "driver";
			
			
			User newUser = new User(0, username, password,nome,cognome,telefono,mail,partitaiva,ruolo);
            if (userService.insertUser(newUser)) {
            	session.removeAttribute("feedback");
            	request.setAttribute("feedback", "Registrazione effettuata con successo");
            	getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			
		}else {
			request.setAttribute("feedback", "Registrazione non effettuata");
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}
	}
}
