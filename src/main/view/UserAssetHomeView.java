package main.view;

import main.MainDispatcher;
import main.controller.Request;
//import sun.applet.Main;

import java.util.Scanner;

public class UserAssetHomeView implements View {

    private int choice;
    private Request request;
    
    public void showResults(Request request) {
    	this.request = request;
    }

    public void showOptions() {
    	System.out.println("Asset Management Base");
    	System.out.println();
    	System.out.println("Gestione User Asset");
    	System.out.println("");
        System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Associazione Asset Utente");
        System.out.println("2) Visualizzazione Asset Assegnati");
        System.out.println("3) Esportazione Asset Assegnati");
        System.out.println("4) Disassociazione Asset Utente");
        System.out.println("5) Indietro");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        if (choice < 1 || choice > 5) {
        	this.request = new Request();
        	this.request.put("choice", "usersAssetsManagement");
            MainDispatcher.getInstance().callAction("UserAsset", "doControl", this.request);
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
        		request.put("choice", "export");
            	System.out.println("Inserire percorso dove si vuole esportare");
            	String perc= getInput();
            	System.out.println("Inserire nome file di output");
            	String nome= getInput();
            	request.put("perc", perc);
            	request.put("nome", nome);
        	}
        	else if (this.choice == 4) {
        		request.put("choice",  "delete");
        	}
        	MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);   
        	if(this.choice==3 && (boolean)request.get("ok")==true)
        		System.out.println("Export effettuato con successo");
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
