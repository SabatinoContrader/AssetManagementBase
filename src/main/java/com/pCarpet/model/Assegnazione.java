package com.pCarpet.model;

public class Assegnazione {

	private int iduser;
	private int idbadge;
	private String nome;
	private String cognome;
	private String dataassegnazione;
	
	public Assegnazione() {
		
	}
	
	
	public Assegnazione(int iduser,int idbadge, String dataassegnazione) {
		this();
    	this.iduser = iduser;
    	this.idbadge = idbadge;
        this.dataassegnazione = dataassegnazione;
	}
	
    public Assegnazione(int iduser,int idbadge,String nome, String cognome,String dataassegnazione) {
    	this();
    	this.iduser = iduser;
    	this.idbadge = idbadge;
    	this.nome=nome;
    	this.cognome=cognome;
        this.dataassegnazione = dataassegnazione;
    }
    public int getIdUtente() {
    	return iduser;
    }
    public int getIdBadge() {
    	return idbadge;
    }
   
    public void setIdUtente(int idUtente) {
    	this.iduser=idUtente;
    }
    public void setIdBadge(int idBadge) {
    	this.idbadge=idBadge;
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
	
	
	
	public String getDataassegnazione() {
		return dataassegnazione;
	}
	public void setDataassegnazione(String dataassegnazione) {
		this.dataassegnazione = dataassegnazione;
	}
	@Override
    public String toString() {
        return "\nIdUser:" + iduser + "\n1)IdBadge: " + idbadge + "\n2)Nome: "+nome+"\n3)Cognome: "+cognome+"\n4)Data assegnazione: " + dataassegnazione +"\n";
    }
}
