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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;import java.util.Scanner;

public class UserAssetView implements View {

    private UserAssetService userAssetService;
    private String username;
    private String mode;
    private UserService userService;
    private List<UserAsset> listUserAsset;
    private Request request;
    private int iduser;
    private int idasset;
    String orainizio;

	public UserAssetView () {
	    this.userAssetService = new UserAssetService();
	    this.userService = new UserService();
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
            request=new Request();
           	request.put("choice", "getClienti");
           	MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
            List<User> users = (List<User>) request.get("visualizzaClienti");
            System.out.println("\n\ni clienti con un asset prenotato sono:");
            System.out.println();
            users.forEach(user -> System.out.println(user.stampa()));
            this.request = new Request();
            this.request.put("choice", "getListUsersAssets");
        	MainDispatcher.getInstance().callAction("UserAsset", "doControl", this.request);
            break;
        case "insert":
        	
           	request=new Request();
           	request.put("choice", "getListSenzaPrenotazioni");
           	MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
           	List<Asset> userAssetsNonPrenotati = (List<Asset>)request.get("visualizzaAssetsSenzaPrenotazioni");
           	
           	System.out.println("----- Asset senza prenotazioni -----");
        	System.out.println();
        	userAssetsNonPrenotati.forEach(asset -> System.out.println(asset));
        	
        	
        	request=new Request();
           	request.put("choice", "getList2");
           	MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
           	List<UserAsset> userAssets = (List<UserAsset>)request.get("visualizzaUtentiAssets");
        	
        	System.out.println("----- Asset con prenotazioni -----");
        	System.out.println();
        	userAssets.forEach(asset -> System.out.println(asset));
        	
        	List<User> users2 = userService.getAllClienti();	//DA MODIFICARE
        	System.out.println("----- Clienti -----");
        	System.out.println();
        	users2.forEach(user -> System.out.println(user));
        	
        	System.out.println("\nInserisci dati");
        	System.out.println("Inserisci id utente");
        	int iduser=Integer.parseInt(getInput());
        	System.out.println("Inserisci id asset");
        	int idasset=Integer.parseInt(getInput());
        	System.out.println("Inserisci la data di inizio prenotazione(yyyy-mm-gg hh:mm:ss):");
        	orainizio=getInput();
        	
        	while(!controlloAssetDisponibile(idasset,userAssets, orainizio, true) && !orainizio.equals("")) {
        		System.out.println("L'asset con id "+idasset+" è già prenotato per la data: "+orainizio+ "!");
        		System.out.println("Scegli un altra data di inizio prenotazione o premi invio per annullare la prenotazione:");
        		orainizio=getInput();
        	}
        	if(orainizio.equals("")) {
        		request=new Request();
        		request.put("choice", "userAssetHome");
        		MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
        	}
        	
        	
        	
        	System.out.println("Data inizio correttamente inserita ("+orainizio+")");
        	System.out.println("Inserisci la data di fine prenotazione(yyyy-mm-gg hh:mm:ss):");
        	String orafine= getInput();
        	
        	while(orafine.compareTo(orainizio)<=0 || !controlloAssetDisponibile(idasset,userAssets, orafine, false) && !orafine.equals("")) {
        		if(orafine.compareTo(orainizio)<=0) {
        			System.out.println("La data di fine prenotazione non può essere antecedente alla data di inizio ("+orainizio+")!");
        			System.out.println("Inserisci una data corretta o premi invio per annullare la prenotazione:");
        		}else {
        			System.out.println("L'asset con id "+idasset+" è già prenotato per la data: "+orafine+ "!");
            		System.out.println("Scegli un altra data di fine prenotazione o premi invio per annullare la prenotazione:");
        		}
        		
        		orafine=getInput();
        	}
        	if(orafine.equals("")) {
        		request.put("choice", "userAssetHome");
        		MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
        	}
        	
        		
        	request = new Request();
            request.put("newUserAsset",new UserAsset(iduser,idasset,orainizio,orafine));
            request.put("choice", "insertUserAsset");
            	
            	
            MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
            break;
        	
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
    
    
    private boolean controlloAssetDisponibile(int idasset,List<UserAsset> userAsset, String date, boolean dateInizio) {
    	
    	//MyData date=new MyData(d);
    	
    	for(UserAsset ua: userAsset) {
    		if(dateInizio) {
    			if( ua.getIdasset()==idasset && date.compareTo(ua.getOrainizio())>=0 && date.compareTo(ua.getOrafine())<0 ) {
    				return false;
    			}
    		}else {
    			if( ua.getIdasset()==idasset && date.compareTo(ua.getOrainizio())>0 && date.compareTo(ua.getOrafine())<=0 ) {
    				return false;
    			}
    			
    			
    			if( ua.getIdasset()==idasset && orainizio.compareTo(ua.getOrainizio())<=0 && date.compareTo(ua.getOrafine())>=0 ){
    				return false;
    			}
    		}
    		
    		
    		
    		
    	}
    	
    	return true;
    	
    }

}
