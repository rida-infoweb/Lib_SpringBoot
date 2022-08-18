package com.mglcl.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
public class Emprunt implements Serializable {
private static final long serialVersionUID = 1L;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="idAdherent")
private Adherent adherent;



@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="idLivre")
private Livre livre;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="idDictionnaire")
private Dictionnaire dictionnaire;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="reference")
private Revue revue;


@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idEmprunt;

@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
@Temporal(TemporalType.DATE)
private Date dateEmprunt;

@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
@Temporal(TemporalType.DATE)
private Date dateRetour;


public Emprunt() {
	super();
	// TODO Auto-generated constructor stub
}


public Emprunt(Adherent adherent, Livre livre, Dictionnaire dictionnaire, Revue revue, Date dateEmprunt, Date dateRetour) {
	super();
	this.adherent = adherent;
	this.livre = livre;
	this.dictionnaire = dictionnaire;
	this.revue = revue;
	this.dateEmprunt = dateEmprunt;
	this.dateRetour = dateRetour;
}


public Emprunt(Adherent adherent, Livre livre, Dictionnaire dictionnaire, Revue revue, int idEmprunt,Date dateEmprunt, Date dateRetour) {
	super();
	this.adherent = adherent;
	this.livre = livre;
	this.dictionnaire = dictionnaire;
	this.revue = revue;
	this.idEmprunt = idEmprunt;
	this.dateEmprunt = dateEmprunt;
	this.dateRetour = dateRetour;
}


}
