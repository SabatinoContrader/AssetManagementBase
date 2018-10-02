package main.view;

import main.MainDispatcher;
import main.controller.Request;
//import sun.applet.Main;
import main.model.User;

import java.util.List;
import java.util.Scanner;

public class UserHomeView implements View {

    private int choice;
    private Request request;
    private List<User> listUser;
    
    public void showResults(Request request) {
    	this.request = request;
    	if (this.request.get("message") != null) {
    		System.out.println(this.request.get("message"));
    	}	
        this.listUser = (List<User>) this.request.get("visualizzaUtenti");
    	System.out.println();
    	System.out.println();
        System.out.println("Asset Management Base");
    	System.out.println();
    	System.out.println("Gestione User");
    	System.out.println("");
        System.out.println("----- LISTA UTENTI -----");
        System.out.println();
        this.listUser.forEach(user -> System.out.println(user));
        System.out.println();
    }

    public void showOptions() {
    	System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Inserimento Utente");
        System.out.println("2) Modifica Utente");
        System.out.println("3) Cancellazione Utente");
        System.out.println("4) Indietro");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        if (choice < 1 || choice > 4) {
        	this.request = new Request();
        	this.request.put("choice", "usersManagement");
            MainDispatcher.getInstance().callAction("User", "doControl", this.request);
        }
        else if (choice == 4) {
            MainDispatcher.getInstance().callAction("Home", "doControl", null);
        }
        else {
        	Request request = new Request();
        	if (this.choice == 1) {
        		request.put("choice", "insert");
        	}
        	else if (this.choice == 2) {
        		request.put("choice", "update");
        	}
        	else if (this.choice == 3) {
        		request.put("choice", "delete");
        	}
        	MainDispatcher.getInstance().callAction("User", "doControl", request);        		
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
