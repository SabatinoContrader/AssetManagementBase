package com.pCarpet.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

//@Data

@Getter
@Setter

@Entity
public class Assegnazione{
	
	private long iduser;
	
//	@ManyToOne
//	private User user;
	
	
	@OneToMany(mappedBy="assegnazione")
	private List<User> user;
	
	@Id
	private long idbadge;
	
	@JoinColumn(name="idbadge", unique=true)
	@OneToOne(cascade=CascadeType.ALL)
	private Badge badge;
	
//	@OneToMany(mappedBy="assegnazione")
//	private List<Badge> listBadge;
	
	

	@Column
	@NotNull
	private String nome;
	
	@Column
	@NotNull
	private String cognome;
	
	@Column
	@NotNull
	private String dataassegnazione;
	
	public Assegnazione() {
		
	}
	
	
	public Assegnazione(long iduser,long idbadge, String dataassegnazione) {
		this();
		
    	//badge.setIdBadge(idbadge);
        this.dataassegnazione = dataassegnazione;
        this.iduser=iduser;
        //user.setIduser(iduser);
        this.idbadge=idbadge;
	}
	
    public Assegnazione(long iduser,long idbadge,String nome, String cognome,String dataassegnazione) {
    	this();
        this.iduser=iduser;
        this.idbadge=idbadge;
    	//user.setIduser(iduser);
    	this.nome=nome;
    	this.cognome=cognome;
        this.dataassegnazione = dataassegnazione;
    }
    
	@Override
    public String toString() {
        return "\nIdUser:" + /*user.getIduser()*/"" + "\n1)IdBadge: " + ""/*badge.getIdBadge()*/ + "\n2)Nome: "+nome+"\n3)Cognome: "+cognome+"\n4)Data assegnazione: " + dataassegnazione +"\n";
    }
}
