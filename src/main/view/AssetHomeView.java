package main.view;

import main.MainDispatcher;
import main.controller.Request;
//import sun.applet.Main;

import java.util.Scanner;

public class AssetHomeView implements View {

    private int choice;
    private Request request;
    
    public void showResults(Request request) {
    	this.request = request;
    }

    public void showOptions() {
    	System.out.println("Asset Management Base");
        System.out.println("");
    	System.out.println("Gestione Asset");
        System.out.println("");
        System.out.println("");
        System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Inserimento Asset");
        System.out.println("2) Visualizza Asset");
        System.out.println("3) Modifica Asset");
        System.out.println("4) Cancellazione Asset");
        System.out.println("5) Indietro");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        if (choice < 1 || choice > 5) {
        	String username = this.request.get("username").toString();
        	this.request = new Request();
        	this.request.put("username", username);
        	this.request.put("choice", "assetsManagement");
            MainDispatcher.getInstance().callAction("Asset", "doControl", this.request);
        }
        else if (choice == 5) {
            MainDispatcher.getInstance().callAction("Home", "doControl", null);
        }
        else {
        	Request request = new Request();
        	if (this.choice == 1) {
        		request.put("choice", "insert");
        	}
        	else if (this.choice == 2) {
        		request.put("choice", "getList");
        	}
        	else if (this.choice == 3) {
        		request.put("choice", "update");
        	}
        	else if (this.choice == 4) {
        		request.put("choice", "delete");
        	}
        	MainDispatcher.getInstance().callAction("Asset", "doControl", request);        		
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
