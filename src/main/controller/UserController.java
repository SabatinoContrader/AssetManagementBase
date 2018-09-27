package main.controller;

import main.MainDispatcher;
import main.model.Asset;
import main.model.User;
import main.service.UserService;

public class UserController implements Controller {

	private UserService userService;

    @Override
    public void doControl(Request request) {
    	userService = new UserService();
    	
        int choice = (int) request.get("choice");
        switch (choice) {
            case 1:
               request.put("mode", "insert");
               MainDispatcher.getInstance().callView("User", request);
               break;
            case 2:
                request.put("mode", "all");
                request.put("visualizzaUtenti", userService.getAllUsers());
                MainDispatcher.getInstance().callView("User", request);
                break;
            case 3:
            	request.put("mode", "delete");
            	request.put("visualizzaUtenti", userService.getAllUsers());
            	MainDispatcher.getInstance().callView("User", request);
            	break;
            case 4:
            	request.put("mode", "update");
            	request.put("visualizzaUtenti", userService.getAllUsers());
            	MainDispatcher.getInstance().callView("User", request);
            	break;
            case 13:
            	userService.insertUser((User)request.get("user"));
            	break;
            case 14:
            	userService.deleteUser((String)request.get("myUsername"));
            	break;
            case 15:
            	userService.updateUser(request);
            	break;
        }
        //MainDispatcher.getInstance().callView("User", request);
    }
}
