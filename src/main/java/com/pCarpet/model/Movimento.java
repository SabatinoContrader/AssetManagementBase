package com.pCarpet.model;

public class Movimento {

	private long idbadgereader;
	private long idbadge;
	private String orainizio;
	private String orafine;
	
	public Movimento(long idbadgereader, long idbadge, String orainizio, String orafine) {
		this.idbadgereader = idbadgereader;
		this.idbadge = idbadge;
		this.orainizio = orainizio;
		this.orafine = orafine;
	}

	public long getIdbadgereader() {
		return idbadgereader;
	}

	public void setIdbadgereader(long idbadgereader) {
		this.idbadgereader = idbadgereader;
	}

	public long getIdbadge() {
		return idbadge;
	}

	public void setIdbadge(long idbadge) {
		this.idbadge = idbadge;
	}

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
