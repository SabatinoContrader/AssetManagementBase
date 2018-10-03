package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.services.AssetService;
import com.virtualpairprogrammers.services.UserService;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.domain.Asset;
import com.virtualpairprogrammers.domain.User;
import com.virtualpairprogrammers.genericclass.Reference;

public class AssetServlet extends HttpServlet {
	
	private AssetService assetService;
	private UserService userService;
	private String message;
public AssetServlet() {
	assetService = new AssetService();
	userService = new UserService();
	
}
public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//@Override
	//public void doControl(Request request) {
    	this.assetService = new AssetService();
    	this.message = "";
	User user = userService.getLoggedUser();
	String username = user.getUsername();

	List<Asset>assets= assetService.getAllAssets();
	Reference<List<Asset>> myassets = new Reference<List<Asset>>(assets);
	request.setAttribute("assets", assets);
	
	String view = request.getParameter("richiesta");
	if (view != null) {
		switch (view) {
        case "assetsManagement":
        	getServletContext().getRequestDispatcher("/DeleteAsset.jsp").forward(request, response);
        	break;
        case "insert":
			//int idasset = Integer.parseInt(request.getParameter("id"));
			String Tipo =request.getParameter("Tipo");
			float prezzo = Float.parseFloat(request.getParameter("prezzo"));
			String Descrizione =request.getParameter("Descrizione");
			//assetService.insertAsset(idasset);
			assetService.insertAsset(Tipo);
			assetService.insertAsset(prezzo);
			assetService.insertAsset(Descrizione);
			getServletContext().getRequestDispatcher("/InsertAsset.jsp").forward(request, response);
            break;
        case "update":

        	getServletContext().getRequestDispatcher("/UpdateAsset.jsp").forward(request, response);
            break;
        case "delete":
			int id = Integer.parseInt(request.getParameter("id"));
			//String Tipo =request.getParameter("Tipo");
			//float prezzo = Float.parseFloat(request.getParameter("prezzo"));
			//String Descrizione =request.getParameter("Descrizione");
			assetService.deleteAsset(id);
			//assetService.deleteAsset(Tipo);
			getServletContext().getRequestDispatcher("/DeleteAsset.jsp").forward(request, response);
			break;
			default:
			getServletContext().getRequestDispatcher("/DeleteAsset.jsp").forward(request, response);            break;
        /*case "insertAsset":
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
        }*/
    }
}
}
}
