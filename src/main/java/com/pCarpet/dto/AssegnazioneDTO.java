package com.pCarpet.dto;

import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Badge;
import com.pCarpet.model.User;

public class AssegnazioneDTO {

	//Assegnazione
	private int iduser;
	private int idbadge;
	private String nome;
	private String cognome;
	private String dataassegnazione;
	
	//User
//	private int idUser;
//	private String username;
//	private String ragioneSociale;
//	private String partitaiva;
//	private int flag;
	
	//Badge
//	private int idBadge;
//	private String descrizione;
//	private String tipologia;
	

	
	public AssegnazioneDTO() {
		
	}

	
	public AssegnazioneDTO(int iduser, int idbadge, String dataassegnazione) {
		this();
		this.iduser=iduser;
		this.idbadge=idbadge;
		this.dataassegnazione=dataassegnazione;
	}
	
	public AssegnazioneDTO(int iduser, int idbadge, String nome, String cognome,String dataassegnazione) {
		this();
		this.iduser = iduser;
		this.idbadge = idbadge;
		this.nome=nome;
		this.cognome=cognome;
		this.dataassegnazione = dataassegnazione;
	}

	
//	public AssegnazioneDTO(Assegnazione a, User u, Badge b) {
//		
//		this();
//		this.iduser = a.getIdUtente();
//		this.idbadge = a.getIdBadge();
//		this.nome = a.getNome();
//		this.cognome= a.getCognome();
//		this.dataassegnazione = a.getDataassegnazione();
		
//		this.idUser = u.getIduser();
//		this.username = u.getUsername();
//		this.ragioneSociale = u.getRagioneSociale();
//		this.partitaiva = u.getPartitaiva();
//		this.flag = u.getFlag();
//		
//		this.idBadge = b.getIdBadge();
//		this.descrizione = b.getDescrizione();
//		this.tipologia = b.getTipologia();
		
//	}



	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	
//	public int getIdUser() {
//		return idUser;
//	}
//
//	public void setIdUser(int idUser) {
//		this.idUser = idUser;
//	}

	public int getIdbadge() {
		return idbadge;
	}

	public void setIdbadge(int idbadge) {
		this.idbadge = idbadge;
	}
	
//	public int getIdBadge() {
//		return idBadge;
//	}
//
//	public void setIdBadge(int idBadge) {
//		this.idBadge = idBadge;
//	}

	public String getDataassegnazione() {
		return dataassegnazione;
	}

	public void setDataassegnazione(String dataassegnazione) {
		this.dataassegnazione = dataassegnazione;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


//	public String getUsername() {
//		return username;
//	}
//
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//
//	public String getRagioneSociale() {
//		return ragioneSociale;
//	}
//
//
//	public void setRagioneSociale(String ragioneSociale) {
//		this.ragioneSociale = ragioneSociale;
//	}
//
//
//	public String getPartitaiva() {
//		return partitaiva;
//	}
//
//
//	public void setPartitaiva(String partitaiva) {
//		this.partitaiva = partitaiva;
//	}
//
//
//	public int getFlag() {
//		return flag;
//	}
//
//
//	public void setFlag(int flag) {
//		this.flag = flag;
//	}
//
//
//	public String getDescrizione() {
//		return descrizione;
//	}
//
//
//	public void setDescrizione(String descrizione) {
//		this.descrizione = descrizione;
//	}
//
//
//	public String getTipologia() {
//		return tipologia;
//	}
//
//
//	public void setTipologia(String tipologia) {
//		this.tipologia = tipologia;
//	}
	
	
	
	
	
}
