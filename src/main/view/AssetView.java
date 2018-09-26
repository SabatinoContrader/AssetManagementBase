package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.dao.AssetDAO;
import main.service.AssetService;

import java.util.List;
import java.util.Scanner;

public class AssetView implements View {

    private AssetService assetService;
    private String mode;
    private String tipo;

  public AssetView () {
      this.assetService = new AssetService();
      this.mode = "all";
  }

    @Override
    public void showResults(Request request) {
       this.mode  = (String) request.get("mode");
    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "viewAss":
                List<Asset> assets = assetService.getAllAssets();
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
            	assetService.insertAsset(new Asset(tipo,prezzo,descrizione));
            	break;
            	
            case "delAss":
            	List<Asset> asset = assetService.getAllAssets();
            	asset.forEach(u->System.out.println(u));
            	System.out.println("inserire l'asset da eliminare");
            	System.out.println("Id:");
            	 int idasset = Integer.parseInt(getInput());
            	assetService.DeleteAsset(idasset);
            	System.out.println("Asset eliminato,ritorno al menu");
            	
            	
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
