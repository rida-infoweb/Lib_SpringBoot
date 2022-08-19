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

import org.springframework.format.annotation.DateTimeFormat;
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
@DateTimeFormat(pattern = "yyyy-MM-dd")
@Temporal(TemporalType.DATE)
private Date dateEmprunt;

@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
@DateTimeFormat(pattern = "yyyy-MM-dd")
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


public Adherent getAdherent() {
	return adherent;
}


public void setAdherent(Adherent adherent) {
	this.adherent = adherent;
}


public Livre getLivre() {
	return livre;
}


public void setLivre(Livre livre) {
	this.livre = livre;
}


public Dictionnaire getDictionnaire() {
	return dictionnaire;
}


public void setDictionnaire(Dictionnaire dictionnaire) {
	this.dictionnaire = dictionnaire;
}


public Revue getRevue() {
	return revue;
}


public void setRevue(Revue revue) {
	this.revue = revue;
}


public int getIdEmprunt() {
	return idEmprunt;
}


public void setIdEmprunt(int idEmprunt) {
	this.idEmprunt = idEmprunt;
}


public Date getDateEmprunt() {
	return dateEmprunt;
}


public void setDateEmprunt(Date dateEmprunt) {
	this.dateEmprunt = dateEmprunt;
}


public Date getDateRetour() {
	return dateRetour;
}


public void setDateRetour(Date dateRetour) {
	this.dateRetour = dateRetour;
}


@Override
public String toString() {
	return "Emprunt [adherent=" + adherent + ", livre=" + livre + ", dictionnaire=" + dictionnaire + ", revue=" + revue
			+ ", idEmprunt=" + idEmprunt + ", dateEmprunt=" + dateEmprunt + ", dateRetour=" + dateRetour + "]";
}


}
