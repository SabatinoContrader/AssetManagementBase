package main.controller;

import main.MainDispatcher;
import main.model.UserAsset;
import main.service.UserAssetService;

public class UserAssetController implements Controller {

	private UserAssetService userAssetService;
	
    @Override
    public void doControl(Request request) {
    	this.userAssetService = new UserAssetService();
    	String choice = request.get("choice").toString();
        if (choice != null) {
        	switch (choice) {
            case "usersAssetsManagement":
            	MainDispatcher.getInstance().callView("UserAssetHome", request);
            	break;
            case "insert"://assegna asset ad utente
                request.put("mode", "insert");
                MainDispatcher.getInstance().callView("UserAsset", request);
                break;
            case "getList":
                request.put("mode", "getList");
                request.put("visualizzaUtentiAssets", this.userAssetService.getAllUsersAssets());
                MainDispatcher.getInstance().callView("UserAsset", request);
                break;
            case "export":
                request.put("mode", "getList");
                request.put("visualizzaUtentiAssets", this.userAssetService.getAllUsersAssets());
                MainDispatcher.getInstance().callView("UserAsset", request);
                break;
//            case "update":
//                request.put("mode", "update");
//            	request.put("visualizzaUtentiAssets", userAssetService.getAllUsersAssets());
//            	MainDispatcher.getInstance().callView("User", request);
//                break;
//            case "delete":
//            	request.put("visualizzaUtentiAssets", userAssetService.getAllUsersAssets());
//                request.put("mode", "delete");
//                MainDispatcher.getInstance().callView("User", request);
//                break;
            case "insertUserAsset":
            	this.userAssetService.insertUserAsset((UserAsset)request.get("newUserAsset"));
            	MainDispatcher.getInstance().callView("UserAssetHome", request);
                break;
//            case "deleteUserAsset":
//            	this.userAssetService.deleteUserAsset(request.get("delUser").toString());
//            	MainDispatcher.getInstance().callView("UserHome", request);
//                break;
//            case "updateUserAsset":
//            	this.userAssetService.updateUserAsset(request);
//            	MainDispatcher.getInstance().callView("UserHome", request);
//                break;
            case "getListUsersAssets":
            	MainDispatcher.getInstance().callView("UserAssetHome", request);
                break;
        	}
        }
        else {
        	MainDispatcher.getInstance().callView("UserAssetHome", null);
        }
    }
}
