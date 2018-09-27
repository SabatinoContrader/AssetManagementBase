package main.view;

import main.MainDispatcher;
import main.controller.Request;
//import sun.applet.Main;

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
        System.out.println("1)  Inserisci Utente");
        System.out.println("2)  Visualizza tutti gli utenti");
        System.out.println("3)  Elimina un utente");
        System.out.println("4)  Aggiorna un utente");
        System.out.println("5)  Inserisci asset");
        System.out.println("6)  Visualizza asset");
        System.out.println("7)  Aggiorna asset");
        System.out.println("8)  Elimina un asset");
        System.out.println("9)  Assegna asset ad utente");
        System.out.println("10) Visualizza asset assegnati");
        System.out.println("11) Esporta asset assegnati");
        System.out.println("12) Logout");
        this.choice = Integer.parseInt(getInput());
    	
    }

    public void submit() {
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
