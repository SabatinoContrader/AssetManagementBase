package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Userasset;
import main.dao.UserassetDAO;
import main.service.UserassetService;

import java.util.List;import java.util.Scanner;

public class UserassetView implements View {

    private UserassetService UserassetService;
    private String mode;

  public UserassetView () {
      this.UserassetService = new UserassetService();
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
                break;

            case "insUserAss":
            	System.out.println("inserisci dati");
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
