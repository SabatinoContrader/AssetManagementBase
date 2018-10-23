package com.pCarpet.dto;

import com.pCarpet.model.Assegnazione;
import com.pCarpet.model.Badge;
import com.pCarpet.model.User;

public class AssegnazioneDTO {

	//Assegnazione
	private long iduser;
	private long idbadge;
	private String nome;
	private String cognome;
	private String dataassegnazione;
	
	//User
//	private long idUser;
//	private String username;
//	private String ragioneSociale;
//	private String partitaiva;
//	private long flag;
	
	//Badge
//	private long idBadge;
//	private String descrizione;
//	private String tipologia;
	

	
	public AssegnazioneDTO() {
		
	}

	
	public AssegnazioneDTO(long iduser, long idbadge, String dataassegnazione) {
		this();
		this.iduser=iduser;
		this.idbadge=idbadge;
		this.dataassegnazione=dataassegnazione;
	}
	
	public AssegnazioneDTO(long iduser, long idbadge, String nome, String cognome,String dataassegnazione) {
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



	public long getIduser() {
		return iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}
	
//	public long getIdUser() {
//		return idUser;
//	}
//
//	public void setIdUser(long idUser) {
//		this.idUser = idUser;
//	}

	public long getIdbadge() {
		return idbadge;
	}

	public void setIdbadge(long idbadge) {
		this.idbadge = idbadge;
	}
	
//	public long getIdBadge() {
//		return idBadge;
//	}
//
//	public void setIdBadge(long idBadge) {
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
//	public long getFlag() {
//		return flag;
//	}
//
//
//	public void setFlag(long flag) {
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
