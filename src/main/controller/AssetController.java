package main.controller;

import main.MainDispatcher;
import main.model.Asset;
import main.service.AssetService;

public class AssetController implements Controller {
	
	//private Request request = new Request();
	private AssetService assetService;
	//private AssetV

    @Override
    public void doControl(Request request) {
    	assetService=new AssetService();
    	
        int choice = (int) request.get("choice");
        switch (choice) {
            case 5:
            	request.put("mode", "insAss");
            		
            	MainDispatcher.getInstance().callView("Asset", request);
            	
            	/*
            	System.out.println((Asset)request.get("asset"));
            	System.out.println("TEST4");
            	assetService.insertAsset( (Asset)request.get("asset") );
            	*/
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
