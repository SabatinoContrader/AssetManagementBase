package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.model.User;
import main.model.Userasset;
import main.dao.UserassetDAO;
import main.service.AssetService;
import main.service.UserService;
import main.service.UserassetService;

import java.util.List;import java.util.Scanner;

public class UserassetView implements View {

    private UserassetService UserassetService;
    
    private String username;
    private String mode;
    private UserService userService;
    private AssetService assetService;

	public UserassetView () {
	    this.UserassetService = new UserassetService();
	    this.userService = new UserService();
	    this.assetService = new AssetService();
	    this.mode = "viewAss";
	}

    @Override
    public void showResults(Request request) {
       this.mode  = (String) request.get("mode");
    }

    @Override
    public void showOptions() {
    
		switch (mode) {
            case "viewUserAss":
                List<Userasset> userassets = UserassetService.getAllUserassets();
                System.out.println("----- Asset assegnati -----");
                System.out.println();
                userassets.forEach(userasset -> System.out.println(userasset));
                
                List<User> users = userService.getAllClientiAss();
                System.out.println("i clienti con un asset assegnato sono:");
                System.out.println();
                users.forEach(user -> System.out.println(user));
                
                
                break;

            case "insUserAss":
            	List<Asset> assets = assetService.getAllAssetsN();
            	if(assets.isEmpty()) {
                System.out.println("nessun asset disponibile");
                break;}
            	else 
            	{
                System.out.println("----- Asset non assegnati -----");
                System.out.println();
                assets.forEach(asset -> System.out.println(asset));
                
                List<User> users2 = userService.getAllClienti();
                System.out.println("----- Clienti -----");
                System.out.println();
                users2.forEach(user -> System.out.println(user));
                
            	
            	System.out.println("\ninserisci dati");
            	System.out.println("inserisci id utente");
            	int iduser=Integer.parseInt(getInput());
            	System.out.println("inserisci id asset");
            	int idasset=Integer.parseInt(getInput());
            	System.out.println("inserisci ora inizio");
            	String orainizio=getInput();
            	System.out.println("inserisci ora fine");
            	String orafine= getInput();
            	UserassetService.insertUserasset(new Userasset(iduser,idasset,orainizio,orafine));
            	break;
            	
            	
                }
        }
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
  }

    @Override
    public void submit() {
        MainDispatcher.getInstance().callAction("Home", "doControl", null);
    }



}
