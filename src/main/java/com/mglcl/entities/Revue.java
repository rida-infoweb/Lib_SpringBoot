package com.mglcl.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Revue extends Document{
	
private static final long serialVersionUID = 1L;

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idRevue;

@Column(unique= true)
@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
private String reference ;

@OneToMany(mappedBy="revue",fetch = FetchType.LAZY)
private Set<Emprunt> emprunts;

@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
@DateTimeFormat(pattern = "yyyy-MM-dd")
@Temporal(TemporalType.DATE)
private Date anneePublication;

public Revue() {
	super();
}


public Revue(int idRevue, String reference, Date anneePublication,float prixDeVente) {
	super(prixDeVente);
	this.idRevue = idRevue;
	this.reference = reference;
	this.anneePublication = anneePublication;
}

public Revue( String reference, Date anneePublication,float prixDeVente) {
	super(prixDeVente);
	this.reference = reference;
	this.anneePublication = anneePublication;
}


@Override
public String toString() {
	return "Revue [idRevue=" + idRevue + ", reference=" + reference + ", emprunts=" + emprunts + ", anneePublication="
			+ anneePublication + "]";
}



}
