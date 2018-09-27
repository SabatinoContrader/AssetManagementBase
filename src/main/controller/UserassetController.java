package main.controller;

import main.MainDispatcher;

public class UserassetController implements Controller {


    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");
        switch (choice) {
            case 9:
            	request.put("mode", "insUserAss");
            	break;
            case 10:
            	request.put("mode", "viewUserAss");
            	break;
        }
        MainDispatcher.getInstance().callView("Userasset", request);

    }
}
