package com.pCarpet.dto;

import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Badge;
import com.pCarpet.model.User;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AssegnazioneDTO {

	//Assegnazione
	private long idassegnazione;
	private long iduser;
	private long idbadge;
	private String nome;
	private String cognome;
	private String dataassegnazione;
	private long flag;
	
	
	public AssegnazioneDTO() {
		
	}

		public AssegnazioneDTO(long idassegnazione,long iduser, long idbadge, String dataassegnazione) {
		this();
		this.idassegnazione=idassegnazione;
		this.iduser=iduser;
		this.idbadge=idbadge;
		this.dataassegnazione=dataassegnazione;
	}
	
	public AssegnazioneDTO(long idassegnazione,long iduser, long idbadge, String nome, String cognome,String dataassegnazione,long flag) {
		this();
		this.idassegnazione=idassegnazione;
		this.iduser = iduser;
		this.idbadge = idbadge;
		this.nome=nome;
		this.cognome=cognome;
		this.dataassegnazione = dataassegnazione;
		this.flag=flag;
	}
}

