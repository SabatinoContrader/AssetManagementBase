package main.view;

import main.MainDispatcher;
import main.controller.Request;
//import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;
    private Request request;
    private String username;
    
    public void showResults(Request request) {
    	this.request = request;
    	if(request != null) {
    		this.username=request.get("nomeUtente").toString();
    	}
    }


    public void showOptions() {
    	if(this.request != null) {
    		if(this.username != null) {
    			System.out.println("Benvenuto/a " + username);
    		}
    	}	
        System.out.println("");
        System.out.println("");
        System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Gestione Utenti");
        System.out.println("2) Gestione Asset");
        System.out.println("3) Gestione Utenti Asset");
        System.out.println("4) Logout");
        
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
    	this.request = new Request();
        if (choice < 1 || choice > 4) {
        	MainDispatcher.getInstance().callAction("Home", "doControl", null);
        }
        else if (choice == 4) {
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
        }
        else if (choice == 1) {
        	this.request.put("choice", "usersManagement");
            MainDispatcher.getInstance().callAction("User", "doControl", this.request);
        }
        else if (choice == 2) {
        	this.request.put("choice", "assetsManagement");
        	MainDispatcher.getInstance().callAction("Asset", "doControl", this.request);
        }
        else if (choice == 3) {
        	this.request.put("choice", "usersAssetsManagement");
        	MainDispatcher.getInstance().callAction("UserAsset", "doControl", this.request);
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
