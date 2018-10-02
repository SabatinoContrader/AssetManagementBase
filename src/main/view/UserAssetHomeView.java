package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.User;
//import sun.applet.Main;
import main.model.UserAsset;

import java.util.List;
import java.util.Scanner;

public class UserAssetHomeView implements View {

    private int choice;
    private Request request;
    private List<UserAsset> listUserAsset;
    private List<User> users;
    
    public void showResults(Request request) {
    	this.request = request;
    	if (this.request.get("message") != null) {
    		System.out.println(this.request.get("message"));
    	}	
        this.listUserAsset = (List<UserAsset>) this.request.get("visualizzaUtentiAssets");
        this.users = (List<User>) this.request.get("visualizzaClienti");

        System.out.println();
    	System.out.println();
        System.out.println("Asset Management Base");
    	System.out.println();
    	System.out.println("Gestione User Asset");
    	System.out.println("");
    	System.out.println("----- Asset assegnati -----");
        System.out.println();
        this.listUserAsset.forEach(userasset -> System.out.println(userasset));
        System.out.println();
        System.out.println("I clienti con un asset prenotato sono:");
        System.out.println();
        this.users.forEach(user -> System.out.println(user.stampa()));
    }

    public void showOptions() {
    	System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Associazione Asset Utente");
        System.out.println("2) Esportazione Asset Assegnati");
        System.out.println("3) Disassociazione Asset Utente");
        System.out.println("4) Indietro");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        if (choice < 1 || choice > 4) {
        	this.request = new Request();
        	this.request.put("choice", "usersAssetsManagement");
            MainDispatcher.getInstance().callAction("UserAsset", "doControl", this.request);
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
        		request.put("choice", "export");
            	System.out.println("Inserire percorso dove si vuole esportare");
            	String path= getInput();
            	System.out.println("Inserire nome file di output");
            	String nome= getInput();
            	request.put("path", path);
            	request.put("nome", nome);
        	}
        	else if (this.choice == 3) {
        		request.put("choice",  "delete");
        	}
        	MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);   
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
