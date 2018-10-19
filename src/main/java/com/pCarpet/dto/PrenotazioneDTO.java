package com.pCarpet.dto;

import com.pCarpet.model.Asset;
import com.pCarpet.model.Prenotazione;
import com.pCarpet.model.User;

public class PrenotazioneDTO {

	private int iduser;
	private int idasset;
	private String orainizio;
	private String orafine;
	
//	private int iduser2;
//	private String username;
//	private String ragioneSociale;
//	private String partitaiva;
//	private int flag;
	
	
//	private int idasset2;
//	private String descrizione;
//	private String tipo;
//	private double prezzo;
	
	
	public PrenotazioneDTO() {
	}
	
	public PrenotazioneDTO(int iduser, int idasset, String orainizio, String orafine) {
		this.iduser=iduser;
		this.idasset=idasset;
		this.orainizio=orainizio;
		this.orafine=orafine;
	}
	


//	public PrenotazioneDTO(int iduser, int idasset, String orainizio, String orafine, User u, Asset a) {
//		this.iduser=iduser;
//		this.idasset=idasset;
//		this.orainizio=orainizio;
//		this.orafine=orafine;
		
//		this.iduser2=u.getIduser();
//		this.username=u.getUsername();
//		this.ragioneSociale=u.getRagioneSociale();
//		this.partitaiva=u.getPartitaiva();
//		this.flag=u.getFlag();
//		
//		this.idasset2=a.getIdAsset();
//		this.descrizione=a.getDescrizione();
//		this.tipo=a.getTipo();
//		this.prezzo=a.getPrezzo();
		
	//}
	
	
	
	
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getRagioneSociale() {
//		return ragioneSociale;
//	}
//
//	public void setRagioneSociale(String ragioneSociale) {
//		this.ragioneSociale = ragioneSociale;
//	}
//
//	public String getPartitaiva() {
//		return partitaiva;
//	}
//
//	public void setPartitaiva(String partitaiva) {
//		this.partitaiva = partitaiva;
//	}
//
//	public int getFlag() {
//		return flag;
//	}
//
//	public void setFlag(int flag) {
//		this.flag = flag;
//	}
//
//	public String getDescrizione() {
//		return descrizione;
//	}
//
//	public void setDescrizione(String descrizione) {
//		this.descrizione = descrizione;
//	}
//
//	public String getTipo() {
//		return tipo;
//	}
//
//	public void setTipo(String tipo) {
//		this.tipo = tipo;
//	}
//
//	public double getPrezzo() {
//		return prezzo;
//	}
//
//	public void setPrezzo(double prezzo) {
//		this.prezzo = prezzo;
//	}

	public int getIduser() {
		return iduser;
	}
	
	public void setIduser(int iduser) {
		this.iduser=iduser;
	}
	
	public int getIdasset() {
		return idasset;
	}
	
	public void setIdasset(int idasset) {
		this.idasset=idasset;
	}
	
	
	
	
//	public int getIdUser2() {
//		return iduser2;
//	}
//	
//	public void setIdUser2(int iduser2) {
//		this.iduser2=iduser2;
//	}
//	
//	public int getIdAsset2() {
//		return idasset2;
//	}
//	
//	public void setIdAsset2(int idasset2) {
//		this.idasset2=idasset2;
//	}
	
	
	public String getOrainizio() {
		return orainizio;
	}

	public void setOrainizio(String orainizio) {
		this.orainizio = orainizio;
	}

	public String getOrafine() {
		return orafine;
	}

	public void setOrafine(String orafine) {
		this.orafine = orafine;
	}
	
	
	
}
