package com.pCarpet.dto;

public class AssetDTO {

	private long idAsset;
	private String descrizione;
	private String tipo;
	private double prezzo;
	
	public AssetDTO() {
		
	}
	
	public AssetDTO(long idAsset, String tipo, String descrizione, double prezzo) {
		this();
		this.idAsset = idAsset;
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.prezzo=prezzo;
	}
	
	public AssetDTO(String tipo, String descrizione, double prezzo) {
		this();
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.prezzo=prezzo;
	}

	
	
	public long getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(long idAsset) {
		this.idAsset = idAsset;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
	
	
}
