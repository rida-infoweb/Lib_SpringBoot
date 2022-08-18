package com.mglcl.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
public class Livre extends Document  {
	
private static final long serialVersionUID = 1L;

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idLivre;

@Column(unique= true)
@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
private int identificateurLivre ;

@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
private int nombrePage;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="idAuteur")
private Auteur auteur;

@OneToMany(mappedBy="livre",fetch = FetchType.LAZY)
private Set<Emprunt> emprunts;

public Livre() {
	super();
}


public Livre(int idLivre,int identificateurLivre, int nombrePage, Auteur auteur,float prixDeVente) {
	super(prixDeVente);
	this.idLivre = idLivre;
	this.identificateurLivre = identificateurLivre;
	this.nombrePage = nombrePage;
	this.auteur = auteur;
}


public Livre(int identificateurLivre, int nombrePage, Auteur auteur,float prixDeVente) {
	super(prixDeVente);
	this.identificateurLivre = identificateurLivre;
	this.nombrePage = nombrePage;
	this.auteur = auteur;
}


public int getIdLivre() {
	return idLivre;
}


public void setIdLivre(int idLivre) {
	this.idLivre = idLivre;
}


public int getIdentificateurLivre() {
	return identificateurLivre;
}


public void setIdentificateurLivre(int identificateurLivre) {
	this.identificateurLivre = identificateurLivre;
}


public int getNombrePage() {
	return nombrePage;
}


public void setNombrePage(int nombrePage) {
	this.nombrePage = nombrePage;
}


public Auteur getAuteur() {
	return auteur;
}


public void setAuteur(Auteur auteur) {
	this.auteur = auteur;
}


public Set<Emprunt> getEmprunts() {
	return emprunts;
}


public void setEmprunts(Set<Emprunt> emprunts) {
	this.emprunts = emprunts;
}


@Override
public String toString() {
	return "Livre [idLivre=" + idLivre + ", identificateurLivre=" + identificateurLivre + ", nombrePage=" + nombrePage
			+ ", auteur=" + auteur + ", emprunts=" + emprunts + "]";
}



}
