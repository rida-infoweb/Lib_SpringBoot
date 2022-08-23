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
public class Langue implements Serializable {

private static final long serialVersionUID = 1L;

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idLangue;

@Column(unique= true)
@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
private String langue;

@OneToMany (targetEntity = Dictionnaire.class,mappedBy = "langue",fetch = FetchType.LAZY)
private Collection<Dictionnaire> dictionnaires;

public Langue() {
	super();
}


public int getIdLangue() {
	return idLangue;
}

public void setIdLangue(int idLangue) {
	this.idLangue = idLangue;
}

public String getLangue() {
	return langue;
}

public void setLangue(String langue) {
	this.langue = langue;
}

public Collection<Dictionnaire> getDictionnaires() {
	return dictionnaires;
}

public void setDictionnaires(Collection<Dictionnaire> dictionnaires) {
	this.dictionnaires = dictionnaires;
}


public static long getSerialversionuid() {
	return serialVersionUID;
}



}