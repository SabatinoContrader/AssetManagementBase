package com.pCarpet.dto;

public class BadgeDTO {

	private int idBadge;
	private String descrizione;
	private String tipologia;
	
	public BadgeDTO() {
		
	}
	
	public BadgeDTO(int idBadge, String descrizione, String tipologia) {
		this();
		this.idBadge=idBadge;
		this.descrizione=descrizione;
		this.tipologia=tipologia;
		
	}

	public int getIdBadge() {
		return idBadge;
	}

	public void setIdBadge(int idBadge) {
		this.idBadge = idBadge;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	
	
}
