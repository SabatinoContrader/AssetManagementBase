package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.User;
import main.dao.UserDAO;
import main.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserView implements View{

    private UserService userService;
    private String mode;
    private String username;
   
    
  public UserView () {
      this.userService = new UserService();
      this.mode = "all";
  }

    @Override
    public void showResults(Request request) {
       this.mode  = (String) request.get("mode");
  
    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "all":
                List<User> users = userService.getAllUsers();
                System.out.println("----- Utente che hanno avuto accesso ad un assets -----");
                System.out.println();
                users.forEach(u -> System.out.println(u));
                break;
            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci i dati dell'utente:");
                System.out.println("Username:");
                username = getInput();
                System.out.println("Password:");
                String password = getInput();
                System.out.println("Nome:");
                String nome = getInput();
                System.out.println("Cognome:");
                String cognome = getInput();
                System.out.println("Telefono:");
                String telefono = getInput();
                System.out.println("Mail:");
                String mail = getInput();
                System.out.println("Partita iva:");
                String partitaiva = getInput();
                System.out.println("Ruolo:");
                String ruolo = getInput();
       
                userService.insertUser(new User(0,username,password,nome,cognome,telefono,mail,partitaiva,ruolo));
                break;
                
            case "delete":
            	List<User> listUser = userService.getAllUsers();
            	listUser.forEach(u -> System.out.println(u));
            	System.out.println("Inserisci lo username dell'utente da eliminare:");
                System.out.println("Username:");
                username = getInput();
            	userService.deleteUser(username);
            	break;
            	
            case "update":
            	 scanner = new Scanner(System.in);
            	 
            	 for(User u: userService.getAllUsers()) {
            		 System.out.println(u);
            	 }
            	 
            	 int idutente=0;
            	 try {
            		 System.out.println("Inserisci l'id riferito all'utente da aggiornare:");
            		 idutente=Integer.parseInt(getInput());
            	 }catch(Exception e) {//Controllo id valido
            		 System.out.println("L'ID Utente deve essere un intero");break;
            	 }
                 
                 
                 boolean trovato=false;
                 for(User u: userService.getAllUsers()) {
            		 if(u.getIdutente() == idutente) {
            			 trovato=true;
            		 }
            	 }
                 if(!trovato) {//Controllo id presente nel db
                	 System.out.println("ID "+idutente+" non trovato!"); 
                	 break;
                 }
                 
                 //Cambia il numero con il nome e effettua i controlli
            	 System.out.println("Inserisci il numero del campo che vuoi modificare:");
            	 int num=Integer.parseInt(getInput());
            	 String campo="";
            	 
            	 switch(num) {
            	 	case 1: campo="idutente";break;
            	 	case 2: campo="username";break;
            	 	case 3: campo="password";break;
            	 	case 4: campo="nome";break;
            	 	case 5: campo="cognome";break;
            	 	case 6: campo="telefono";break;
            	 	case 7: campo="mail";break;
            	 	case 8: campo="partitaiva";break;
            	 	case 9: campo="ruolo";break;
            	 }
            	 
            	 
            	 
            	 System.out.println("Inserisci il nuovo "+campo+" dell'utente:");
            	 username=getInput();
            	 
                 
                 
                 
                 Request request = new Request();
                 request.put("idutente", idutente);
                 request.put("username", username);
                 request.put("campo", campo);
                
                 
                 boolean flag = userService.updateUser(request);
                 if(!flag)System.out.println("Id "+ idutente+" non trovato");
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

