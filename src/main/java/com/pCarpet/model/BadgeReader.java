package com.pCarpet.model;

public class BadgeReader {
	
	private long idBadgeReader;
	private long idAsset;
	private String descrizione;
	private String tipologia;
	
	public BadgeReader() {
		
	}
	
	public BadgeReader(long idBadgeReader, long idAsset, String descrizione, String tipologia) {
		this();
		this.idBadgeReader = idBadgeReader;
		this.idAsset=idAsset;
		this.descrizione=descrizione;
		this.tipologia=tipologia;
	}

	

	public long getIdBadgeReader() {
		return idBadgeReader;
	}



	public void setIdBadgeReader(long idBadgeReader) {
		this.idBadgeReader = idBadgeReader;
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



	public String getTipologia() {
		return tipologia;
	}



	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + Integer.parseInt(idAsset+"");
		result = prime * result + Integer.parseInt(idBadgeReader+"");
		result = prime * result + ((tipologia == null) ? 0 : tipologia.hashCode());
		return result;
	}

	@Override
    public boolean equals(Object o) {
		
		if(this==o)return true;
		if(!(this instanceof BadgeReader)) return false;
		
		BadgeReader br=(BadgeReader)o;
		
		if(idBadgeReader==br.idBadgeReader && idAsset==br.idAsset) return true;
		
		return false;
    }
	
	 @Override
	    public String toString() {
	        return "1)ID BadgeReader: "+idBadgeReader+"\n2)ID Asset: " + idAsset + "\n3)Descrizione: "+descrizione+"\n4)Tipologia: "+tipologia+"\n";

	    }
	
	
	
}
