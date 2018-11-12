package com.pCarpet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pCarpet.dto.AbbonamentoDTO;
import com.pCarpet.dto.AssetDTO;
import com.pCarpet.dto.StatoDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.services.AbbonamentoService;
import com.pCarpet.services.AssetService;
import com.pCarpet.services.StatoService;
import com.pCarpet.services.UserService;

@SpringBootApplication

public class PCarpetApplication {

	static AssetService assetService;
	static AbbonamentoService abbonamentoService;
	static StatoService statoService;
	static UserService userService;
	static AbbonamentoDTO AbbDTO= new AbbonamentoDTO(1,"normale",100);
	static StatoDTO fDTO = new StatoDTO(1,"attivo");
	
	
	@Autowired
	public PCarpetApplication( UserService userService,AssetService assetService, AbbonamentoService abbonamentoService, StatoService statoService) {
		this.userService = userService;
		this.abbonamentoService=abbonamentoService;
		this.statoService=statoService;
		this.assetService=assetService;
	}
	public static void main(String[] args) {
		SpringApplication.run(PCarpetApplication.class, args);
	
		defaultAbb("normale",100);
		defaultAbb("silver",200);
		defaultAbb("gold",300);
		defaultAbb("business",400);
		
		defaultStato("eliminato");
		defaultStato("attivo");
		
		defaultAsset();
		
		defaultUser();
		
		
		
		
	}
	
	public static void defaultAbb(String nome, double prezzo)
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
		abbonamentoService.insertAbb(abb);
	}
	
	public static void defaultStato(String value) {
		StatoDTO sDTO=new StatoDTO();
		if(value.equals("attivo"))
			sDTO.setId(1l);
		else if(value.equals("eliminato"))
			sDTO.setId(2l);
		sDTO.setValore(value);
		statoService.insertStato(sDTO);
			
	}
	
	public static void defaultAsset() {
		AssetDTO assDTO=new AssetDTO();
		assDTO.setIdAsset(1l);
		assDTO.setDescrizione("vuoto");
		assDTO.setFlag(1l);
		assDTO.setPrezzo(00);
		assDTO.setTipo("vuoto");
		assetService.insertAsset(assDTO);
	}
	
	public static void defaultUser() {
		UserDTO usDTO=new UserDTO();
		usDTO.setIduser(1l);
		usDTO.setMail("patrizia@live.it");
		usDTO.setNomeAbb(AbbDTO);
		usDTO.setStato(fDTO);
		usDTO.setPartitaiva("12564789324");
		usDTO.setPassword("password");
		usDTO.setRagioneSociale("patrick srl");
		usDTO.setRuolo("segretaria");
		usDTO.setTelefono("3204565767");
		usDTO.setUsername("patrizia");
		userService.insertUser(usDTO);
	}
}
