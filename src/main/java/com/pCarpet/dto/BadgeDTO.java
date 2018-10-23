package com.pCarpet.dto;

public class BadgeDTO {

	private long idBadge;
	private String descrizione;
	private String tipologia;
	
	public BadgeDTO() {
		
	}
	
	public BadgeDTO(long idBadge, String descrizione, String tipologia) {
		this();
		this.idBadge=idBadge;
		this.descrizione=descrizione;
		this.tipologia=tipologia;
		
	}

	public long getIdBadge() {
		return idBadge;
	}

	public void setIdBadge(long idBadge) {
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
