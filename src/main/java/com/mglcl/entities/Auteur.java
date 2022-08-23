package com.mglcl.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Auteur implements Serializable {

private static final long serialVersionUID = 1L;

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idAuteur;

@Column(unique= true)
@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
private String auteur;

@OneToMany (targetEntity = Livre.class, mappedBy = "auteur",fetch = FetchType.LAZY)
private Collection<Livre> livres;

public Auteur() {
	super();
	// TODO Auto-generated constructor stub
}

public int getIdAuteur() {
	return idAuteur;
}

public void setIdAuteur(int idAuteur) {
	this.idAuteur = idAuteur;
}

public String getAuteur() {
	return auteur;
}

public void setAuteur(String auteur) {
	this.auteur = auteur;
}

public Collection<Livre> getLivres() {
	return livres;
}

public void setLivres(Collection<Livre> livres) {
	this.livres = livres;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}




}
