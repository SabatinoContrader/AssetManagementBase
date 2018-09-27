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
        System.out.println("3) Logout");
        /*
        System.out.println("5)  Inserisci asset");
        System.out.println("6)  Visualizza asset");
        System.out.println("7)  Aggiorna asset");
        System.out.println("8)  Elimina un asset");
        System.out.println("9)  Assegna asset ad utente");
        System.out.println("10) Visualizza asset assegnati");
        System.out.println("11) Esporta asset assegnati");
        */
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
    	this.request = new Request();
        if (choice < 1 || choice > 3) {
        	MainDispatcher.getInstance().callAction("Home", "doControl", null);
        }
        else if (choice == 3) {
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
    }
    	/*
        if (choice < 1 || choice > 12)//ritorna alla home
            MainDispatcher.getInstance().callAction("Home", "doControl", null);
        else if (choice == 12)//logout
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
        else if (choice > 4 && choice < 9) { //gestione asset
            Request request = new Request();
            request.put("choice", choice);
        	MainDispatcher.getInstance().callAction("Asset","doControl", request);
        	}
        else if(choice == 9)
        {
        	Request request = new Request ();
        	request.put("choice",choice);
            MainDispatcher.getInstance().callAction("Userasset", "doControl", request);
        }
        else if(choice == 10) {
        	Request request = new Request ();
        	request.put("choice",choice);
            MainDispatcher.getInstance().callAction("Userasset", "doControl", request);
        }
     */


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
