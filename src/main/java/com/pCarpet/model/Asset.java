package com.pCarpet.model;

public class Asset {
	private long idAsset;
	private String descrizione;
	private String tipo;
	private double prezzo;
	
	public Asset() {
		
	}
	
	public Asset(long idAsset, String descrizione, String tipo, double prezzo) {
		this();
		this.idAsset = idAsset;
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
	
	@Override
    public String toString() {
        return "\nId:" + idAsset + "\n1)Tipologia: " + tipo + "\n2)Descrizione: " + descrizione + "\n";
    }
	
	
}