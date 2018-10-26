package com.pCarpet.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
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
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Assegnazione{
	
	private long iduser;
	
//	@ManyToOne
//	private User user;
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idassegnazione;
	
	
	@OneToMany(mappedBy="assegnazione")
	private List<User> user;
	

	private long idbadge;
	
	@OneToMany(mappedBy="assegnazione")
	private List<Badge> badge;
	
//	@JoinColumn(name="idbadge", unique=true)
//	@OneToOne(cascade=CascadeType.ALL)
//	private Badge badge;
	
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
	
	@Column
	@NotNull
    private long flag=1l;
	
//	public Assegnazione() {
//		
//	}
//	
//	
//	public Assegnazione(long iduser,long idbadge, String dataassegnazione) {
//		this();
//		
//    	//badge.setIdBadge(idbadge);
//        this.dataassegnazione = dataassegnazione;
//        this.iduser=iduser;
//        //user.setIduser(iduser);
//        this.idbadge=idbadge;
//	}
//	
//    public Assegnazione(long iduser,Badge badge,String nome, String cognome,String dataassegnazione,long flag) {
//    	this();
//        this.iduser=iduser;
//        this.badge=badge;
//        //this.idbadge=idbadge;
//    	//user.setIduser(iduser);
//    	this.nome=nome;
//    	this.cognome=cognome;
//        this.dataassegnazione = dataassegnazione;
//        this.flag= flag;
//    }
    
	@Override
    public String toString() {
        return "\nIdUser:" + /*user.getIduser()*/"" + "\n1)IdBadge: " + ""/*badge.getIdBadge()*/ + "\n2)Nome: "+nome+"\n3)Cognome: "+cognome+"\n4)Data assegnazione: " + dataassegnazione +"\n";
    }
}
