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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Movimento {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idmovimento;
	
	@Column
	@NotNull
	private long idbadgereader;
	
	@Column
	@NotNull
	private long idbadge;
	
	@Column(name="datainizio")
	@NotNull
	private String orainizio;
	
	@Column(name="datafine")
	@NotNull
	private String orafine;
	


	
	
	
	
	
}
