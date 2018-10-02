package main.controller;

import main.MainDispatcher;
import main.model.Asset;
import main.service.AssetService;

public class AssetController implements Controller {
	
	private AssetService assetService;
	private String message;
	
    @Override
    public void doControl(Request request) {
    	this.assetService = new AssetService();
    	this.message = "";
    	String choice = request.get("choice").toString();
        if (choice != null) {
        	switch (choice) {
            case "assetsManagement":
            	request.put("visualizzaAssets", this.assetService.getAllAssets());
            	MainDispatcher.getInstance().callView("AssetHome", request);
            	break;
            case "insert":
                MainDispatcher.getInstance().callView("InsertAsset", request);
                break;
            case "update":
                MainDispatcher.getInstance().callView("UpdateAsset", request);
                break;
            case "delete":
                MainDispatcher.getInstance().callView("DeleteAsset", request);
                break;
            case "insertAsset":
            	if (this.assetService.insertAsset((Asset)request.get("newAsset"))) {
            		this.message = "Inserimento asset avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di inserimento asset";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaAssets", this.assetService.getAllAssets());
            	MainDispatcher.getInstance().callView("AssetHome", request);
            	break;
            case "deleteAsset":
            	if (this.assetService.deleteAsset((Integer) request.get("delAsset"))) {
            		this.message = "Cancellazione asset avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di cancellazione asset";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaAssets", this.assetService.getAllAssets());
            	MainDispatcher.getInstance().callView("AssetHome", request);
            	break;
            case "updateAsset":
            	if (assetService.updateAsset(request)) {
            		this.message = "Aggiornamento asset avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di aggiornamento asset";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaAssets", this.assetService.getAllAssets());
            	MainDispatcher.getInstance().callView("AssetHome", request);
            	break;
            }
        }
        else {
        	MainDispatcher.getInstance().callView("AssetHome", null);
        }
    }
}
    