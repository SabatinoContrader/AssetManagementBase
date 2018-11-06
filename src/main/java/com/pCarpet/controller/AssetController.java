package com.pCarpet.controller;



import com.pCarpet.dto.AbbonamentoDTO;
import com.pCarpet.dto.AssetDTO;
import com.pCarpet.dto.BadgeDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.services.AssetService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/Asset")
public class AssetController {

	private AssetService assetService;
    private List<AssetDTO> listAssets;
	private  AssetDTO l;
	private List<AssetDTO> x;

	@Autowired
	public AssetController(AssetService assetService) {
		this.assetService = assetService;
	}
	
	@RequestMapping(value = "/showAssets", method = RequestMethod.GET)
	public List<AssetDTO> Asset(HttpServletRequest request, Model model) {
	    List<AssetDTO> allAssets = this.assetService.getAllAssets();
	    return this.assetService.getAllAssets();
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public List<AssetDTO> deleteControl(HttpServletRequest request, Model model ) {
		int id=Integer.parseInt(request.getParameter("id"));
		this.assetService.deleteAsset(id);
		List<AssetDTO> assets = assetService.getAllAssets();
		return assets;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public List<AssetDTO> modifyControl(HttpServletRequest request, Model model ) {
		;
		long id=Integer.parseInt(request.getParameter("idasset"));
		
		String descrizione=request.getParameter("descrizone");
		
		String tipo=request.getParameter("tipo");
		
		long prezzo= Integer.parseInt(request.getParameter("prezzo"));
		
		AssetDTO assetDTO = new AssetDTO(id,descrizione,tipo,prezzo,1);
		this.assetService.insertAsset(assetDTO);
		List<AssetDTO> assets = assetService.getAllAssets();
		return assets;
	}
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public List<AssetDTO> insertControl(HttpServletRequest request, Model model ) {
		System.out.println("TEST");
		long idasset=0;
		String tipo=request.getParameter("tipo");
		String descrizione=request.getParameter("descrizione");
		long prezzo=Integer.parseInt(request.getParameter("prezzo"));
		AssetDTO assetDTO = new AssetDTO(idasset,tipo,descrizione,prezzo,1);
		this.assetService.insertAsset(assetDTO);
		List<AssetDTO> assets = this.assetService.getAllAssets();
		return assets;
	}
	
	    /*model.addAttribute("allAssets", allAssets);
	    String scelta= request.getParameter("scelta");
	    
	    if (scelta.equals("AssetManagement")) {
			allAssets = this.assetService.getAllAssets();
		    model.addAttribute("allAssets", allAssets);
			return "assetHome";
		}
	
		
		else if(scelta.equals("update")) {
			AssetDTO a = this.assetService.getAsset(Integer.parseInt(request.getParameter("id")));			
			model.addAttribute("asset", a);

		    return "updateAsset";
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
		
		
	}*/
	
	@RequestMapping(value = "/homeAsset", method = RequestMethod.GET)
	public String getBadges(HttpServletRequest request, Model model ) {
		return "";
		}
	
	@RequestMapping(value = "/removeAsset", method = RequestMethod.GET)
	public String removeAsset(@RequestParam("id") int idasset, Model model ) 
	{
		AssetDTO asset = assetService.getAsset(idasset);
		return "assetHome";}
	
	@RequestMapping(value ="/modificaAssetRedirect",method = RequestMethod.GET)
	public String modifiedredirectAsset(HttpServletRequest request, Model model )
	{
		int id=Integer.parseInt(request.getParameter("id"));
		l = assetService.getAsset(id);
		request.setAttribute("id1", id);
		model.addAttribute("asset", l);
		return "modificaAsset";
	}
	
	@RequestMapping(value = "/addAsset", method = RequestMethod.POST)
	public String addedAsset(HttpServletRequest request, Model model ) {
		String descrizione = request.getParameter("descrizione");
		String tipo = request.getParameter("tipo");
		long prezzo = Long.parseLong(request.getParameter("prezzo"));
		
		AssetDTO asset = new AssetDTO(0, descrizione, tipo,prezzo,1l);
		asset.setIdAsset(0);
		asset.setDescrizione(descrizione);
		asset.setTipo(tipo);
		asset.setPrezzo(prezzo);
		assetService.insertAsset(asset);
		List<AssetDTO> assets = assetService.getAllAssets();
		model.addAttribute("assets", assets);
		return "assetHome";
	}

@RequestMapping(value = "/modificaAsset", method = RequestMethod.POST)
public String modifiedAsset(HttpServletRequest request, Model model )
{
	long id=Integer.parseInt(request.getParameter("id"));
	String descrizione = request.getParameter("descrizione");
	String tipo = request.getParameter("tipo");
	long prezzo = Long.parseLong(request.getParameter("prezzo"));
	AssetDTO asset = new AssetDTO(id, descrizione, tipo,prezzo,1l);
	assetService.insertAsset(asset);
	List<AssetDTO> assets = assetService.getAllAssets();
	model.addAttribute("assets", assets);
	/*@RequestMapping(value = "/homeAsset", method = RequestMethod.POST)
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
					
					AssetDTO a =new AssetDTO(0l,tipo,descrizione,prezzo,1l);
					
					assetService.insertAsset(a);
					assets = assetService.getAllAssets();
					model.addAttribute("allAssets", assets);
					return "assetHome";
				
			
				
			case "update":
				long idm = Integer.parseInt(request.getParameter("id"));
					String tipom=request.getParameter("tipo");
					String descrizionem=request.getParameter("descrizione");
					String prezzoSm=request.getParameter("prezzo");
					prezzoSm=prezzoSm.replace(',', '.');
					double prezzom=Double.parseDouble(prezzoSm);
					AssetDTO am =new AssetDTO(idm,tipom,descrizionem,prezzom,1l);
					
					assetService.insertAsset(am);
					List<AssetDTO> Allassets = assetService.getAllAssets();
					model.addAttribute("allAssets", Allassets);
					return "assetHome";
			}*/
		
	
		return "assetHome";
}
}
	
	



