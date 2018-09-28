package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.model.User;
import main.model.UserAsset;
import main.dao.UserAssetDAO;
import main.service.AssetService;
import main.service.UserService;
import main.service.UserAssetService;

import java.util.List;import java.util.Scanner;

public class UserAssetView implements View {

    private UserAssetService userAssetService;
    private String username;
    private String mode;
    private UserService userService;
    private AssetService assetService;
    private List<UserAsset> listUserAsset;
    private Request request;
    private int iduser;
    private int idasset;

	public UserAssetView () {
	    this.userAssetService = new UserAssetService();
	    this.userService = new UserService();
	    this.assetService = new AssetService();
	    this.request = new Request();
	    this.mode = "all";
	}

    @Override
    public void showResults(Request request) {
        this.mode  = request.get("mode").toString();
        this.listUserAsset = (List<UserAsset>) request.get("visualizzaUtentiAssets");
    }

    @Override
    public void showOptions() {
		switch (mode) {
        case "getList":
        	System.out.println("----- Asset assegnati -----");
            System.out.println();
            this.listUserAsset.forEach(userasset -> System.out.println(userasset));
            List<User> users = userService.getAllClientiAss();
            System.out.println("\n\ni clienti con un asset assegnato sono:");
            System.out.println();
            users.forEach(user -> System.out.println(user.stampa()));
            this.request = new Request();
            this.request.put("choice", "getListUsersAssets");
        	MainDispatcher.getInstance().callAction("UserAsset", "doControl", this.request);
            break;
        case "insert":
           	List<Asset> assets = assetService.getAllAssetsN();
        	if(assets.isEmpty()) {
        		System.out.println("nessun asset disponibile");
        		break;
            }
        	else {
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
                request = new Request();
            	request.put("newUserAsset",new UserAsset(iduser,idasset,orainizio,orafine));
            	request.put("choice", "insertUserAsset");
            	MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
            	break;
        	}	
        	case "delete":
            	this.listUserAsset.forEach(userasset -> System.out.println(userasset));
            	//List<User> listUser = userService.getAllUsers();
            	//listUser.forEach(u -> System.out.println(u));
            	System.out.println("Inserisci l'associazione da eliminare:");
                System.out.println("Id user:");
                iduser = Integer.parseInt(getInput());
                System.out.println("inserisci id asset:");
                idasset = Integer.parseInt(getInput());
        		request = new Request();
        		request.put("delIdUser",iduser);
        		request.put("delIdAsset",idasset);
        	    request.put("choice", "deleteUserAsset");
        	    MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
        	    System.out.println("Utente eliminato,ritorno al menu");
            	//userService.deleteUser(username);
            	break;
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
