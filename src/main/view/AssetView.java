package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.dao.AssetDAO;
import main.service.AssetService;

import java.util.List;
import java.util.Scanner;

public class AssetView implements View {

    private AssetService AssetService;
    private String mode;

  public AssetView () {
      this.AssetService = new AssetService();
      this.mode = "viewAss";
  }

    @Override
    public void showResults(Request request) {
       this.mode  = (String) request.get("mode");
    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "viewAss":
                List<Asset> assets = AssetService.getAllAssets();
                System.out.println("----- Asset disponibili -----");
                System.out.println();
                assets.forEach(asset -> System.out.println(asset));
                break;

            case "insAss":
            	System.out.println("inserisci dati del nuovo asset");
            	System.out.println("tipo");
            	String tipo= getInput();
            	System.out.println("prezzo");
            	double prezzo = Double.parseDouble(getInput());
            	System.out.println("descrizione");
            	String descrizione= getInput();
            	AssetService.insertAsset(new Asset(tipo,prezzo,descrizione));
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
