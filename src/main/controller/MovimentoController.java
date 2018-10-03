package main.controller;

import main.MainDispatcher;
import main.model.Movimento;
import main.model.User;
import main.service.MovimentoService;

public class MovimentoController implements Controller {

	private MovimentoService movimentoService;
	private String message;
	
    @Override
    public void doControl(Request request)  {
    	this.movimentoService = new MovimentoService();
    	this.message = "";
    	String choice = request.get("choice").toString();
        if (choice != null) {
        	switch (choice) {
            case "movimentiManagement":
            	request.put("visualizzaMovimenti", this.movimentoService.getAllMovimenti());
            	MainDispatcher.getInstance().callView("MovimentoHome", request);
            	break;
            case "insert":
            	request.put("visualizzaMovimenti", this.movimentoService.getAllMovimenti());
                MainDispatcher.getInstance().callView("InsertMovimento", request);
                break;
            case "update":
            	MainDispatcher.getInstance().callView("UpdateMovimento", request);
                break;
            case "delete":
            	request.put("visualizzaMovimenti", this.movimentoService.getAllMovimenti());
                MainDispatcher.getInstance().callView("DeleteMovimento", request);
                break;
            case "insertMovimento":
            	if (this.movimentoService.insertMovimento((Movimento)request.get("newMovimento"))) {
            		this.message = "Inserimento movimento avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di inserimento utente";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaMovimenti", this.movimentoService.getAllMovimenti());
        		MainDispatcher.getInstance().callView("MovimentoHome", request);
            	break;
            	
            case "deleteMovimento":
            	if (this.movimentoService.deleteMovimento(Integer.parseInt(request.get("delIdBadgeReader").toString()), Integer.parseInt(request.get("delIdBadge").toString()), request.get("delDatainizio").toString())) {
            		this.message = "Cancellazione movimento avvenuta correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di cancellazione movimento";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaMovimenti", this.movimentoService.getAllMovimenti());
        		MainDispatcher.getInstance().callView("MovimentoHome", request);
            	break;
//            case "updateMovimento":
//            	if (this.movimentoService.updateMovimento(request)) {
//            		this.message = "Aggiornamento movimento avvenuto correttamente";
//            	}
//            	else {
//            		this.message = "Errore durante la procedura di aggiornamento movimento";
//            	}
//            	request.put("message", this.message);
//            	request.put("visualizzaMovimenti", this.movimentoService.getAllMovimenti());
//        		MainDispatcher.getInstance().callView("MovimentoHome", request);
//            	break;
            }
        }
        else {
        	MainDispatcher.getInstance().callView("MovimentoHome", null);
        }
    }
}
