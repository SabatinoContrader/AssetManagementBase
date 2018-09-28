package main.controller;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
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
            	 writeOnExcel();
                 MainDispatcher.getInstance().callView("UserAssetHome", request);
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
            	UserAsset userAsset = (UserAsset)request.get("newUserAsset");
            	this.userAssetService.insertUserAsset(userAsset);
            	this.userAssetService.insertStorico(userAsset);
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
    
    public void writeOnExcel() {
    	File f=new File("C:\\Users\\Public\\test.xls");
		UserAssetService users = new UserAssetService();
		try {
			WritableWorkbook myexel = Workbook.createWorkbook(f);
			WritableSheet mysheet = myexel.createSheet("mySheet", 0);
			Label l=null;
			Label l2=null;
			Label l3=null;
			Label l4=null;
			for(int i=0; i<users.getAllStorico().size(); i++) {
				for(int j=0; j<4; j++) {
					l=new Label(0,i, String.valueOf(users.getAllStorico().get(i).getIdasset()) );
					l2=new Label(1,i, String.valueOf(users.getAllStorico().get(i).getIduser()) );
					l3=new Label(2,i, users.getAllStorico().get(i).getOrainizio());
					l4=new Label(3,i, users.getAllStorico().get(i).getOrafine());
					mysheet.addCell(l);
					mysheet.addCell(l2);
					mysheet.addCell(l3);
					mysheet.addCell(l4);
				}
			}
			myexel.write();	
			myexel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
