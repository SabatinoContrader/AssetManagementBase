package com.pCarpet.controller;



import com.pCarpet.dto.AssetDTO;
import com.pCarpet.services.AssetService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/Asset")
public class AssetController {

	private AssetService assetService;

	@Autowired
	public AssetController(AssetService assetService) {
		this.assetService = assetService;
	}
	
	@RequestMapping(value = "/homeAsset", method = RequestMethod.GET)
	public String Asset(HttpServletRequest request, Model model) {
	    List<AssetDTO> allAssets = this.assetService.getAllAssets();
	    model.addAttribute("allAssets", allAssets);
	    String scelta= request.getParameter("scelta");
	    if (scelta.equals("AssetManagement")) {
			allAssets = this.assetService.getAllAssets();
		    model.addAttribute("allAssets", allAssets);
			return "assetHome";
		}
	
		
		else if(scelta.equals("update")) {
			/*
			System.out.println("TEST-1");
			
			System.out.println("RRR:"+request.getParameter("campo").toString());
			Asset a = this.assetService.getAsset(Integer.parseInt(request.getParameter("id")));
			model.addAttribute("asset", a);
			*/
			model.addAttribute("asset",assetService.getAsset(Integer.parseInt(request.getParameter("id"))));

		    return "updateAsset";
		    /*
			if(assetService.updateAsset(request)) {
				
				System.out.println("TEST0"+request.getParameter("id"));
				System.out.println("TEST1"+this.assetService.getAsset(Integer.parseInt(request.getParameter("id"))));
				Asset a = this.assetService.getAsset(Integer.parseInt(request.getParameter("id")));
			    System.out.println(a);
				model.addAttribute("asset", a);
				
				
			}
			*/
		}
		
		else if (scelta.equals("indietro")) {
			allAssets = this.assetService.getAllAssets();
	    	model.addAttribute("allAssets", allAssets);
			return "assetHome";
	}
		else if (scelta.equals("indietroAssBad")) {
			allAssets = this.assetService.getAllAssets();
	    	model.addAttribute("allAssets", allAssets);
			return "homeAssBadRead";
	}
		else if (scelta.equals("insert"))
			return "insertAsset";
		else if(scelta.equals("delete")) {
			
			assetService.deleteAsset(Integer.parseInt((request.getParameter("id"))));
			allAssets = assetService.getAllAssets();
			model.addAttribute("allAssets", allAssets);
			return "assetHome";
		}
		
		
			return "";
		
		
	}
		
	@RequestMapping(value = "/homeAsset", method = RequestMethod.POST)
	public String loginControlPost(HttpServletRequest request, Model model ) {
		List<AssetDTO> assets = assetService.getAllAssets();
		model.addAttribute("assets", assets);
			
		String scelta=request.getParameter("scelta");
	
		
			switch(scelta) {
				
			case "insert":
					String tipo=request.getParameter("tipo");
					String descrizione=request.getParameter("descrizione");
					String prezzoS=request.getParameter("prezzo");
					prezzoS=prezzoS.replace(',', '.');
					double prezzo=Double.parseDouble(prezzoS);
					AssetDTO a =new AssetDTO(0,tipo,descrizione,prezzo);
					
					assetService.insertAsset(a);
					assets = assetService.getAllAssets();
					model.addAttribute("allAssets", assets);
					return "assetHome";
				
			
				
			case "update":
				
				assetService.updateAsset(request);
				assets = assetService.getAllAssets();
				model.addAttribute("allAssets", assets);
				return "assetHome";
			
			}
		
	
		return "assetHome";
	}
}
	
	



