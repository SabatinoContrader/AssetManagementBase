package com.pCarpet.dto;

import java.net.URL;

public class AssetDTO {

	private long idAsset;
	private String descrizione;
	private String tipo;
	private double prezzo;
	private long flag;
	private URL url;
	
	public AssetDTO() {
		
	}
	
	
	
	public AssetDTO(long idAsset, String tipo, String descrizione, double prezzo, long flag) {
		this();
		this.idAsset = idAsset;
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.prezzo=prezzo;
		this.flag=flag;
	}
	
	public AssetDTO(String tipo, String descrizione, double prezzo) {
		this();
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.prezzo=prezzo;
	}

	public AssetDTO(String tipo, String descrizione, double prezzo, URL url) {
		this();
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.prezzo=prezzo;
		this.url=url;
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

	public long getFlag() {
		return flag;
	}

	public void setFlag(long flag) {
		this.flag = flag;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}



	public URL getUrl() {
		return url;
	}



	public void setUrl(URL url) {
		this.url = url;
	}

	
	
	
	
	
}
