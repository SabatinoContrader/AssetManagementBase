package main.controller;

import main.MainDispatcher;
import main.model.Asset;
import main.model.User;
import main.service.AssetService;

public class AssetController implements Controller {
	
	private AssetService assetService;

    @Override
    public void doControl(Request request) {
    	this.assetService = new AssetService();
    	String choice = request.get("choice").toString();
        if (choice != null) {
        	switch (choice) {
            case "assetsManagement":
            	MainDispatcher.getInstance().callView("AssetHome", request);
            	break;
            case "insert":
                request.put("mode", "insert");
                MainDispatcher.getInstance().callView("Asset", request);
                break;
            case "getList":
                request.put("mode", "getList");
            	request.put("visualizzaAssets", this.assetService.getAllAssets());
                MainDispatcher.getInstance().callView("Asset", request);
                break;
            case "update":
                request.put("mode", "update");
            	request.put("visualizzaAssets", this.assetService.getAllAssets());
                MainDispatcher.getInstance().callView("Asset", request);
                break;
            case "delete":
                request.put("mode", "delete");
            	request.put("visualizzaAssets", this.assetService.getAllAssets());
                MainDispatcher.getInstance().callView("Asset", request);
                break;
            case "insertAsset":
            	this.assetService.insertAsset((Asset)request.get("asset"));
            	MainDispatcher.getInstance().callView("AssetHome", request);
                break;
            case "deleteAsset":
            	this.assetService.deleteAsset((Integer) request.get("delAsset"));
            	MainDispatcher.getInstance().callView("AssetHome", request);
                break;
            case "updateAsset":
            	assetService.updateAsset(request);
            	MainDispatcher.getInstance().callView("AssetHome", request);
                break;
            case "getListAssets":
            	MainDispatcher.getInstance().callView("AssetHome", request);
                break;
        	}
        }
        else {
        	MainDispatcher.getInstance().callView("AssetHome", null);
        }
    }
}
    	/*
    	this.assetService=new AssetService();
    	int choice = (int) request.get("choice");
        switch (choice) {
            case 5:
            	request.put("mode", "insAss");
               	MainDispatcher.getInstance().callView("Asset", request);
              	
            	System.out.println((Asset)request.get("asset"));
            	System.out.println("TEST4");
            	assetService.insertAsset( (Asset)request.get("asset") );
            	
            	break;
            case 6:
                request.put("mode", "viewAss");
            	request.put("visualizza", assetService.getAllAssets());
                MainDispatcher.getInstance().callView("Asset", request);        
                break;
            case 7:
            	request.put("mode", "upAss");
            	request.put("visualizza", assetService.getAllAssets());
            	MainDispatcher.getInstance().callView("Asset", request);
            	break;
            case 8:
            	request.put("mode", "delAss");
            	request.put("visualizza", assetService.getAllAssets());
            	MainDispatcher.getInstance().callView("Asset", request);
            	break;
            case 10:
            	assetService.insertAsset( (Asset)request.get("asset") );
            	break;
            	
            case 11:
            	assetService.DeleteAsset((Integer) request.get("idAsset") );
            	break;
            case 12:
            	assetService.UpdateAsset(request);
            	break;            
        }
    }
}
*/