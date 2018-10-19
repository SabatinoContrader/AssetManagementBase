package com.pCarpet.dto;

public class BadgeReaderDTO {

	private int idBadgeReader;
	private int idAsset;
	private String descrizione;
	private String tipologia;
	
	private int idAsset2;
	private String descrizione2;
	private String tipo2;
	private double prezzo2;
	
	public BadgeReaderDTO() {
		
	}
	
	public BadgeReaderDTO(int idBadgeReader, int idAsset, String descrizione, String tipologia) {
		this();
		this.idBadgeReader = idBadgeReader;
		this.idAsset = idAsset;
		this.descrizione = descrizione;
		this.tipologia = tipologia;
	}
	
	
	public BadgeReaderDTO(int idBadgeReader, int idAsset, String descrizione, String tipologia, 
			int idAsset2, String descrizione2, String tipo2, double prezzo2) {
		
		this();
		this.idBadgeReader = idBadgeReader;
		this.idAsset = idAsset;
		this.descrizione = descrizione;
		this.tipologia = tipologia;
		
		this.idAsset2=idAsset2;
		this.descrizione2=descrizione2;
		this.tipo2=tipo2;
		this.prezzo2=prezzo2;
		
	}

	public int getIdBadgeReader() {
		return idBadgeReader;
	}

	public void setIdBadgeReader(int idBadgeReader) {
		this.idBadgeReader = idBadgeReader;
	}

	public int getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(int idAsset) {
		this.idAsset = idAsset;
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

	public int getIdAsset2() {
		return idAsset2;
	}

	public void setIdAsset2(int idAsset2) {
		this.idAsset2 = idAsset2;
	}

	public String getDescrizione2() {
		return descrizione2;
	}

	public void setDescrizione2(String descrizione2) {
		this.descrizione2 = descrizione2;
	}

	public String getTipo2() {
		return tipo2;
	}

	public void setTipo2(String tipo2) {
		this.tipo2 = tipo2;
	}

	public double getPrezzo2() {
		return prezzo2;
	}

	public void setPrezzo2(double prezzo2) {
		this.prezzo2 = prezzo2;
	}
	
	
	
	
	
	
	
	
}
