package main.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import main.MainDispatcher;
import main.model.Asset;
import main.model.User;
import main.service.UserService;

public class UserController implements Controller {

	private UserService userService;
	
    @Override
    public void doControl(Request request)  {
    	this.userService = new UserService();
    	String choice = request.get("choice").toString();
        if (choice != null) {
        	switch (choice) {
            case "usersManagement":
            	MainDispatcher.getInstance().callView("UserHome", request);
            	break;
            case "insert":
                request.put("mode", "insert");
                MainDispatcher.getInstance().callView("User", request);
                break;
            case "getList":
                request.put("mode", "getList");
                request.put("visualizzaUtenti", this.userService.getAllUsers());
                MainDispatcher.getInstance().callView("User", request);
                break;
            case "update":
                request.put("mode", "update");
            	request.put("visualizzaUtenti", userService.getAllUsers());
            	MainDispatcher.getInstance().callView("User", request);
                break;
            case "delete":
            	request.put("visualizzaUtenti", userService.getAllUsers());
                request.put("mode", "delete");
                MainDispatcher.getInstance().callView("User", request);
                break;
            case "insertUser":
            	this.userService.insertUser((User)request.get("newUser"));
            	MainDispatcher.getInstance().callView("UserHome", request);
                break;
            case "deleteUser":
            	/*
            	List<User> listUsers=this.userService.getAllUsersN();
            	
            	for(User u:listUsers) {
            		if(request.get("delUser").toString().equals(u.getUsername())) {
            			
            		}
            	}
            	*/
            	
            	this.userService.deleteUser(request.get("delUser").toString());
            	MainDispatcher.getInstance().callView("UserHome", request);
            	break;
            	
            	
            case "updateUser":
            	this.userService.updateUser(request);
            	MainDispatcher.getInstance().callView("UserHome", request);
                break;
            case "getListUsers":
            	MainDispatcher.getInstance().callView("UserHome", request);
                break;
        	}
        }
        else {
        	MainDispatcher.getInstance().callView("UserHome", null);
        }
    }
}
