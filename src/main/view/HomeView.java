package main.view;

import main.MainDispatcher;
import main.controller.Request;
import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;
    private String req;
    
    public void showResults(Request request) {
    	if(request != null) {
    		req=request.get("nomeUtente").toString();
    	}
    }


    public void showOptions() {
    	if(req != null) {
        System.out.println("Benvenuto/a " + req);
    	}
        System.out.println("");
        System.out.println("");
        System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Inserisci Utente");
        System.out.println("2) Visualizza tutti gli utenti");
        System.out.println("3) Elimina un utente");
        System.out.println("4) Logout");
        this.choice = Integer.parseInt(getInput());
    	
    }

    public void submit() {
        if (choice < 1 || choice > 4)//ritorna alla home
            MainDispatcher.getInstance().callAction("Home", "doControl", null);
        else if (choice == 4)//logout
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
        else {//gestione user
            Request request = new Request();
            request.put("choice", choice);
            MainDispatcher.getInstance().callAction("User", "doControl", request);
        }
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
