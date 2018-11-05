package com.pCarpet.controller;


import com.pCarpet.dto.AbbonamentoDTO;
import com.pCarpet.dto.AssetDTO;
import com.pCarpet.dto.StatoDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.services.AbbonamentoService;
import com.pCarpet.services.AssetService;
import com.pCarpet.services.StatoService;
import com.pCarpet.services.UserService;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//@Controller
@RestController
@CrossOrigin
@RequestMapping("/Login")
public class LoginController {

	private UserService userService;
	private UserDTO user;
	private HttpSession session;
	private AbbonamentoService abbonamentoservice;
	private StatoService statoService;
	private AssetService assetService;
	
	@Autowired
	public LoginController(UserService userService, AbbonamentoService abs,AssetService assetService, StatoService statoService) {
		this.userService = userService;
		this.abbonamentoservice=abs;
		this.statoService=statoService;
		this.assetService=assetService;
	}
	//@POST
	@RequestMapping(value = "/loginControl", method = RequestMethod.POST)
	@CrossOrigin
	public List<UserDTO> loginControl(HttpServletRequest request, Model model) {
	
		defaultAbb("normale",100);
		defaultAbb("silver",200);
		defaultAbb("gold",300);
		defaultAbb("business",400);
		
		defaultStato("eliminato");
		defaultStato("attivo");
		
		defaultAsset();
		List<UserDTO> lUserDTO=new ArrayList<>();
		lUserDTO=this.userService.getAllUsers();
		return lUserDTO;
		/*
		this.session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ruolo = this.userService.login(username, password);
		if (ruolo!="") {
			if (ruolo.equals("segretaria")) {
				
				   
				   
//				UserDTO userDTO=new UserDTO("patrizia","segretaria");
//				List<UserDTO> listuserDTO = new ArrayList<UserDTO>();
//				listuserDTO.add(userDTO);
				
				List<UserDTO> listuserDTO = userService.getAllUsers();
				        
//				        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(assDTO.getIdAsset())).build();
//				        return Response.created(uri)
//				                .entity(assDTO)
//				                .build();
				
				
				
				
				//AssetDTO assDTO=new AssetDTO("prova1","prova2",5,url,"porcaputtana");
				return listuserDTO;
				
				//return "homeSegretaria";
			}	
			else if (this.user.getRuolo().equals("cliente")) {
				//return "homeCliente";
			}
			else if (this.user.getRuolo().equals("amministratore")) {
				//return "homeAdmin";
			}	
			else {
				//return "index";
			}	
		}
		else {
			model.addAttribute("feedback", "wrong");
			//return "index";
		}
		return null;
		//return "index";
		 * 
		 */
	}
	
	@RequestMapping(value = "/logoutControl", method = RequestMethod.GET)
	public String logoutControl(HttpServletRequest request, Model model ) {
		this.session.invalidate();
		return "index";
	}
	
	public HttpSession getSession() {
		return this.session;
	}
	
	
	public void defaultAbb(String nome, double prezzo)
	{
		AbbonamentoDTO abb = new AbbonamentoDTO();
		if(nome.equals("normale"))
			abb.setId(1l);
		else if(nome.equals("silver"))
			abb.setId(2l);
		else if(nome.equals("gold"))
			abb.setId(3l);
		else if(nome.equals("business"))
			abb.setId(4l);
		abb.setNome(nome);
		abb.setPrezzo(prezzo);
		abbonamentoservice.insertAbb(abb);
	}
	
	public void defaultStato(String value) {
		StatoDTO sDTO=new StatoDTO();
		if(value.equals("attivo"))
			sDTO.setId(1l);
		else if(value.equals("eliminato"))
			sDTO.setId(2l);
		sDTO.setValore(value);
		statoService.insertStato(sDTO);
			
	}
	
	public void defaultAsset() {
		AssetDTO assDTO=new AssetDTO();
		assDTO.setIdAsset(1l);
		assDTO.setDescrizione("vuoto");
		assDTO.setFlag(1l);
		assDTO.setPrezzo(00);
		assDTO.setTipo("vuoto");
		assetService.insertAsset(assDTO);
	}
	
}
