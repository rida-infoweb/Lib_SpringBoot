package com.mglcl.entities;

import java.io.Serializable;
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

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
public class Adherent implements Serializable{
	

private static final long serialVersionUID = 1L;

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idAdherent;

@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
private String nom;

@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
private String prenom;

@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
private String adresse;

@Column(unique= true)
@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
private String cin;

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@NotNull (message = "Ce champ est obligatoire !")
private Date dateNaissance;

@OneToMany(mappedBy="adherent",fetch = FetchType.LAZY)
private Set<Emprunt> emprunts;


public Adherent() {
	super();
	//TODO Auto-generated constructor stub
}

public Adherent(String nom, String prenom, String adresse, String cin, Date dateNaissance) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
	this.cin = cin;
	this.dateNaissance = dateNaissance;
}


public Adherent(int idAdherent, String nom, String prenom, String adresse, String cin, Date dateNaissance) {
	super();
	this.idAdherent = idAdherent;
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
	this.cin = cin;
	this.dateNaissance = dateNaissance;
}




public int getIdAdherent() {
	return idAdherent;
}


public void setIdAdherent(int idAdherent) {
	this.idAdherent = idAdherent;
}


public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}


public String getPrenom() {
	return prenom;
}


public void setPrenom(String prenom) {
	this.prenom = prenom;
}


public String getAdresse() {
	return adresse;
}


public void setAdresse(String adresse) {
	this.adresse = adresse;
}


public String getCin() {
	return cin;
}


public void setCin(String cin) {
	this.cin = cin;
}


public Date getDateNaissance() {
	return dateNaissance;
}


public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}


public Set<Emprunt> getEmprunts() {
	return emprunts;
}


public void setEmprunts(Set<Emprunt> emprunts) {
	this.emprunts = emprunts;
}

@Override
public String toString() {
	return "Adherent [idAdherent=" + idAdherent + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
			+ ", cin=" + cin + ", dateNaissance=" + dateNaissance + ", emprunts=" + emprunts + "]";
}


}
