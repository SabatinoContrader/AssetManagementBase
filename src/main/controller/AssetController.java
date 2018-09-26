package main.controller;

import main.MainDispatcher;

public class AssetController implements Controller {


    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");
        switch (choice) {
            case 5:
            	request.put("mode", "insAss");
            	break;
            case 6:
                request.put("mode", "viewAss");
                break;
            case 8:
            	request.put("mode", "delAss");
        }
        MainDispatcher.getInstance().callView("Asset", request);

    }
}
