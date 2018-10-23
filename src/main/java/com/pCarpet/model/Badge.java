package com.pCarpet.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor

@Entity
public class Badge {
	
	@Id
	@Column(name="idbadge")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBadge;
	
	@Column
	@NotNull
	private String descrizione;
	
	@Column
	@NotNull
	private String tipologia;
	
//	@ManyToMany(mappedBy="b")
//	List<User> userl=new LinkedList<>();
	

//	@OneToOne(mappedBy="badge")
//	private Assegnazione assegnazione;
	
//	@ManyToOne()
//	private Assegnazione assegnazione;
	
//	public Badge() {
//		
//	}
//
//	
//	
//	
//	public Badge(long idBadge, String descrizione, String tipologia) {
//		this();
//		this.idBadge = idBadge;
//		this.descrizione = descrizione;
//		this.tipologia = tipologia;
//	}
	
	
	@Override
    public String toString() {
        return "\nId:" + idBadge + "\n1)Tipologia: " + tipologia + "\n2)Descrizione: " + descrizione + "\n";
    }
	
	
}