package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.User;
import com.virtualpairprogrammers.service.LoginService;
import com.virtualpairprogrammers.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Servlet implementation class InsertUserView
 */
public class UserManagementServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private String message;

    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
    	/*
    	System.out.println("asd");
    	userService=new UserService();
		userService.insertUser(new User(0,"asd","asd","asd","asd","asd","asd","asd","asd"));
		*/
		
		this.userService = new UserService();
    	this.message = "";
    	HttpSession session = request.getSession();
    	String choice = (String) request.getParameter("richiesta");
    	
        if (choice != null) {
        	switch (choice) {
//            case "usersManagement":
//            	request.put("visualizzaUtenti", this.userService.getAllUsers());
//            	
//            	MainDispatcher.getInstance().callView("UserHome", request);
//            	break;
            case "insert":
                //MainDispatcher.getInstance().callView("InsertUser", request);
                getServletContext().getRequestDispatcher("/insertUser.jsp").forward(request, response);
                break;
//            case "update":
//            	MainDispatcher.getInstance().callView("UpdateUser", request);
//                break;
            case "delete":
            	getServletContext().getRequestDispatcher("/deletemodifyUser.jsp").forward(request, response);
                break;
//            case "insertUser":
//            	if (this.userService.insertUser((User)request.get("newUser"))) {
//            		this.message = "Inserimento utente avvenuto correttamente";
//            	}
//            	else {
//            		this.message = "Errore durante la procedura di inserimento utente";
//            	}
//            	request.put("message", this.message);
//            	request.put("visualizzaUtenti", this.userService.getAllUsers());
//        		MainDispatcher.getInstance().callView("UserHome", request);
//            	break;
//            case "deleteUser":
//            	if (this.userService.deleteUser((int)request.get("delUser"))) {
//            		this.message = "Cancellazione utente avvenuta correttamente";
//            	}
//            	else {
//            		this.message = "Errore durante la procedura di cancellazione utente";
//            	}
//            	request.put("message", this.message);
//            	request.put("visualizzaUtenti", this.userService.getAllUsers());
//        		MainDispatcher.getInstance().callView("UserHome", request);
//            	break;
//            case "updateUser":
//            	if (this.userService.updateUser(request)) {
//            		this.message = "Aggiornamento utente avvenuto correttamente";
//            	}
//            	else {
//            		this.message = "Errore durante la procedura di aggiornamento utente";
//            	}
//            	request.put("message", this.message);
//            	request.put("visualizzaUtenti", this.userService.getAllUsers());
//        		MainDispatcher.getInstance().callView("UserHome", request);
//            	break;
            }
        }
        else {
        	getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
        }
        
        
    }
    
	
	
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
