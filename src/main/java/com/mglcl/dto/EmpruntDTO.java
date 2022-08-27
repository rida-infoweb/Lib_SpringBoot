package com.mglcl.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.mglcl.entities.Adherent;
import com.mglcl.entities.Dictionnaire;
import com.mglcl.entities.Livre;
import com.mglcl.entities.Revue;

public class EmpruntDTO implements Serializable {

 
private int idAdherent;

private int idEmprunt;
private Date dateEmprunt;
private Date dateRetour;
private int  idLivre;
private int idDictionnaire;
private int idRevue;

public int getIdLivre() {
	return idLivre;
}

public void setIdLivre(int idLivre) {
	this.idLivre = idLivre;
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

public int getIdAdherent() {
	return idAdherent;
}

public void setIdAdherent(int idAdherent) {
	this.idAdherent = idAdherent;
}

public int getIdDictionnaire() {
	return idDictionnaire;
}

public void setIdDictionnaire(int idDictionnaire) {
	this.idDictionnaire = idDictionnaire;
}

public int getIdRevue() {
	return idRevue;
}

public void setIdRevue(int idRevue) {
	this.idRevue = idRevue;
}





}
