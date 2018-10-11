package com.pCarpet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@Data

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class User {
	
		
		@Id
		@Column
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int iduser;
		
		@Column
		@NotNull
	    private String username;  
		
		@Column
		@NotNull
	    private String password;
		
		@Column
	    private String nome;
		
		@Column
	    private String cognome;
		
		@Column
	    private String telefono;
		
		@Column
	    private String mail;
		
		@Column
	    private String partitaiva;
		
		@Column
	    private String ruolo;

	}

